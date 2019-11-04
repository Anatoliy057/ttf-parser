package stud.task.table;

import stud.task.exception.TTFTableMismatchSizeException;
import stud.task.table.domain.HeadTable;
import stud.task.types.Tag;

import java.io.IOException;

public abstract class MainTable implements Table {

    public final long length;

    protected final HeadTable headTable;

    public MainTable(HeadTable headTable){
        this.headTable = headTable;
        length = headTable.getSize().unsigned();
    }

    protected void checkSize(long actuallySize) throws TTFTableMismatchSizeException {
        if (actuallySize != headTable.getSize().unsigned())
            throw new TTFTableMismatchSizeException(this.getClass(), actuallySize, headTable.getSize().unsigned());
    }

    public Tag tag() {
        return headTable.getTag();
    }
}
