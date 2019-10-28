package stud.task.types;

import java.lang.annotation.Native;
import java.util.Objects;

public final class Int8 extends Number implements Comparable<Int8> {
    @Native public static final byte MAX_VALUE = Byte.MAX_VALUE;
    @Native public static final byte MIN_VALUE = Byte.MIN_VALUE;

    private final byte value;

    public Int8(byte value) {
        this.value = value;
    }

    @Override
    public int compareTo(Int8 o) {
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
        return (double) value;
    }

    @Override
    public byte byteValue() {
        return value;
    }

    @Override
    public short shortValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Int8 int8 = (Int8) o;
        return value == int8.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Byte.toString(value);
    }
}
