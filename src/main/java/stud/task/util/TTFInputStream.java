package stud.task.util;

import stud.task.types.*;

import java.io.IOException;

public interface TTFInputStream {

    Int8 readInt8() throws IOException, StreamOutOfFileException;

    UInt8 readUInt8() throws IOException, StreamOutOfFileException;

    Int16 readInt16() throws IOException, StreamOutOfFileException;

    UInt16 readUInt16() throws IOException, StreamOutOfFileException;

    UInt24 readUInt24() throws IOException, StreamOutOfFileException;

    Int32 readInt32() throws IOException, StreamOutOfFileException;

    UInt32 readUInt32() throws IOException, StreamOutOfFileException;

    FWord readFWord() throws IOException, StreamOutOfFileException;

    UFWord readUFWord() throws IOException, StreamOutOfFileException;

    Tag readTag() throws IOException, StreamOutOfFileException;

    OffSet16 readOffSet16() throws IOException, StreamOutOfFileException;

    OffSet32 readOffSet32() throws IOException, StreamOutOfFileException;

    F2DOT14 readF2DOT14() throws IOException, StreamOutOfFileException;

    Fixed readFixed() throws IOException, StreamOutOfFileException ;

    LongDateTime readLongDateTime() throws IOException, StreamOutOfFileException;

    default void readInt8(Int8[] buff) throws IOException, StreamOutOfFileException {
        for (int i = 0; i < buff.length; i++) {
            buff[i] = readInt8();
        }
    }

    default void readUInt8(UInt8[] buff) throws IOException, StreamOutOfFileException {
        for (int i = 0; i < buff.length; i++) {
            buff[i] = readUInt8();
        }
    }

    default void readInt16(Int16[] buff) throws IOException, StreamOutOfFileException {
        for (int i = 0; i < buff.length; i++) {
            buff[i] = readInt16();
        }
    }

    default void readUInt16(UInt16[] buff) throws IOException, StreamOutOfFileException {
        for (int i = 0; i < buff.length; i++) {
            buff[i] = readUInt16();
        }
    }

    default void readUInt24(UInt24[] buff) throws IOException, StreamOutOfFileException {
        for (int i = 0; i < buff.length; i++) {
            buff[i] = readUInt24();
        }
    }

    default void readInt32(Int32[] buff) throws IOException, StreamOutOfFileException {
        for (int i = 0; i < buff.length; i++) {
            buff[i] = readInt32();
        }
    }

    default void readUInt32(UInt32[] buff) throws IOException, StreamOutOfFileException {
        for (int i = 0; i < buff.length; i++) {
            buff[i] = readUInt32();
        }
    }

    default void readFWord(FWord[] buff) throws IOException, StreamOutOfFileException {
        for (int i = 0; i < buff.length; i++) {
            buff[i] = readFWord();
        }
    }

    default void readUFWord(UFWord [] buff) throws IOException, StreamOutOfFileException {
        for (int i = 0; i < buff.length; i++) {
            buff[i] = readUFWord();
        }
    }

    default void readTag(Tag[] buff) throws IOException, StreamOutOfFileException {
        for (int i = 0; i < buff.length; i++) {
            buff[i] = readTag();
        }
    }

    default void readOffSet16(OffSet16[] buff) throws IOException, StreamOutOfFileException {
        for (int i = 0; i < buff.length; i++) {
            buff[i] = readOffSet16();
        }
    }

    default void readOffSet32(OffSet32[] buff) throws IOException, StreamOutOfFileException {
        for (int i = 0; i < buff.length; i++) {
            buff[i] = readOffSet32();
        }
    }

    default void readF2DOT14(F2DOT14[] buff) throws IOException, StreamOutOfFileException {
        for (int i = 0; i < buff.length; i++) {
            buff[i] = readF2DOT14();
        }
    }

    default void readFixed(Fixed[] buff) throws IOException, StreamOutOfFileException {
        for (int i = 0; i < buff.length; i++) {
            buff[i] = readFixed();
        }
    }

    default void readLongDateTime(LongDateTime[] buff) throws IOException, StreamOutOfFileException {
        for (int i = 0; i < buff.length; i++) {
            buff[i] = readLongDateTime();
        }
    }

    void mark(int readAheadLimit);

    void reset() throws IOException;

    long skip(long n) throws IOException;

    long available() throws IOException;

    void close() throws IOException;
}
