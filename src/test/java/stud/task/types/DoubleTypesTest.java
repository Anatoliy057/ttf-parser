package stud.task.types;

import org.junit.jupiter.api.Test;
import stud.task.exception.NumberOutOfRangeException;

import static org.junit.jupiter.api.Assertions.*;

class DoubleTypesTest {

    @Test
    void expect_F2DOT14_ThrowException() {
        assertThrows(NumberOutOfRangeException.class,
                () -> new F2DOT14((float) 2.0)
        );

        assertThrows(NumberOutOfRangeException.class,
                () -> new F2DOT14((float) -2.000001)
        );
    }

    @Test
    void expectFixedThrowException() {

        assertThrows(NumberOutOfRangeException.class,
                () -> new Fixed(-0xFFFF1p-1)
        );

        assertThrows(NumberOutOfRangeException.class,
                () -> new Fixed(0x8000p-0)
        );
    }

    @Test
    void expect_F2DOT14_DoesNotThrowException() {
        assertDoesNotThrow(
                () -> new F2DOT14((float) 1.999)
        );

        assertDoesNotThrow(
                () -> new F2DOT14((float) -1.999)
        );

        assertDoesNotThrow(
                () -> new F2DOT14((float) 0)
        );
    }

    @Test
    void expectFixedDoesNotThrowException() {
        assertDoesNotThrow(
                () -> new Fixed(-1 * 0x7FFFABCDp-16)
        );

        assertDoesNotThrow(
                () -> new Fixed(0x7FFFABCDp-16)
        );

        assertDoesNotThrow(
                () -> new Fixed((double) 300)
        );
    }

    @Test
    void expectCorrectValueFromFixed() {
        assertEquals(
                0x7FEDB777p-16,
                new Fixed(0x7FEDB777).doubleValue()
        );

        assertEquals(
                Fixed.MIN_VALUE + 0x7FEDB777p-16,
                new Fixed(0xFFEDB777).doubleValue()
        );
    }

    @Test
    void expectCorrectValueFromF2DOT14() {
        assertEquals(
                0x7FBCp-14,
                new F2DOT14((short) 0x7FBC).floatValue()
        );

        assertEquals(
                F2DOT14.MIN_VALUE + 0x7FBCp-14,
                new F2DOT14((short)0xFFBC).floatValue()
        );
    }
}
