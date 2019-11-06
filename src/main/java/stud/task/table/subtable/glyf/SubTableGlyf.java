package stud.task.table.subtable.glyf;

import stud.task.exception.TTFTableFormatException;
import stud.task.model.Contour;
import stud.task.model.Glyph;
import stud.task.table.Table;
import stud.task.table.required.Glyf;
import stud.task.types.Int16;

import java.util.List;

public abstract class SubTableGlyf implements Table {

    private long length;
    protected Int16 numberOfContours;

    public SubTableGlyf(long length, Int16 numberOfContours) throws TTFTableFormatException {
        if (numberOfContours.shortValue() < 0)
            throw new TTFTableFormatException("Simple glyph must have positive numberOfContours: actually " + numberOfContours);
        this.length = length;
        this.numberOfContours = numberOfContours;
    }

    public abstract Glyph getGlyph();

    public long checkSize(long actuallySize) throws TTFTableFormatException {
        if (length < actuallySize)
            throw new TTFTableFormatException(String.format("%s size does not match expected", getClass().getSimpleName()), actuallySize, length);
        else {
            return length - actuallySize;
        }
    }
}
