package stud.task.table.required;

import org.apache.log4j.Logger;
import stud.task.exception.TTFTableFormatException;
import stud.task.table.MainTable;
import stud.task.table.domain.HeadTable;
import stud.task.types.*;
import stud.task.exception.StreamOutOfFileException;
import stud.task.util.TTFInputStream;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringJoiner;

import static org.apache.log4j.Level.ERROR;
import static stud.task.util.ConvertPrimitives.*;

public class Head extends MainTable {

    private static final Logger LOGGER = Logger.getLogger(Head.class);
    public static final Tag TAG = new Tag(0x68656164);

    private UInt16 majorVersion;
    private UInt16 minorVersion;
    private Fixed fontRevision;
    private UInt32 checkSumAdjustment;
    private UInt32 magicNumber;
    private boolean[] flags = new boolean[16];
    private UInt16 unitsPerEm;
    private LongDateTime created;
    private LongDateTime modified;
    private Int16 xMin;
    private Int16 yMin;
    private Int16 xMax;
    private Int16 yMax;
    private boolean[] macStyle = new boolean[16];
    private UInt16 lowerRecPPEM;
    private Int16 fontDirectionHint;
    private Int16 indexToLocFormat;
    private Int16 glyphDataFormat;

    public Head(HeadTable table) {
        super(table);
    }

    @Override
    public void read(TTFInputStream in) throws IOException, TTFTableFormatException {
        try {
            long start = in.available();

            majorVersion = in.readUInt16();
            minorVersion=  in.readUInt16();
            fontRevision = in.readFixed();
            checkSumAdjustment = in.readUInt32();
            magicNumber = in.readUInt32();
            shortToBooleanArr(
                    in.readInt16().shortValue(),
                    flags
                    );
            unitsPerEm = in.readUInt16();
            created = in.readLongDateTime();
            modified = in.readLongDateTime();
            xMin = in.readInt16();
            yMin = in.readInt16();
            xMax = in.readInt16();
            yMax = in.readInt16();
            shortToBooleanArr(
                    in.readInt16().shortValue(),
                    macStyle
            );
            lowerRecPPEM = in.readUInt16();
            fontDirectionHint = in.readInt16();
            indexToLocFormat = in.readInt16();
            if (indexToLocFormat.shortValue() > 1 || indexToLocFormat.shortValue() < 0)
                throw new TTFTableFormatException(String.format("Version loca: actually: %d, expect: 1 || 0", indexToLocFormat));
            glyphDataFormat = in.readInt16();

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

    public Fixed getFontRevision() {
        return fontRevision;
    }

    public UInt32 getCheckSumAdjustment() {
        return checkSumAdjustment;
    }

    public UInt32 getMagicNumber() {
        return magicNumber;
    }

    public boolean[] getFlags() {
        return flags;
    }

    public UInt16 getUnitsPerEm() {
        return unitsPerEm;
    }

    public LongDateTime getCreated() {
        return created;
    }

    public LongDateTime getModified() {
        return modified;
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

    public boolean[] getMacStyle() {
        return macStyle;
    }

    public boolean macStyleIsBild() {
        return macStyle[0];
    }

    public boolean macStyleIsItalic() {
        return macStyle[1];
    }

    public boolean macStyleIsUnderline() {
        return macStyle[2];
    }

    public boolean macStyleIsOutLine() {
        return macStyle[3];
    }

    public boolean macStyleIsShadow() {
        return macStyle[4];
    }

    public boolean macStyleIsCondensed() {
        return macStyle[5];
    }

    public boolean macStyleIsExtended() {
        return macStyle[6];
    }

    public UInt16 getLowerRecPPEM() {
        return lowerRecPPEM;
    }

    public Int16 getFontDirectionHint() {
        return fontDirectionHint;
    }

    public Int16 getIndexToLocFormat() {
        return indexToLocFormat;
    }

    public Int16 getGlyphDataFormat() {
        return glyphDataFormat;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Head.class.getSimpleName() + "[", "]")
                .add("majorVersion=" + majorVersion)
                .add("minorVersion=" + minorVersion)
                .add("fontRevision=" + fontRevision)
                .add("checkSumAdjustment=" + checkSumAdjustment)
                .add("magicNumber=" + magicNumber)
                .add("flags=" + Arrays.toString(flags))
                .add("unitsPerEm=" + unitsPerEm)
                .add("created=" + created)
                .add("modified=" + modified)
                .add("xMin=" + xMin)
                .add("yMin=" + yMin)
                .add("xMax=" + xMax)
                .add("yMax=" + yMax)
                .add("macStyle=" + Arrays.toString(macStyle))
                .add("lowerRecPPEM=" + lowerRecPPEM)
                .add("fontDirectionHint=" + fontDirectionHint)
                .add("indexToLocFormat=" + indexToLocFormat)
                .add("glyphDataFormat=" + glyphDataFormat)
                .toString();
    }
}
