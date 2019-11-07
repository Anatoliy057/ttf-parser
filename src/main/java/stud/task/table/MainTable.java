package stud.task.table;

import stud.task.table.domain.HeadTable;
import stud.task.types.Tag;

public abstract class MainTable implements ReadableTable {

    public final long length;

    protected final HeadTable headTable;

    public MainTable(HeadTable headTable){
        this.headTable = headTable;
        length = headTable.getSize().unsigned();
    }

    protected void checkSize(long actuallySize) throws TTFTableFormatException {
        if (actuallySize != headTable.getSize().unsigned())
            throw new TTFTableFormatException(String.format("%s table size does not match expected", tag()), actuallySize, headTable.getSize().unsigned());
    }

    public Tag tag() {
        return headTable.getTag();
    }
}
