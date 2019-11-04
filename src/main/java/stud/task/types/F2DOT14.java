package stud.task.types;

import stud.task.exception.NumberOutOfRangeException;

import java.lang.annotation.Native;
import java.util.Objects;

public final class F2DOT14 extends Number implements Comparable<F2DOT14>{

    @Native public static final float MAX_VALUE = (float) 0x7FFFp-14;
    @Native public static final float MIN_VALUE = -2;

    private final float value;

    public F2DOT14(float value) throws NumberOutOfRangeException {
        if (value > MAX_VALUE || value < MIN_VALUE)
            throw new NumberOutOfRangeException(value, MAX_VALUE, MIN_VALUE);
        this.value = value;
    }

    public F2DOT14(short bits) {
        float newValue = bits >> 15 == 0 ? 0 : -2;
        newValue += (bits >> 14) & 1;
        bits &= 0x3FFF;
        for (int j = -1; j > -15; j--) {
            boolean b = ((bits >> (14 + j)) & 1) == 0;
            newValue += b ? 0 : Math.pow(2, j);
        }
        value = newValue;
    }

    @Override
    public int compareTo(F2DOT14 o) {
        return Float.compare(value, o.value);
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
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        F2DOT14 f2DOT14 = (F2DOT14) o;
        return Float.compare(f2DOT14.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Float.toString(value);
    }
}
