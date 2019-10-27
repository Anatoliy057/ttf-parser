package stud.task.types;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public final class Tag {
    private final int NUMBER_OF_BYTES = 4;

    private final byte[] string;

    public Tag(char[] string) throws SizeMismatchException {
        if (string.length != NUMBER_OF_BYTES / 2)
            throw new SizeMismatchException(NUMBER_OF_BYTES, string.length * 2);
        this.string = new byte[NUMBER_OF_BYTES];
        this.string[0] = (byte) ((string[0] & 0xFF00) >>> 8);
        this.string[1] = (byte) (string[0] & 0x00FF);
        this.string[2] = (byte) ((string[1] & 0xFF00) >>> 8);
        this.string[3] = (byte) (string[1] & 0x00FF);
    }

    public Tag(byte[] string) throws SizeMismatchException {
        if (string.length != NUMBER_OF_BYTES)
            throw new SizeMismatchException(NUMBER_OF_BYTES, string.length);
        this.string = string;
    }

    public Tag(short[] string) throws SizeMismatchException {
        if (string.length != NUMBER_OF_BYTES/2)
            throw new SizeMismatchException(NUMBER_OF_BYTES, string.length*2);
        this.string = new byte[NUMBER_OF_BYTES];
        this.string[0] = (byte) ((string[0] & 0xFF00) >>> 8);
        this.string[1] = (byte) (string[0] & 0x00FF);
        this.string[2] = (byte) ((string[1] & 0xFF00) >>> 8);
        this.string[3] = (byte) (string[1] & 0x00FF);
    }

    public Tag(int string) {
        this.string = new byte[NUMBER_OF_BYTES];
        for (int i = 0; i < NUMBER_OF_BYTES; i++) {
            this.string[i] = (byte) ((string >> ((3-i)*8)) & 0x000000FF);
        }
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
        int value = 0;
        for (int i = 0; i < 4; i++) {
            int offset = (3-i) * 8;
            value |= (string[i] & 0xff) << offset;
        }
        return value;
    }

    @Override
    public String toString() {
        return new String(string, StandardCharsets.UTF_8);
    }
}
