package stud.task.table.subtable.cmap;

import stud.task.encoding.Encoding;
import stud.task.exception.TTFTableMismatchSizeException;
import stud.task.table.Table;
import stud.task.table.required.CMap;
import stud.task.types.UInt16;

public abstract class SubTableCMap implements Table {

    protected CMap.EncodingRecord record;

    protected SubTableCMap(CMap.EncodingRecord record) {
        this.record = record;
    }

    protected void checkSize(long actuallySize, long expectSize) throws TTFTableMismatchSizeException {
        if (expectSize != actuallySize)
            throw new TTFTableMismatchSizeException(this.getClass(), actuallySize, expectSize);
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