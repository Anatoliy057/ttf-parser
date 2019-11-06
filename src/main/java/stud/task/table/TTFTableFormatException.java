package stud.task.table;

import stud.task.table.TTFException;

public class TTFTableFormatException extends TTFException {

    public TTFTableFormatException() {
    }

    public TTFTableFormatException(String message) {
        super(message);
    }

    public TTFTableFormatException(String details, Number actually, Number expect) {
        super(String.format("%s: actually: %s, expect: %s", details, actually, expect));
    }
}
