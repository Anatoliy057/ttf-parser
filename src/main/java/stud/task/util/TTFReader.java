package stud.task.util;

import stud.task.types.*;

import java.io.IOException;
import java.io.InputStream;

import static stud.task.util.ConvertPrimitives.*;

public class TTFReader {

    private InputStream io;
    private final int offset = 8;

    public TTFReader(InputStream io) throws IOException {
        if (io.markSupported())
            this.io = io;
        else
            throw new IOException("mark/reset not supported that must be");
    }

    public Int8 readInt8() throws IOException, StreamOutOfFileException {
        int buff = io.read();
        if (checkOut(buff))
            throw new StreamOutOfFileException("when trying to read Int8");
        return new Int8((byte) buff);
    }

    public UInt8 readUInt8() throws IOException, StreamOutOfFileException {
        try {
            return new UInt8((short) io.read());
        } catch (NumberOutOfRangeException e) {
            throw new StreamOutOfFileException("when trying to read UInt8");
        }
    }

    public Int16 readInt16() throws IOException, StreamOutOfFileException {
        int[] buff = new int[2];
        read(buff);
        if (checkOut(buff))
            throw new StreamOutOfFileException("when trying to read Int16");
        short value = arrToShort(offset, buff);
        return new Int16(value);
    }

    public UInt16 readUInt16() throws IOException, StreamOutOfFileException {
        int[] buff = new int[2];
        read(buff);
        int value = arrToInt(offset, buff);
        try {
            return new UInt16(value);
        } catch (NumberOutOfRangeException e) {
            throw new StreamOutOfFileException("when trying to read UInt16");
        }
    }

    public UInt24 readUInt24() throws IOException, StreamOutOfFileException {
        int[] buff = new int[3];
        read(buff);
        int value = arrToInt(offset, buff);
        try {
            return new UInt24(value);
        } catch (NumberOutOfRangeException e) {
            throw new StreamOutOfFileException("when trying to read UInt16");
        }
    }

    public Int32 readInt32() throws IOException, StreamOutOfFileException {
        int[] buff = new int[4];
        read(buff);
        if (checkOut(buff))
            throw new StreamOutOfFileException("when trying to read Int32");
        int value = arrToInt(offset, buff);
        return new Int32(value);
    }

    public UInt32 readUInt32() throws IOException, StreamOutOfFileException {
        int[] buff = new int[4];
        read(buff);
        long value = arrToLong(offset, buff);
        try {
            return new UInt32(value);
        } catch (NumberOutOfRangeException e) {
            throw new StreamOutOfFileException("when trying to read UInt32");
        }
    }

    public FWord readFWord() throws IOException, StreamOutOfFileException {
        int[] buff = new int[2];
        read(buff);
        if (checkOut(buff))
            throw new StreamOutOfFileException("when trying to read FWord");
        short value = arrToShort(offset, buff);
        return new FWord(value);
    }

    public UFWord readUFWord() throws IOException, StreamOutOfFileException {
        int[] buff = new int[2];
        read(buff);
        int value = arrToInt(offset, buff);
        try {
            return new UFWord(value);
        } catch (NumberOutOfRangeException e) {
            throw new StreamOutOfFileException("when trying to read UFWord");
        }
    }

    public Tag readTag() throws IOException, StreamOutOfFileException {
        int[] buff = new int[4];
        read(buff);
        if (checkOut(buff))
            throw new StreamOutOfFileException("when trying to read Tag");
        try {
            return new Tag(buff);
        } catch (SizeMismatchException e) {
            //impossible
            e.printStackTrace();
            return null;
        }
    }

    public OffSet16 readOffSet16() throws IOException, StreamOutOfFileException {
        int[] buff = new int[2];
        read(buff);
        int value = arrToInt(offset, buff);
        try {
            return new OffSet16(value);
        } catch (NumberOutOfRangeException e) {
            throw new StreamOutOfFileException("when trying to read OffSet16");
        }
    }

    public OffSet32 readOffSet32() throws IOException, StreamOutOfFileException {
        int[] buff = new int[4];
        read(buff);
        long value = arrToLong(offset, buff);
        try {
            return new OffSet32(value);
        } catch (NumberOutOfRangeException e) {
            throw new StreamOutOfFileException("when trying to read OffSet32");
        }
    }

    public int read() throws IOException {
        return io.read();
    }

    public void read(int[] buff) throws IOException {
        for (int i = 0; i < buff.length; i++) {
            buff[i] = io.read();
        }
    }

    public void mark(int readAheadLimit) {
        io.mark(readAheadLimit);
    }

    public void reset() throws IOException {
        io.reset();
    }

    public long skip(long n) throws IOException {
        return io.skip(n);
    }

    public long available() throws IOException {
        return io.available();
    }

    public void close() throws IOException {
        io.close();
    }

    private boolean checkOut(int...buff) {
        for (int b :
                buff) {
            if (b < 0) return true;
        }
        return false;
    }
}
