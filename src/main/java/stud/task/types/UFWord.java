package stud.task.types;

import java.lang.annotation.Native;
import java.util.Objects;

public final class UFWord extends Number implements Comparable<UFWord> {
    @Native public static final int MAX_VALUE = 0xFFFF;
    @Native public static final int MIN_VALUE = 0x0000;

    private final int value;

    public UFWord(int value) throws NumberOutOfRangeException {
        if (value > MAX_VALUE || value < MIN_VALUE)
            throw new NumberOutOfRangeException(value, MAX_VALUE, MIN_VALUE);
        this.value = value;
    }

    public int unsigned() {
        return value;
    }

    public int compareTo(UFWord o) {
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
        UFWord uFWord = (UFWord) o;
        return value == uFWord.value;
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
