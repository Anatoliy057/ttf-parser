package stud.task.util;

import org.apache.log4j.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stud.task.service.ResLoader;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
import static stud.task.util.ConvertPrimitives.*;

class TTFReaderTest {

    private TTFReader reader;
    private BufferedInputStream pReader;
    private int offset = 8;

    @BeforeEach
    void setUp() throws IOException {
        ResLoader rs = ResLoader.getInstance();
        File file = rs.getFile("wendy.ttf");
        pReader = new BufferedInputStream(new FileInputStream(file));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        reader = new TTFReaderLogs(bis, Level.DEBUG);
    }

    @Test
    void expectCorrectReadUInt8() {
        assertDoesNotThrow(() -> {
            while (reader.available() > 0) {
                assertEquals(pReader.read(), reader.readUInt8().unsigned());
            }
        });
    }

    @Test
    void expectCorrectReadUInt16() {
        assertDoesNotThrow(() -> {
            while (reader.available() > 2) {
                int value = arrToInt(offset, pReader.read(), pReader.read());
                assertEquals(value, reader.readUInt16().unsigned());
            }
        });
    }

    @Test
    void expectCorrectReadUInt24() {
        assertDoesNotThrow(() -> {
            while (reader.available() > 3) {
                int value = arrToInt(offset, pReader.read(), pReader.read(), pReader.read());
                assertEquals(value, reader.readUInt24().unsigned());
            }
        });
    }

    @Test
    void expectCorrectReadUInt32() {
        assertDoesNotThrow(() -> {
            while (reader.available() > 4) {
                long value = arrToLong(offset, pReader.read(), pReader.read(), pReader.read(), pReader.read());
                assertEquals(value, reader.readUInt32().unsigned());
            }
        });
    }

    @Test
    void expectCorrectReadUFWord() {
        assertDoesNotThrow(() -> {
            while (reader.available() > 2) {
                int value = arrToInt(offset, pReader.read(), pReader.read());
                assertEquals(value, reader.readUFWord().unsigned());
            }
        });
    }

    @Test
    void expectCorrectReadOffSet16() {
        assertDoesNotThrow(() -> {
            while (reader.available() > 2) {
                int value = arrToInt(offset, pReader.read(), pReader.read());
                assertEquals(value, reader.readOffSet16().unsigned());
            }
        });
    }

    @Test
    void expectCorrectReadOffSet32() {
        assertDoesNotThrow(() -> {
            while (reader.available() > 4) {
                long value = arrToLong(offset, pReader.read(), pReader.read(), pReader.read(), pReader.read());
                assertEquals(value, reader.readOffSet32().unsigned());
            }
        });
    }

    @Test
    void expectCorrectReadInt8() {
        assertDoesNotThrow(() -> {
            while (reader.available() > 0) {
                byte value = (byte) pReader.read();
                assertEquals(value, reader.readInt8().byteValue());
            }
        });
    }

    @Test
    void expectCorrectReadInt16() {
        assertDoesNotThrow(() -> {
            while (reader.available() > 2) {
                short value = (short) arrToInt(offset, pReader.read(), pReader.read());
                assertEquals(value, reader.readInt16().shortValue());
            }
        });
    }

    @Test
    void expectCorrectReadInt32() {
        assertDoesNotThrow(() -> {
            while (reader.available() > 4) {
                int value = arrToInt(offset, pReader.read(), pReader.read(), pReader.read(), pReader.read());
                assertEquals(value, reader.readInt32().intValue());
            }
        });
    }

    @Test
    void expectCorrectReadFWord() {
        assertDoesNotThrow(() -> {
            while (reader.available() > 0) {
                short value = (short) arrToInt(offset, pReader.read(), pReader.read());
                assertEquals(value, reader.readFWord().shortValue());
            }
        });
    }

    @Test
    void expectCorrectReadTag() {
        assertDoesNotThrow(() -> {
            reader.skip(0xC);
            assertEquals("OS/2", reader.readTag().toString());
        });
    }

    @Test
    void expectCorrectReadLongDateTime() {
        assertDoesNotThrow(() -> {
            while (reader.available() > 8) {
                long value = arrToLong(offset, pReader.read(), pReader.read(), pReader.read(), pReader.read(),
                        pReader.read(), pReader.read(), pReader.read(), pReader.read());
                assertEquals(value, reader.readLongDateTime().longValue());
            }
        });
    }
}