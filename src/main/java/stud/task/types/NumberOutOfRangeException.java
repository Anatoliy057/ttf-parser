package stud.task.types;

public class NumberOutOfRangeException extends Exception {

    public NumberOutOfRangeException() {
    }

    public NumberOutOfRangeException(String message) {
        super(message);
    }

    public NumberOutOfRangeException(Number number, Number min, Number max) {
        super(String.format("Received number : %s out of range [%s ; %s]", number, min, max));
    }
}
