package stud.task.types;

import stud.task.exception.NumberOutOfRangeException;

import java.lang.annotation.Native;
import java.util.Objects;

public final class UInt24 extends Number implements Comparable<UInt24> {

    @Native public static final int MAX_VALUE = 0xFFFFFF;
    @Native public static final int MIN_VALUE = 0x000000;

    private final int value;

    public UInt24(int value) throws NumberOutOfRangeException {
        if (value > MAX_VALUE || value < MIN_VALUE)
            throw new NumberOutOfRangeException(value, MAX_VALUE, MIN_VALUE);
        this.value = value;
    }

    public UInt24(UInt24 uInt24) {
        value = uInt24.value;
    }

    public UInt24(UInt16 uInt16) {
        value = uInt16.unsigned();
    }

    public UInt24(UInt8 uInt8) {
        value = uInt8.intValue();
    }

    public int unsigned() {
        return value;
    }

    @Override
    public int compareTo(UInt24 o) {
        return value - o.value;
    }

    @Override
    public int intValue() {
        return value;
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
        return (long) value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UInt24 uInt24 = (UInt24) o;
        return value == uInt24.value;
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
