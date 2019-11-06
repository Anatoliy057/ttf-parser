package stud.task.types;

import java.lang.annotation.Native;
import java.util.Objects;

public final class UInt8 extends Number implements Comparable<UInt8> {
    @Native public static final short MAX_VALUE = 0xFF;
    @Native public static final short MIN_VALUE = 0x00;

    private final short value;

    public UInt8(short value) throws NumberOutOfRangeException {
        if (value > MAX_VALUE || value < MIN_VALUE)
            throw new NumberOutOfRangeException(value, MAX_VALUE, MIN_VALUE);
        this.value = value;
    }

    public UInt8(int value) throws NumberOutOfRangeException {
        if (value > MAX_VALUE || value < MIN_VALUE)
            throw new NumberOutOfRangeException(value, MAX_VALUE, MIN_VALUE);
        this.value = (short) value;
    }

    public UInt8(byte value) {
        this.value = (short) (value & 0xFF);
    }

    public UInt8(UInt8 uInt8) {
        this.value = uInt8.value;
    }

    public short unsigned() {
        return value;
    }

    public int compareTo(UInt8 o) {
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
        return (double) value;
    }

    @Override
    public short shortValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UInt8 uInt8 = (UInt8) o;
        return value == uInt8.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Short.toString(value);
    }
}
