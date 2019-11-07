package stud.task.table;

import stud.task.table.TTFException;
import stud.task.types.Tag;

public class RequiredTableNotFoundException extends TTFException {

    public RequiredTableNotFoundException() {
    }

    public RequiredTableNotFoundException(String message) {
        super(message);
    }

    public RequiredTableNotFoundException(Tag tag) {
        super(String.format("Required table %s not found", tag));
    }
}
