package stud.task.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import stud.task.types.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TTFReaderLogs extends TTFReader {

    private static final Logger LOGGER = Logger.getLogger(TTFReaderLogs.class);

    private Level level;

    public TTFReaderLogs(InputStream io, Level level) throws IOException {
        super(io);
        this.level = level;
    }

    public TTFReaderLogs(File file, Level level) throws FileNotFoundException {
        super(file);
        this.level = level;
    }

    @Override
    public Int8 readInt8() throws IOException, StreamOutOfFileException {
        return (Int8) logRead(super.readInt8());
    }

    @Override
    public UInt8 readUInt8() throws IOException, StreamOutOfFileException {
        return (UInt8) logRead(super.readUInt8());
    }

    @Override
    public Int16 readInt16() throws IOException, StreamOutOfFileException {
        return (Int16) logRead(super.readInt16());
    }

    @Override
    public UInt16 readUInt16() throws IOException, StreamOutOfFileException {
        return (UInt16) logRead(super.readUInt16());
    }

    @Override
    public UInt24 readUInt24() throws IOException, StreamOutOfFileException {
        return (UInt24) logRead(super.readUInt24());
    }

    @Override
    public Int32 readInt32() throws IOException, StreamOutOfFileException {
        return (Int32) logRead(super.readInt32());
    }

    @Override
    public UInt32 readUInt32() throws IOException, StreamOutOfFileException {
        return (UInt32) logRead(super.readUInt32());
    }

    @Override
    public FWord readFWord() throws IOException, StreamOutOfFileException {
        return (FWord) logRead(super.readFWord());
    }

    @Override
    public UFWord readUFWord() throws IOException, StreamOutOfFileException {
        return (UFWord) logRead(super.readUFWord());
    }

    @Override
    public Tag readTag() throws IOException, StreamOutOfFileException {
        return (Tag) logRead(super.readTag());
    }

    @Override
    public OffSet16 readOffSet16() throws IOException, StreamOutOfFileException {
        return (OffSet16) logRead(super.readOffSet16());
    }

    @Override
    public OffSet32 readOffSet32() throws IOException, StreamOutOfFileException {
        return (OffSet32) logRead(super.readOffSet32());
    }

    @Override
    public F2DOT14 readF2DOT14() throws IOException, StreamOutOfFileException {
        return (F2DOT14) logRead(super.readF2DOT14());
    }

    @Override
    public Fixed readFixed() throws IOException, StreamOutOfFileException {
        return (Fixed) logRead(super.readFixed());
    }

    @Override
    public LongDateTime readLongDateTime() throws IOException, StreamOutOfFileException {
        return (LongDateTime) logRead(super.readLongDateTime());
    }

    @Override
    public void mark(int readAheadLimit) {
        super.mark(readAheadLimit);
        logMark(readAheadLimit);
    }

    @Override
    public void reset() throws IOException {
        super.reset();
        logReset();
    }

    @Override
    public long skip(long n) throws IOException {
        return logSkip(super.skip(n), n);
    }

    private Object logRead(Object read) throws IOException {
        LOGGER.log(level, String.format(
                "Read: %s, available read bytes: %d",
                read.getClass().getSimpleName(),
                available()));
        return read;
    }

    private long logSkip(long nExpect, long nActually) throws IOException {
        LOGGER.log(level, String.format(
                "Skip : (Expect %d, Actually %d), available read bytes: %d",
                nExpect,
                nActually,
                available()));
        return nActually;
    }

    private void logReset() throws IOException {
        LOGGER.log(level, "Reset occurred, available read bytes: " + available());
    }

    private void logMark(long readAheadLimit) {
        LOGGER.log(level, String.format(
                "Mark on: %d",
                readAheadLimit));
    }
}
