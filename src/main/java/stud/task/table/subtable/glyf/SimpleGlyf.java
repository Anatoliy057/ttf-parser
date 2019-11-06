package stud.task.table.subtable.glyf;

import org.apache.log4j.Logger;
import stud.task.util.StreamOutOfFileException;
import stud.task.table.TTFTableFormatException;
import stud.task.model.Contour;
import stud.task.model.Glyph;
import stud.task.model.GlyphPoint;
import stud.task.types.Int16;
import stud.task.types.UInt16;
import stud.task.types.UInt8;
import stud.task.util.TTFInputStream;

import java.io.IOException;
import java.util.*;

import static org.apache.log4j.Level.ERROR;
import static stud.task.util.ConvertPrimitives.*;

public class SimpleGlyf extends SubTableGlyf {

    private static final Logger LOGGER = Logger.getLogger(SimpleGlyf.class);

    private static final int X_SHORT_VECTOR = 1;
    private static final int Y_SHORT_VECTOR = 2;
    private static final int X_IS_SAME_OR_POSITIVE_X_SHORT_VECTOR = 4;
    private static final int Y_IS_SAME_OR_POSITIVE_Y_SHORT_VECTOR = 5;

    private Int16 xMin;
    private Int16 yMin;
    private Int16 xMax;
    private Int16 yMax;
    private UInt16[] endPtsOfContours;
    private UInt16 instructionLength;
    private UInt8[] instructions;
    private List<Boolean> onCurvePoint;
    private List<Int16> xCoordinates;
    private List<Int16> yCoordinates;

    private UInt16 numberOfPoints;

    public SimpleGlyf(long length, Int16 numberOfContours) throws TTFTableFormatException {
        super(length, numberOfContours);
    }

    @Override
    public void read(TTFInputStream in) throws IOException, TTFTableFormatException {
        try {
            long start = in.available() + 2;
            xMin = in.readInt16();
            yMin = in.readInt16();
            xMax = in.readInt16();
            yMax = in.readInt16();
            endPtsOfContours = new UInt16[numberOfContours.shortValue()];
            in.readUInt16(endPtsOfContours);

            numberOfPoints = endPtsOfContours[endPtsOfContours.length - 1];

            instructionLength = in.readUInt16();
            instructions = new UInt8[instructionLength.unsigned()];
            in.readUInt8(instructions);
            int i = 0;
            List<Boolean[]> flags = new LinkedList<>();
            while (i <= numberOfPoints.unsigned()) {
                Boolean[] flag = convert(byteToBooleanArr(in.readUInt8().byteValue()));
                flags.add(flag);
                i++;
                if (flag[3]) {
                    UInt8 repeat = in.readUInt8();
                    for (int j = 0; j < repeat.unsigned(); j++) {
                        flags.add(flag);
                    }
                    i += repeat.unsigned();
                }
            }
            onCurvePoint = new ArrayList<>();
            flags.forEach(f -> onCurvePoint.add(f[0]));

            xCoordinates = readCoordinates(in, flags, X_SHORT_VECTOR, X_IS_SAME_OR_POSITIVE_X_SHORT_VECTOR);
            yCoordinates = readCoordinates(in, flags, Y_SHORT_VECTOR, Y_IS_SAME_OR_POSITIVE_Y_SHORT_VECTOR);

            long actuallySize = start - in.available();
            in.skip(checkSize(actuallySize));
        } catch (StreamOutOfFileException e) {
            LOGGER.log(ERROR, e);
        }
    }

    private Boolean[] convert(boolean[] arr) {
        Boolean[] newArr = new Boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[arr.length - 1 - i];
        }
        return newArr;
    }

    private List<Int16> readCoordinates(TTFInputStream in, List<Boolean[]> flags, final int SHORT_VECTOR, final int IS_SAME_OR_POSITIVE_SHORT_VECTOR) throws IOException, StreamOutOfFileException {
        List<Int16> coords = new ArrayList<>();
        Int16 crd16 = new Int16((short) 0);
        UInt8 crd8;
        for (Boolean[] flag:
                flags) {
            if (flag[SHORT_VECTOR]) {
                crd8 = in.readUInt8();
                if (flag[IS_SAME_OR_POSITIVE_SHORT_VECTOR]) {
                    crd16 = new Int16((short) (crd16.shortValue() + crd8.unsigned()));
                } else {
                    crd16 = new Int16((short) (crd16.shortValue() + crd8.unsigned() * -1));
                }
            } else {
                if (!flag[IS_SAME_OR_POSITIVE_SHORT_VECTOR]) {
                    crd16 = new Int16((short) (crd16.shortValue() + in.readInt16().shortValue()));
                }
            }
            coords.add(crd16);
        }
        return coords;
    }

    public Int16 getNumberOfContours() {
        return numberOfContours;
    }

    public Int16 getxMin() {
        return xMin;
    }

    public Int16 getyMin() {
        return yMin;
    }

    public Int16 getxMax() {
        return xMax;
    }

    public Int16 getyMax() {
        return yMax;
    }

    public UInt16[] getEndPtsOfContours() {
        return endPtsOfContours;
    }

    public UInt16 getInstructionLength() {
        return instructionLength;
    }

    public UInt8[] getInstructions() {
        return instructions;
    }

    public List<Boolean> getOnCurvePoint() {
        return onCurvePoint;
    }

    public List<Int16> getxCoordinates() {
        return xCoordinates;
    }

    public List<Int16> getyCoordinates() {
        return yCoordinates;
    }

    public UInt16 getNumberOfPoints() {
        return numberOfPoints;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SimpleGlyf.class.getSimpleName() + "[", "]")
                .add("numberOfContours=" + numberOfContours)
                .add("xMin=" + xMin)
                .add("yMin=" + yMin)
                .add("xMax=" + xMax)
                .add("yMax=" + yMax)
                .add("endPtsOfContours=" + Arrays.toString(endPtsOfContours))
                .add("instructionLength=" + instructionLength)
                .add("instructions=" + Arrays.toString(instructions))
                .add("onCurvePoint=" + onCurvePoint)
                .add("xCoordinates=" + xCoordinates)
                .add("yCoordinates=" + yCoordinates)
                .add("numberOfPoints=" + numberOfPoints)
                .toString();
    }

    @Override
    public Glyph getGlyph() {
        List<Contour> contours = new LinkedList<>();
        List<GlyphPoint> points = new LinkedList<>();

        Iterator<UInt16> it = Arrays.asList(endPtsOfContours).iterator();
        UInt16 end = it.next();
        for (int i = 0; i < numberOfPoints.unsigned() + 1; i++) {
            if (end.unsigned() - i > 0) {
                points.add(new GlyphPoint(
                        xCoordinates.get(i).intValue(),
                        yCoordinates.get(i).intValue(),
                        !onCurvePoint.get(i))
                );
            } else {
                Contour contour = new Contour(points, false);
                contours.add(contour);
                points = new LinkedList<>();
                if (it.hasNext())
                    end = it.next();
                else break;
            }
        }
        return new Glyph(
                xMin.intValue(),
                yMin.intValue(),
                xMax.intValue(),
                yMax.intValue(),
                contours
        );
    }
}
