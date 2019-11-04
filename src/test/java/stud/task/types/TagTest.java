package stud.task.types;

import org.junit.jupiter.api.Test;
import stud.task.exception.SizeMismatchException;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TagTest {

    @Test
    void expectTagThrowException() {
        char[] charStringMax = new char[] {
                0, 0, 0
        };
        assertThrows(
                SizeMismatchException.class,
                () -> new Tag(charStringMax, true)
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
                () -> new Tag(shortStringMax, true)
        );

        char[] charStringMin = new char[] {
                0
        };
        assertThrows(
                SizeMismatchException.class,
                () -> new Tag(charStringMin, true)
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
                () -> new Tag(shortStringMin, true)
        );
    }

    @Test
    void expectCorrectValue() {
        System.out.println(Arrays.toString( new byte[] {(byte)0x89, (byte)0xAB, (byte)0xCD, (byte)0xEF}));
        assertDoesNotThrow(
                () -> assertEquals(
                        new Tag(new char[] {(char)0x89AB, (char)0xCDEF}, true).toInt(),
                        0x89ABCDEF
                )
        );

        assertDoesNotThrow(
                () -> assertEquals(
                        new Tag(
                                new byte[] {(byte)0x89, (byte)0xAB, (byte)0xCD, (byte)0xEF}).toInt(),
                        0x89ABCDEF
                )
        );

        assertDoesNotThrow(
                () -> assertEquals(
                        new Tag(new short[] {(short) 0x89AB, (short)0xCDEF}, true).toInt(),
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
