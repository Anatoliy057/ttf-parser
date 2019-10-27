package stud.task.types;

import java.lang.annotation.Native;
import java.util.Objects;

public final class UInt32 extends Number implements Comparable<UInt32> {

    @Native public static final long MAX_VALUE = 0xFFFFFFFFL;
    @Native public static final long MIN_VALUE = 0x00000000L;

    private final long value;

    public UInt32(long value) throws NumberOutOfRangeException {
        if (value > MAX_VALUE || value < MIN_VALUE)
            throw new NumberOutOfRangeException(value, MAX_VALUE, MIN_VALUE);
        this.value = value;
    }

    @Override
    public int compareTo(UInt32 o) {
        return (int) (longValue() - o.longValue());
    }

    @Override
    public int intValue() {
        return (int) value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return (float) value;
    }

    @Override
    public double doubleValue() {
        return (double) value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UInt32 uInt32 = (UInt32) o;
        return value == uInt32.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Long.toString(value);
    }
}
