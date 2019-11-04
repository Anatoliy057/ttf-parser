package stud.task.exception;

public class TTFTableMismatchSizeException extends TTFException {

    public TTFTableMismatchSizeException() {
    }

    public TTFTableMismatchSizeException(Class clazz, long actually, long size) {
        super(String.format("MainTable by %s. Actually size: %d, expect: %d", clazz.getSimpleName(), actually, size));
    }

    public TTFTableMismatchSizeException(String message) {
        super(message);
    }
}
