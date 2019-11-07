package stud.task.util;
import stud.task.types.NumberOutOfRangeException;
import stud.task.types.SizeMismatchException;
import stud.task.types.*;

import java.io.*;

import static stud.task.util.ConvertPrimitives.*;

public class TTFReader implements TTFInputStream {

    private InputStream in;
    private final int offset = 8;
    private long distance;

    public TTFReader(InputStream in) throws IOException {
        if (in.markSupported())
            this.in = in;
        else
            throw new IOException("mark/reset not supported that must be");
    }

    public TTFReader(File file) throws FileNotFoundException {
        in = new BufferedInputStream(
                new FileInputStream(file),
                (int) file.length()
        );
    }

    public Int8 readInt8() throws IOException, StreamOutOfFileException {
        int buff = in.read();
        if (checkOut(buff))
            throw new StreamOutOfFileException("when trying to read Int8");
        return new Int8((byte) buff);
    }

    public UInt8 readUInt8() throws IOException, StreamOutOfFileException {
        try {
            return new UInt8((short) in.read());
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

    public F2DOT14 readF2DOT14() throws IOException, StreamOutOfFileException {
        int[] buff = new int[2];
        read(buff);
        if (checkOut(buff))
            throw new StreamOutOfFileException("when trying to read F2DOT14");
        short value = arrToShort(offset, buff);
        return new F2DOT14(value);
    }

    public Fixed readFixed() throws IOException, StreamOutOfFileException {
        int[] buff = new int[4];
        read(buff);
        if (checkOut(buff))
            throw new StreamOutOfFileException("when trying to read Fixed");
        int value = arrToInt(offset, buff);
        return new Fixed(value);
    }

    public LongDateTime readLongDateTime() throws IOException, StreamOutOfFileException {
        int[] buff = new int[8];
        read(buff);
        if (checkOut(buff))
            throw new StreamOutOfFileException("when trying to read LongDateTime");
        long value = arrToLong(offset, buff);
        return new LongDateTime(value);
    }

    private void read(int[] buff) throws IOException {
        for (int i = 0; i < buff.length; i++) {
            buff[i] = in.read();
        }
    }

    public void mark(int readAheadLimit) {
        in.mark(readAheadLimit);
    }

    public void reset() throws IOException {
        in.reset();
    }

    public long skip(long n) throws IOException {
        return in.skip(n);
    }

    public long available() throws IOException {
        return in.available();
    }

    public void close() throws IOException {
        in.close();
    }

    private boolean checkOut(int...buff) {
        for (int b :
                buff) {
            if (b < 0) return true;
        }
        return false;
    }
}
