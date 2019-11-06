package stud.task.types;

import org.junit.jupiter.api.Test;
import stud.task.exception.NumberOutOfRangeException;

import static org.junit.jupiter.api.Assertions.*;

class UnsignedTypesTest {

    @Test
    void expectUInt8ThrowException() {
        int negative = -1;
        long exceeding = UInt8.MAX_VALUE+1;
        assertThrows(
                NumberOutOfRangeException.class,
                () -> new UInt8(negative)
        );
        assertThrows(
                NumberOutOfRangeException.class,
                () -> new UInt8((short) exceeding)
        );
    }

    @Test
    void expectUInt16ThrowException() {
        int negative = -1;
        long exceeding = UInt16.MAX_VALUE+1;
        assertThrows(
                NumberOutOfRangeException.class,
                () -> new UInt16(negative)
        );
        assertThrows(
                NumberOutOfRangeException.class,
                () -> new UInt16((int) exceeding)
        );
    }

    @Test
    void expectUInt24ThrowException() {
        int negative = -1;
        long exceeding = UInt24.MAX_VALUE+1;
        assertThrows(
                NumberOutOfRangeException.class,
                () -> new UInt16(negative)
        );
        assertThrows(
                NumberOutOfRangeException.class,
                () -> new UInt16((int) exceeding)
        );
    }

    @Test
    void expectUInt32ThrowException() {
        byte negative = -1;
        long exceeding = UInt32.MAX_VALUE+1;
        assertThrows(
                NumberOutOfRangeException.class,
                () -> new UInt32(negative)
        );
        assertThrows(
                NumberOutOfRangeException.class,
                () -> new UInt32(exceeding)
        );
    }

    @Test
    void expectUFWordThrowException() {
        int negative = -1;
        long exceeding = UFWord.MAX_VALUE+1;
        assertThrows(
                NumberOutOfRangeException.class,
                () -> new UFWord(negative)
        );
        assertThrows(
                NumberOutOfRangeException.class,
                () -> new UFWord((int) exceeding)
        );
    }

    @Test
    void expectOffSet16ThrowException() {
        int negative = -1;
        long exceeding = OffSet16.MAX_VALUE+1;
        assertThrows(
                NumberOutOfRangeException.class,
                () -> new OffSet16(negative)
        );
        assertThrows(
                NumberOutOfRangeException.class,
                () -> new OffSet16((int) exceeding)
        );
    }

    @Test
    void expectOffSet32ThrowException() {
        long negative = -1;
        long exceeding = OffSet32.MAX_VALUE+1;
        assertThrows(
                NumberOutOfRangeException.class,
                () -> new OffSet32(negative)
        );
        assertThrows(
                NumberOutOfRangeException.class,
                () -> new OffSet32(exceeding)
        );
    }

    @Test
    void expectUInt8DoesNotThrowException() {
        byte min = 0;
        long max = UInt8.MAX_VALUE;
        assertDoesNotThrow(
                () -> new UInt8(min)
        );
        assertDoesNotThrow(
                () -> new UInt8((short) max)
        );
    }

    @Test
    void expectUInt16DoesNotThrowException() {
        byte min = 0;
        long max = UInt16.MAX_VALUE;
        assertDoesNotThrow(
                () -> new UInt16(min)
        );
        assertDoesNotThrow(
                () -> new UInt16((int) max)
        );
    }

    @Test
    void expectUInt24DoesNotThrowException() {
        byte min = 0;
        long max = UInt24.MAX_VALUE;
        assertDoesNotThrow(
                () -> new UInt24(min)
        );
        assertDoesNotThrow(
                () -> new UInt24((int) max)
        );
    }

    @Test
    void expectUInt32DoesNotThrowException() {
        byte min = 0;
        long max = UInt32.MAX_VALUE;
        assertDoesNotThrow(
                () -> new UInt32(min)
        );
        assertDoesNotThrow(
                () -> new UInt32(max)
        );
    }

    @Test
    void expectUFWordDoesNotThrowException() {
        byte min = 0;
        long max = UFWord.MAX_VALUE;
        assertDoesNotThrow(
                () -> new UFWord(min)
        );
        assertDoesNotThrow(
                () -> new UFWord((int)max)
        );
    }

    @Test
    void expectOffSet16DoesNotThrowException() {
        byte min = 0;
        long max = OffSet16.MAX_VALUE;
        assertDoesNotThrow(
                () -> new OffSet16(min)
        );
        assertDoesNotThrow(
                () -> new OffSet16((int) max)
        );
    }

    @Test
    void expectOffSet32DoesNotThrowException() {
        byte min = 0;
        long max = OffSet32.MAX_VALUE;
        assertDoesNotThrow(
                () -> new OffSet32(min)
        );
        assertDoesNotThrow(
                () -> new OffSet32(max)
        );
    }
}