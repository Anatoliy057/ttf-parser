package stud.task.types;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static stud.task.util.ConvertPrimitives.*;

public final class Tag {
    public final static Charset CHARSET = StandardCharsets.UTF_8;
    private final int NUMBER_OF_BYTES = 4;

    private final byte[] string;

    public Tag(char[] string, boolean full) throws SizeMismatchException {
        if (full) {
            if (string.length != NUMBER_OF_BYTES / 2)
                throw new SizeMismatchException(NUMBER_OF_BYTES, string.length * 2);
            this.string = new byte[NUMBER_OF_BYTES];
            shortToByteArr((short) string[0], this.string, 0, 2);
            shortToByteArr((short) string[1], this.string, 2, 4);
        } else {
            if (string.length != NUMBER_OF_BYTES)
                throw new SizeMismatchException(NUMBER_OF_BYTES, string.length);
            this.string = new byte[NUMBER_OF_BYTES];
            for (int i = 0; i < this.string.length; i++) {
                this.string[i] = (byte) Short.toUnsignedInt((short) string[i]);
            }
        }
    }

    public Tag(byte[] string) throws SizeMismatchException {
        if (string.length != NUMBER_OF_BYTES)
            throw new SizeMismatchException(NUMBER_OF_BYTES, string.length);
        this.string = string;
    }

    public Tag(short[] string, boolean full) throws SizeMismatchException {
        if (full) {
            if (string.length != NUMBER_OF_BYTES / 2)
                throw new SizeMismatchException(NUMBER_OF_BYTES, string.length * 2);
            this.string = new byte[NUMBER_OF_BYTES];
            shortToByteArr(string[0], this.string, 0, 2);
            shortToByteArr(string[1], this.string, 2, 4);
        } else {
            if (string.length != NUMBER_OF_BYTES)
                throw new SizeMismatchException(NUMBER_OF_BYTES, string.length);
            this.string = new byte[NUMBER_OF_BYTES];
            for (int i = 0; i < this.string.length; i++) {
                this.string[i] = (byte) Short.toUnsignedInt(string[i]);
            }
        }
    }

    public Tag(int[] string) throws SizeMismatchException {
        if (string.length != NUMBER_OF_BYTES)
            throw new SizeMismatchException(NUMBER_OF_BYTES, string.length);
        this.string = new byte[NUMBER_OF_BYTES];
        for (int i = 0; i < this.string.length; i++) {
            this.string[i] = (byte) string[i];
        }
    }

    public Tag(int string) {
        this.string = intToByteArr(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Arrays.equals(string, tag.string);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(string);
    }

    public int toInt() {
        return arrToInt(8, string);
    }

    @Override
    public String toString() {
        return new String(string, CHARSET);
    }
}
