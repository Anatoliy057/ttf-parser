package stud.task.types;

import java.lang.annotation.Native;
import java.util.Date;
import java.util.Objects;

public final class LongDateTime extends Number implements Comparable<LongDateTime> {

    @Native public static final long MAX_VALUE = Long.MAX_VALUE;
    @Native public static final long MIN_VALUE = Long.MIN_VALUE;

    public final long DIFF_TIME = 2082810617L;

    private final long value;

    public LongDateTime(long value) {
        this.value = value;
    }

    @Override
    public int compareTo(LongDateTime o) {
        return Long.compare(value, o.value);
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
        LongDateTime that = (LongDateTime) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Date toDate() {
        return new Date(( value - DIFF_TIME) * 1000);
    }

    @Override
    public String toString() {
        return Long.toString(value);
    }
}
