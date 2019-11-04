package stud.task.exception;

public class StreamOutOfFileException extends Exception {
    public StreamOutOfFileException() {
    }

    public StreamOutOfFileException(String message) {
        super(message);
    }

    public StreamOutOfFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public StreamOutOfFileException(Throwable cause) {
        super(cause);
    }

    public StreamOutOfFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
