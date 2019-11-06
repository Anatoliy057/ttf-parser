package stud.task.table.subtable.cmap;

import stud.task.encoding.Encoding;
import stud.task.table.TTFTableFormatException;
import stud.task.table.Table;
import stud.task.table.required.CMap;
import stud.task.types.UInt16;

public abstract class SubTableCMap implements Table {

    protected CMap.EncodingRecord record;

    protected SubTableCMap(CMap.EncodingRecord record) {
        this.record = record;
    }

    protected void checkSize(long actuallySize, long expectSize) throws TTFTableFormatException {
        if (expectSize != actuallySize)
            throw new TTFTableFormatException(String.format("Size subtable cmap of platform: %s, encoding: %s does not match expected", getPlatformID(), getEncodingID()), actuallySize, expectSize);
    }

    public UInt16 getPlatformID() {
        return record.getPlatformID();
    }

    public UInt16 getEncodingID() {
        return record.getEncodingID();
    }

    public abstract UInt16 getFormat();

    public abstract Encoding getEncoding();
}
