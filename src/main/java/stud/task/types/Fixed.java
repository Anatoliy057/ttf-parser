package stud.task.types;

import stud.task.exception.NumberOutOfRangeException;

import java.lang.annotation.Native;
import java.util.Objects;

public final class Fixed extends Number implements Comparable<Fixed> {

    @Native public static final double MAX_VALUE = 0x7FFFFFFFp-16;
    @Native public static final double MIN_VALUE = Short.MIN_VALUE;

    private final double value;

    public Fixed(double value) throws NumberOutOfRangeException {
        if (value > MAX_VALUE || value < MIN_VALUE)
            throw new NumberOutOfRangeException(value, MAX_VALUE, MIN_VALUE);
        this.value = value;
    }

    public Fixed(int bits) {
        double newValue = ((bits >> 31) == 0) ? 0 : Short.MIN_VALUE;
        newValue += (bits >> 16) & 0x7FFF;
        bits &= 0xFFFF;
        for (int j = -1; j > -17 ; j--) {
            boolean b = ((bits >> (16 + j)) & 1) == 0;
            newValue += b ? 0 : Math.pow(2, j);
        }
        value = newValue;
    }

    @Override
    public int compareTo(Fixed o) {
        return Double.compare(value, o.value);
    }

    @Override
    public int intValue() {
        return (int) value;
    }

    @Override
    public long longValue() {
        return (long) value;
    }

    @Override
    public float floatValue() {
        return (float) value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fixed fixed = (Fixed) o;
        return Double.compare(fixed.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
