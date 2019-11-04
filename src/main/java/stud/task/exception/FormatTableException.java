package stud.task.exception;

public class FormatTableException extends TTFException {

    public FormatTableException() {
    }

    public FormatTableException(String message) {
        super(message);
    }

    public FormatTableException(String details, Number actually, Number expect) {
        super(String.format("%s, actually: %s, expect: %s", details, actually, expect));
    }
}
