package stud.task.types;

import java.lang.annotation.Native;
import java.util.Objects;

public final class Int32 extends Number implements Comparable<Int32> {
    @Native public static final int MAX_VALUE = Integer.MAX_VALUE;
    @Native public static final int MIN_VALUE = Integer.MIN_VALUE;

    private final int value;

    public Int32(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Int32 o) {
        return shortValue() - o.shortValue();
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Int32 int32 = (Int32) o;
        return value == int32.value;
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
