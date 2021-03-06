package stud.task.types;

import java.lang.annotation.Native;
import java.util.Objects;

public final class UInt16 extends Number implements Comparable<UInt16> {
    @Native public static final int MAX_VALUE = 0xFFFF;
    @Native public static final int MIN_VALUE = 0x0000;

    private final int value;

    public UInt16(int value) throws NumberOutOfRangeException {
        if (value > MAX_VALUE || value < MIN_VALUE)
            throw new NumberOutOfRangeException(value, MAX_VALUE, MIN_VALUE);
        this.value = value;
    }

    public UInt16(char a) {
        this((short) a);
    }

    public UInt16(short value) {
        this.value = value & 0xFFFF;
    }

    public UInt16(UInt16 uInt16) {
        this.value = uInt16.value;
    }

    public UInt16(UInt8 uInt8) {
        this.value = uInt8.intValue();
    }

    public int unsigned() {
        return value;
    }

    public int compareTo(UInt16 o) {
        return value - o.value;
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
        UInt16 uInt16 = (UInt16) o;
        return value == uInt16.value;
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
