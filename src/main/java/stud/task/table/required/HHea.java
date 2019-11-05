package stud.task.table.required;

import org.apache.log4j.Logger;
import stud.task.exception.TTFTableFormatException;
import stud.task.exception.StreamOutOfFileException;
import stud.task.table.domain.HeadTable;
import stud.task.table.MainTable;
import stud.task.types.*;
import stud.task.util.TTFInputStream;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringJoiner;

import static org.apache.log4j.Level.ERROR;

public class HHea extends MainTable {

    private static final Logger LOGGER = Logger.getLogger(HHea.class);
    public static final Tag TAG = new Tag(0x68686561);

    private UInt16 majorVersion;
    private UInt16 minorVersion;
    private FWord ascender;
    private FWord descender;
    private FWord lineCap;
    private UFWord advanceWidthMax;
    private FWord minLeftSideBearing;
    private FWord minRightSideBearing;
    private FWord xMaxExtent;
    private Int16 caretSlopeRise;
    private Int16 caretSlopeRun;
    private Int16 caretOffset;
    private Int16[] reserved = new Int16[4];
    private Int16 metricDataFormat;
    private UInt16 numberOfHMetrics;

    public HHea(HeadTable headTable) {
        super(headTable);
    }

    @Override
    public void read(TTFInputStream in) throws IOException, TTFTableFormatException {
        try {
            long start = in.available();

            majorVersion = in.readUInt16();
            minorVersion = in.readUInt16();
            ascender = in.readFWord();
            descender = in.readFWord();
            lineCap = in.readFWord();
            advanceWidthMax = in.readUFWord();
            minLeftSideBearing = in.readFWord();
            minRightSideBearing = in.readFWord();
            xMaxExtent = in.readFWord();
            caretSlopeRise = in.readInt16();
            caretSlopeRun = in.readInt16();
            caretOffset = in.readInt16();
            in.readInt16(reserved);
            metricDataFormat = in.readInt16();
            numberOfHMetrics = in.readUInt16();

            checkSize(start - in.available());
        } catch (StreamOutOfFileException e) {
            LOGGER.log(ERROR, e);
        }
    }

    public UInt16 getMajorVersion() {
        return majorVersion;
    }

    public UInt16 getMinorVersion() {
        return minorVersion;
    }

    public FWord getAscender() {
        return ascender;
    }

    public FWord getDescender() {
        return descender;
    }

    public FWord getLineCap() {
        return lineCap;
    }

    public UFWord getAdvanceWidthMax() {
        return advanceWidthMax;
    }

    public FWord getMinLeftSideBearing() {
        return minLeftSideBearing;
    }

    public FWord getMinRightSideBearing() {
        return minRightSideBearing;
    }

    public FWord getxMaxExtent() {
        return xMaxExtent;
    }

    public Int16 getCaretSlopeRise() {
        return caretSlopeRise;
    }

    public Int16 getCaretSlopeRun() {
        return caretSlopeRun;
    }

    public Int16 getCaretOffset() {
        return caretOffset;
    }

    public Int16 getMetricDataFormat() {
        return metricDataFormat;
    }

    public UInt16 getNumberOfHMetrics() {
        return numberOfHMetrics;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", HHea.class.getSimpleName() + "[", "]")
                .add("majorVersion=" + majorVersion)
                .add("minorVersion=" + minorVersion)
                .add("ascender=" + ascender)
                .add("descender=" + descender)
                .add("lineCap=" + lineCap)
                .add("advanceWidthMax=" + advanceWidthMax)
                .add("minLeftSideBearing=" + minLeftSideBearing)
                .add("minRightSideBearing=" + minRightSideBearing)
                .add("xMaxExtent=" + xMaxExtent)
                .add("caretSlopeRise=" + caretSlopeRise)
                .add("caretSlopeRun=" + caretSlopeRun)
                .add("caretOffset=" + caretOffset)
                .add("reserved=" + Arrays.toString(reserved))
                .add("metricDataFormat=" + metricDataFormat)
                .add("numberOfHMetrics=" + numberOfHMetrics)
                .toString();
    }
}
