package stud.task.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static stud.task.util.ConvertPrimitives.*;

class ConvertPrimitivesTest {

    long[] exampleArrayLong = new long[]{
            0xF0L, 0xF0L, 0xF0L, 0xF0L, 0xF0L
    };

    int[] exampleArrayInt = new int[]{
            0xF0, 0xF0, 0xF0, 0xF0, 0xF0
    };

    short[] exampleArrayShort = new short[]{
            0xF0, 0xF0, 0xF0, 0xF0, 0xF0
    };

    byte[] exampleArrayByte = new byte[]{
            (byte) 0xF0, (byte) 0xF0, (byte) 0xF0, (byte) 0xF0, (byte) 0xF0
    };

    long exampleNumberLong = 0xF0F0F0F0F0L;
    int exampleNumberInt = 0xF0F0F0F0;
    short exampleNumberShort = (short) 0xF0F0;
    byte exampleNumberByte = (byte) 0xF0;

    @Test
    void testMethodByteToArr() {
        assertDoesNotThrow(() -> {
            assertArrayEquals(
                    byteToBooleanArr(exampleNumberByte),
                    new boolean[] {true, true, true, true, false, false, false, false}
            );
            assertArrayEquals(
                    byteToByteArr(exampleNumberByte, 2),
                    new byte[] {3, 3, 0, 0}
            );
            assertArrayEquals(
                    byteToIntArr(exampleNumberByte, 2),
                    new int[] {3, 3, 0, 0}
            );
            assertArrayEquals(
                    byteToLongArr(exampleNumberByte, 4),
                    new long[] {0xFL, 0x0L}
            );
        });
    }

    @Test
    void testMethodShortToArr() {
        assertDoesNotThrow(() -> {
            assertArrayEquals(
                    shortToBooleanArr(exampleNumberShort, 8),
                    new boolean[] {true, true}
            );
            assertArrayEquals(
                    shortToByteArr(exampleNumberShort, 2),
                    new byte[] {3, 3, 0, 0, 3, 3, 0, 0}
            );
            assertArrayEquals(
                    shortToIntArr(exampleNumberShort, 4),
                    new int[] {0xF, 0, 0xF, 0}
            );
            assertArrayEquals(
                    shortToLongArr(exampleNumberShort, 4),
                    new long[] {0xFL, 0x0L, 0xFL, 0x0L}
            );
        });
    }
}