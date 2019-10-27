package stud.task.types;

public class SizeMismatchException extends Exception {

    public SizeMismatchException(int expectSize, int wrongSize) {
        super(String.format("Expect size %d is not equal size %d", expectSize, wrongSize));
    }

    public SizeMismatchException() {
    }

    public SizeMismatchException(String message) {
        super(message);
    }
}
