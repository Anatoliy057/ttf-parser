package stud.task.table;

import stud.task.exception.FormatTableException;
import stud.task.exception.TTFTableMismatchSizeException;
import stud.task.util.TTFInputStream;

import java.io.IOException;

public interface Table {

    void read(TTFInputStream in) throws IOException, TTFTableMismatchSizeException, FormatTableException;
}
