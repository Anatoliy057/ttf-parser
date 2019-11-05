package stud.task.table;

import stud.task.exception.TTFTableFormatException;
import stud.task.util.TTFInputStream;

import java.io.IOException;

public interface Table {

    void read(TTFInputStream in) throws IOException, TTFTableFormatException;
}
