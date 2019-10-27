package stud.task.types;

import java.lang.annotation.Native;
import java.util.Objects;

public final class OffSet16 extends Number implements Comparable<OffSet16> {
    @Native public static final int MAX_VALUE = 0xFFFF;
    @Native public static final int MIN_VALUE = 0x0000;

    private final int value;

    public OffSet16(int value) throws NumberOutOfRangeException {
        if (value > MAX_VALUE || value < MIN_VALUE)
            throw new NumberOutOfRangeException(value, MAX_VALUE, MIN_VALUE);
        this.value = value;
    }

    public int compareTo(OffSet16 o) {
        return intValue() - o.intValue();
    }

    public int intValue() {
        return value;
    }

    public long longValue() {
        return value;
    }

    public float floatValue() {
        return (float) value;
    }

    public double doubleValue() {
        return (long) value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OffSet16 offSet16 = (OffSet16) o;
        return value == offSet16.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
