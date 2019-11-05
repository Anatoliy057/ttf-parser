package stud.task.table.subtable.cmap;

import org.apache.log4j.Logger;
import stud.task.encoding.EncodingFormat4;
import stud.task.encoding.Encoding;
import stud.task.exception.TTFTableFormatException;
import stud.task.exception.StreamOutOfFileException;
import stud.task.table.required.CMap;
import stud.task.types.Int16;
import stud.task.types.UInt16;
import stud.task.util.TTFInputStream;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringJoiner;

import static org.apache.log4j.Level.WARN;

public class SegMap extends SubTableCMap {

    private static final Logger LOGGER = Logger.getLogger(SegMap.class);

    private UInt16 format = new UInt16((short) 0x4);
    private UInt16 length;
    private UInt16 lang = new UInt16((short) 0x0);
    private UInt16 segCountX2;
    private UInt16 searchRange;
    private UInt16 entrySelector;
    private UInt16 rangeShift;
    private UInt16[] endCode;
    private UInt16 reservedPad = new UInt16((short) 0x0);
    private UInt16[] startCode;
    private Int16[] idDelta;
    private UInt16[] idRangeOffset;
    private UInt16[] glyphIdArray;

    private int segCount;

    public SegMap(CMap.EncodingRecord record) {
        super(record);
    }

    @Override
    public void read(TTFInputStream in) throws IOException, TTFTableFormatException {
        try {
            long start = in.available();
            UInt16 format = in.readUInt16();
            if (!this.format.equals(format)) {
                throw new TTFTableFormatException("Format subtable SegMap by CMap is wrong", format, this.format);
            }
            length = in.readUInt16();
            UInt16 lang = in.readUInt16();
            if (!this.lang.equals(lang)) {
                LOGGER.log(WARN, String.format("Field lang subtable format %s by cmap is not 0", this.format));
            }
            this.lang = lang;
            segCountX2 = in.readUInt16();
            segCount = segCountX2.unsigned()/2;
            searchRange = in.readUInt16();
            entrySelector = in.readUInt16();
            rangeShift = in.readUInt16();
            endCode = new UInt16[segCount];
            in.readUInt16(endCode);
            UInt16 reservedPad = in.readUInt16();
            if (!this.reservedPad.equals(reservedPad)) {
                LOGGER.log(WARN, String.format("Field reservedPad subtable format %s by cmap is not 0", this.format));
            }
            this.reservedPad = reservedPad;
            startCode = new UInt16[segCount];
            in.readUInt16(startCode);
            idDelta = new Int16[segCount];
            in.readInt16(idDelta);
            idRangeOffset = new UInt16[segCount];
            in.readUInt16(idRangeOffset);
            long end = in.available();
            long size = length.unsigned() - (start - end);
            glyphIdArray = new UInt16[(int) (size/2)];
            in.readUInt16(glyphIdArray);
            checkSize(start - in.available(), length.unsigned());
        } catch (StreamOutOfFileException e) {
            e.printStackTrace();
        }
    }

    public UInt16 getLength() {
        return length;
    }

    public UInt16 getLang() {
        return lang;
    }

    public UInt16 getSegCountX2() {
        return segCountX2;
    }

    public UInt16 getSearchRange() {
        return searchRange;
    }

    public UInt16 getEntrySelector() {
        return entrySelector;
    }

    public UInt16[] getEndCode() {
        return endCode;
    }

    public UInt16 getReservedPad() {
        return reservedPad;
    }

    public UInt16[] getStartCode() {
        return startCode;
    }

    public Int16[] getIdDelta() {
        return idDelta;
    }

    public UInt16[] getIdRangeOffset() {
        return idRangeOffset;
    }

    public UInt16[] getGlyphIdArray() {
        return glyphIdArray;
    }

    public int getSegCount() {
        return segCount;
    }

    public UInt16 getRangeShift() {
        return rangeShift;
    }

    @Override
    public UInt16 getFormat() {
        return format;
    }

    @Override
    public Encoding getEncoding() {
        return new EncodingFormat4(this);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SegMap.class.getSimpleName() + "[", "]")
                .add("format=" + format)
                .add("length=" + length)
                .add("lang=" + lang)
                .add("segCountX2=" + segCountX2)
                .add("searchRange=" + searchRange)
                .add("entrySelector=" + entrySelector)
                .add("rangeShift=" + rangeShift)
                .add("endCode=" + Arrays.toString(endCode))
                .add("reservedPad=" + reservedPad)
                .add("startCode=" + Arrays.toString(startCode))
                .add("idDelta=" + Arrays.toString(idDelta))
                .add("idRangeOffset=" + Arrays.toString(idRangeOffset))
                .add("glyphIdArray=" + Arrays.toString(glyphIdArray))
                .toString();
    }
}
