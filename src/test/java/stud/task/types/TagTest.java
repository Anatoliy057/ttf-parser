package stud.task.types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TagTest {

    @Test
    void exceptTagThrowException() {
        char[] charStringMax = new char[] {
                0, 0, 0
        };
        assertThrows(
                SizeMismatchException.class,
                () -> new Tag(charStringMax)
        );

        byte[] byteStringMax = new byte[] {
                0, 0, 0, 0, 0
        };
        assertThrows(
                SizeMismatchException.class,
                () -> new Tag(byteStringMax)
        );

        short[] shortStringMax = new short[] {
                0, 0, 0
        };
        assertThrows(
                SizeMismatchException.class,
                () -> new Tag(shortStringMax)
        );

        char[] charStringMin = new char[] {
                0
        };
        assertThrows(
                SizeMismatchException.class,
                () -> new Tag(charStringMin)
        );

        byte[] byteStringMin = new byte[] {
                0, 0, 0
        };
        assertThrows(
                SizeMismatchException.class,
                () -> new Tag(byteStringMin)
        );

        short[] shortStringMin = new short[] {
                0
        };
        assertThrows(
                SizeMismatchException.class,
                () -> new Tag(shortStringMin)
        );
    }

    @Test
    void expectCorrectValue() {
        assertDoesNotThrow(
                () -> assertEquals(
                        new Tag(new char[] {(char)0x89AB, (char)0xCDEF}).toInt(),
                        0x89ABCDEF
                )
        );

        assertDoesNotThrow(
                () -> assertEquals(
                        new Tag(new byte[] {(byte)0x89, (byte)0xAB, (byte)0xCD, (byte)0xEF}).toInt(),
                        0x89ABCDEF
                )
        );

        assertDoesNotThrow(
                () -> assertEquals(
                        new Tag(new short[] {(short) 0x89AB, (short)0xCDEF}).toInt(),
                        0x89ABCDEF
                )
        );

        assertDoesNotThrow(
                () -> assertEquals(
                        new Tag(0x89ABCDEF).toInt(),
                        0x89ABCDEF
                )
        );
    }

    @Test
    void expectStringUTF_8() {
        assertEquals(new Tag(0x636D6170).toString(),"cmap");
    }
}
