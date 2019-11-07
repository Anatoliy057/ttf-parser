package stud.task.table;

import stud.task.util.TTFInputStream;

import java.io.IOException;

public interface ReadableTable {

    void read(TTFInputStream in) throws IOException, TTFTableFormatException;
}
