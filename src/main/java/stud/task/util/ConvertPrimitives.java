package stud.task.util;

/**
 * The class {@code ConvertPrimitives} contains various static methods
 * for converting arrays of primitives as in number as in array
 * of other type of primitive.
 *
 * @author Udartsev Anatoliy
 */

public final class ConvertPrimitives {

    /**
     * Methods of create arrays from number.
     * Types of array can be: boolean, byte, short, int, long
     * Types of number can be: byte, short, int, long
     *
     * @param src    the number itself.
     * @param offset the offset by number.
     *        Represents the count of bits of the number
     *        into which the src will be split up.
     *        Size of array will equals count of bits src divide offset.
     * @return array, which has obtained in result of split up src.
     */

    public static boolean[] byteToBooleanArr(byte src, int offset) {
        boolean[] arr = new boolean[8 / offset];
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0 != ((src >>> (offset * (arr.length - 1 - i))) & mask);
        }
        return arr;
    }

    public static byte[] byteToByteArr(byte src, int offset) {
        byte[] arr = new byte[8 / offset];
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (byte) ((src >>> (offset * (arr.length - 1 - i))) & mask);
        }
        return arr;
    }

    public static short[] byteToShortArr(byte src, int offset) {
        short[] arr = new short[8 / offset];
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (short) ((src >>> (offset * (arr.length - 1 - i))) & mask);
        }
        return arr;
    }

    public static int[] byteToIntArr(byte src, int offset) {
        int[] arr = new int[8 / offset];
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((src >>> (offset * (arr.length - 1 - i))) & mask);
        }
        return arr;
    }

    public static long[] byteToLongArr(byte src, int offset) {
        long[] arr = new long[8 / offset];
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (src >>> (offset * (arr.length - 1 - i))) & mask;
        }
        return arr;
    }

    public static boolean[] shortToBooleanArr(short src, int offset) {
        boolean[] arr = new boolean[16 / offset];
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0 != ((src >>> (offset * (arr.length - 1 - i))) & mask);
        }
        return arr;
    }

    public static byte[] shortToByteArr(short src, int offset) {
        byte[] arr = new byte[16 / offset];
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (byte) ((src >>> (offset * (arr.length - 1 - i))) & mask);
        }
        return arr;
    }

    public static short[] shortToShortArr(short src, int offset) {
        short[] arr = new short[16 / offset];
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (short) ((src >>> (offset * (arr.length - 1 - i))) & mask);
        }
        return arr;
    }

    public static int[] shortToIntArr(short src, int offset) {
        int[] arr = new int[16 / offset];
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((src >>> (offset * (arr.length - 1 - i))) & mask);
        }
        return arr;
    }

    public static long[] shortToLongArr(short src, int offset) {
        long[] arr = new long[16 / offset];
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (src >>> (offset * (arr.length - 1 - i))) & mask;
        }
        return arr;
    }

    public static boolean[] intToBooleanArr(int src, int offset) {
        boolean[] arr = new boolean[32 / offset];
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0 != ((src >>> (offset * (arr.length - 1 - i))) & mask);
        }
        return arr;
    }

    public static byte[] intToByteArr(int src, int offset) {
        byte[] arr = new byte[32 / offset];
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (byte) ((src >>> (offset * (arr.length - 1 - i))) & mask);
        }
        return arr;
    }

    public static short[] intToShortArr(int src, int offset) {
        short[] arr = new short[32 / offset];
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (short) ((src >>> (offset * (arr.length - 1 - i))) & mask);
        }
        return arr;
    }

    public static int[] intToIntArr(int src, int offset) {
        int[] arr = new int[32 / offset];
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((src >>> (offset * (arr.length - 1 - i))) & mask);
        }
        return arr;
    }

    public static long[] intToLongArr(int src, int offset) {
        long[] arr = new long[32 / offset];
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (src >>> (offset * (arr.length - 1 - i))) & mask;
        }
        return arr;
    }

    public static boolean[] longToBooleanArr(int src, int offset) {
        boolean[] arr = new boolean[64 / offset];
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0 != ((src >>> (offset * (arr.length - 1 - i))) & mask);
        }
        return arr;
    }

    public static byte[] longToByteArr(long src, int offset) {
        byte[] arr = new byte[64 / offset];
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (byte) ((src >>> (offset * (arr.length - 1 - i))) & mask);
        }
        return arr;
    }

    public static short[] longToShortArr(long src, int offset) {
        short[] arr = new short[64 / offset];
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (short) ((src >>> (offset * (arr.length - 1 - i))) & mask);
        }
        return arr;
    }

    public static int[] longToIntArr(long src, int offset) {
        int[] arr = new int[64 / offset];
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((src >>> (offset * (arr.length - 1 - i))) & mask);
        }
        return arr;
    }

    public static long[] longToLongArr(long src, int offset) {
        long[] arr = new long[64 / offset];
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (src >>> (offset * (arr.length - 1 - i))) & mask;
        }
        return arr;
    }

    /**
     * They provide the same functionality as the methods they are composing,
     * but only with the condition that param offset by default in equal to
     * the count of bits of the primitive of the returning array.
     *
     * Cases, when count of bits of src <= count of bits primitive of the array,
     * ignored for obvious reasons.
     *
     * @param src  the number itself.
     * @return array, which has obtained in result of split up src.
     */

    public static boolean[] byteToBooleanArr(byte src) {
        return byteToBooleanArr(src, 1);
    }

    public static boolean[] shortToBooleanArr(short src) {
        return shortToBooleanArr(src, 1);
    }

    public static byte[] shortToByteArr(short src) {
        return shortToByteArr(src, 8);
    }

    public static boolean[] intToBooleanArr(int src) {
        return intToBooleanArr(src, 1);
    }

    public static byte[] intToByteArr(int src) {
        return intToByteArr(src, 8);
    }

    public static short[] intToShortArr(int src) {
        return intToShortArr(src, 16);
    }

    public static boolean[] longToBooleanArr(int src) {
        return longToBooleanArr(src, 1);
    }

    public static byte[] longToByteArr(long src) {
        return longToByteArr(src, 8);
    }

    public static short[] longToShortArr(long src) {
        return longToShortArr(src, 16);
    }

    public static int[] longToIntArr(long src) {
        return longToIntArr(src, 32);
    }

    /**
     * Methods for split up a number into other numbers
     * that will be written to the specified range of the given array.
     *
     * Type of splitting number can be: byte, short, int, long.
     * Type of array can be: boolean, byte, short, int, long.
     *
     * Offset for number equals count bits of type of the splitting
     * number divided length of range
     *
     * @param src   splitting number itself.
     * @param arr   array in that will be written
     * @param start start index of range in array
     * @param end   end index of range in array
     */

    public static void byteToBooleanArr(byte src, boolean[] arr, int start, int end) {
        int size = end - start;
        int offset = 8 / size;
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = start; i < end; i++) {
            arr[i] = 0 != ((src >>> (offset * (size - 1 - i - start))) & mask);
        }
    }

    public static void byteToByteArr(byte src, byte[] arr, int start, int end) {
        int size = end - start;
        int offset = 8 / size;
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = start; i < end; i++) {
            arr[i] = (byte) ((src >>> (offset * (size - 1 - i - start))) & mask);
        }
    }

    public static void byteToShortArr(byte src, short[] arr, int start, int end) {
        int size = end - start;
        int offset = 8 / size;
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (short) ((src >>> (offset * (size - 1 - i - start))) & mask);
        }
    }

    public static void byteToIntArr(byte src, int[] arr, int start, int end) {
        int size = end - start;
        int offset = 8 / size;
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = start; i < end; i++) {
            arr[i] = (int) ((src >>> (offset * (size - 1 - i - start))) & mask);
        }
    }

    public static void byteToLongArr(byte src, long[] arr, int start, int end) {
        int size = end - start;
        int offset = 8 / size;
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = start; i < end; i++) {
            arr[i] = (src >>> (offset * (size - 1 - i - start))) & mask;
        }
    }

    public static void shortToBooleanArr(short src, boolean[] arr, int start, int end) {
        int size = end - start;
        int offset = 16 / size;
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = start; i < end; i++) {
            arr[i] = 0 != ((src >>> (offset * (size - 1 - i - start))) & mask);
        }
    }

    public static void shortToByteArr(short src, byte[] arr, int start, int end) {
        int size = end - start;
        int offset = 16 / size;
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = start; i < end; i++) {
            arr[i] = (byte) ((src >>> (offset * (size - 1 - i - start))) & mask);
        }
    }

    public static void shortToShortArr(short src, short[] arr, int start, int end) {
        int size = end - start;
        int offset = 16 / size;
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (short) ((src >>> (offset * (size - 1 - i - start))) & mask);
        }
    }

    public static void shortToIntArr(short src, int[] arr, int start, int end) {
        int size = end - start;
        int offset = 16 / size;
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = start; i < end; i++) {
            arr[i] = (int) ((src >>> (offset * (size - 1 - i - start))) & mask);
        }
    }

    public static void shortToLongArr(short src, long[] arr, int start, int end) {
        int size = end - start;
        int offset = 16 / size;
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = start; i < end; i++) {
            arr[i] = (src >>> (offset * (size - 1 - i - start))) & mask;
        }
    }
    public static void intToBooleanArr(int src, boolean[] arr, int start, int end) {
        int size = end - start;
        int offset = 32 / size;
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = start; i < end; i++) {
            arr[i] = 0 != ((src >>> (offset * (size - 1 - i - start))) & mask);
        }
    }

    public static void intToByteArr(int src, byte[] arr, int start, int end) {
        int size = end - start;
        int offset = 32 / size;
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = start; i < end; i++) {
            arr[i] = (byte) ((src >>> (offset * (size - 1 - i - start))) & mask);
        }
    }

    public static void intToShortArr(int src, short[] arr, int start, int end) {
        int size = end - start;
        int offset = 32 / size;
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = start; i < end; i++) {
            arr[i] = (short) ((src >>> (offset * (size - 1 - i - start))) & mask);
        }
    }

    public static void intToIntArr(int src, int[] arr, int start, int end) {
        int size = end - start;
        int offset = 32 / size;
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = start; i < end; i++) {
            arr[i] = (int) ((src >>> (offset * (size - 1 - i - start))) & mask);
        }
    }

    public static void intToLongArr(int src, long[] arr, int start, int end) {
        int size = end - start;
        int offset = 32 / size;
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = start; i < end; i++) {
            arr[i] = (src >>> (offset * (size - 1 - i - start))) & mask;
        }
    }

    public static void longToBooleanArr(long src, boolean[] arr, int start, int end) {
        int size = end - start;
        int offset = 64 / size;
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = start; i < end; i++) {
            arr[i] = 0 != ((src >>> (offset * (size - 1 - i - start))) & mask);
        }
    }

    public static void longToByteArr(long src, byte[] arr, int start, int end) {
        int size = end - start;
        int offset = 64 / size;
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = start; i < end; i++) {
            arr[i] = (byte) ((src >>> (offset * (size - 1 - i - start))) & mask);
        }
    }

    public static void longToShortArr(long src, short[] arr, int start, int end) {
        int size = end - start;
        int offset = 64 / size;
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = start; i < end; i++) {
            arr[i] = (short) ((src >>> (offset * (size - 1 - i - start))) & mask);
        }
    }

    public static void longToIntArr(long src, int[] arr, int start, int end) {
        int size = end - start;
        int offset = 64 / size;
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = start; i < end; i++) {
            arr[i] = (int) ((src >>> (offset * (size - 1 - i - start))) & mask);
        }
    }

    public static void longToLongArr(long src, long[] arr, int start, int end) {
        int size = end - start;
        int offset = 64 / size;
        long mask = (long) (Math.pow(2, offset)-1);
        for (int i = start; i < end; i++) {
            arr[i] = (src >>> (offset * (size - 1 - i - start))) & mask;
        }
    }

    /**
     * They provide the same functionality as the methods they are composing,
     * but only with the condition that range equals size of the given array.
     *
     * @param src  the splitting number itself.
     * @param arr  splitting number itself.
     */

    public static void byteToBooleanArr(byte src, boolean...arr) {
        byteToBooleanArr(src, arr, 0, arr.length);
    }

    public static void byteToByteArr(byte src, byte...arr) {
        byteToByteArr(src, arr, 0, arr.length);
    }

    public static void byteToShortArr(byte src, short...arr) {
        byteToShortArr(src, arr, 0, arr.length);
    }

    public static void byteToIntArr(byte src, int...arr) {
        byteToIntArr(src, arr, 0, arr.length);
    }

    public static void byteToLongArr(byte src, long...arr) {
        byteToLongArr(src, arr, 0, arr.length);
    }

    public static void shortToBooleanArr(short src, boolean...arr) {
        shortToBooleanArr(src, arr, 0, arr.length);
    }

    public static void shortToByteArr(short src, byte...arr) {
        shortToByteArr(src, arr, 0, arr.length);
    }

    public static void shortToShortArr(short src, short...arr) {
        shortToShortArr(src, arr, 0, arr.length);
    }

    public static void shortToIntArr(short src, int...arr) {
        shortToIntArr(src, arr, 0, arr.length);
    }

    public static void shortToLongArr(short src, long...arr) {
        shortToLongArr(src, arr, 0, arr.length);
    }

    public static void intToBooleanArr(int src, boolean...arr) {
        intToBooleanArr(src, arr, 0, arr.length);
    }

    public static void intToByteArr(int src, byte...arr) {
        intToByteArr(src, arr, 0, arr.length);
    }

    public static void intToShortArr(int src, short...arr) {
        intToShortArr(src, arr, 0, arr.length);
    }

    public static void intToIntArr(int src, int...arr) {
        intToIntArr(src, arr, 0, arr.length);
    }

    public static void intToLongArr(int src, long...arr) {
        intToLongArr(src, arr, 0, arr.length);
    }

    public static void longToBooleanArr(long src, boolean...arr) {
        longToBooleanArr(src, arr, 0, arr.length);
    }

    public static void longToByteArr(long src, byte...arr) {
        longToByteArr(src, arr, 0, arr.length);
    }

    public static void longToShortArr(long src, short...arr) {
        longToShortArr(src, arr, 0, arr.length);
    }

    public static void longToIntArr(long src, int...arr) {
        longToIntArr(src, arr, 0, arr.length);
    }

    public static void longToLongArr(long src, long...arr) {
        longToLongArr(src, arr, 0, arr.length);
    }

    /**
     * Methods of concat the given range of array in number
     *
     * Type of array can be: boolean, byte, short, int, long.
     * Type of number can be: byte, short, int, long.
     *
     * @param arr     array to be converted to a number
     * @param offset  the offset by number.
     *        Represents the count of bits of the number from array
     *        which will be written in number of result.
     * @param start   start index of range in array
     * @param end     end index of range in array
     *
     * @return number result of array join
     */

    public static byte arrToByte(long[] arr, int offset, int start, int end) {
        byte value = 0;
        int size = end - start;
        for (int i = start; i < end; i++) {
            value |= arr[i] << ((size - 1 - i - start) * offset);
        }
        return value;
    }

    public static short arrToShort(long[] arr, int offset, int start, int end) {
        short value = 0;
        int size = end - start;
        for (int i = start; i < end; i++) {
            value |= arr[i] << ((size - 1 - i - start) * offset);
        }
        return value;
    }

    public static int arrToInt(long[] arr, int offset, int start, int end) {
        int value = 0;
        int size = end - start;
        for (int i = start; i < end; i++) {
            value |= arr[i] << ((size - 1 - i - start) * offset);
        }
        return value;
    }

    public static long arrToLong(long[] arr, int offset, int start, int end) {
        long value = 0;
        int size = end - start;
        for (int i = start; i < end; i++) {
            value |= arr[i] << ((size - 1 - i - start) * offset);
        }
        return value;
    }

    public static byte arrToByte(int[] arr, int offset, int start, int end) {
        byte value = 0;
        int size = end - start;
        for (int i = start; i < end; i++) {
            value |= arr[i] << ((size - 1 - i - start) * offset);
        }
        return value;
    }

    public static short arrToShort(int[] arr, int offset, int start, int end) {
        short value = 0;
        int size = end - start;
        for (int i = start; i < end; i++) {
            value |= arr[i] << ((size - 1 - i - start) * offset);
        }
        return value;
    }

    public static int arrToInt(int[] arr, int offset, int start, int end) {
        int value = 0;
        int size = end - start;
        for (int i = start; i < end; i++) {
            value |= arr[i] << ((size - 1 - i - start) * offset);
        }
        return value;
    }

    public static long arrToLong(int[] arr, int offset, int start, int end) {
        long mask = (long) Math.pow(2, offset)-1;
        long value = 0;
        int size = end - start;
        for (int i = start; i < end; i++) {
            value |= (arr[i] & mask) << ((size - 1 - i - start) * offset);
        }
        return value;
    }

    public static byte arrToByte(short[] arr, int offset, int start, int end) {
        byte value = 0;
        int size = end - start;
        for (int i = start; i < end; i++) {
            value |= arr[i] << ((size - 1 - i - start) * offset);
        }
        return value;
    }

    public static short arrToShort(short[] arr, int offset, int start, int end) {
        short value = 0;
        int size = end - start;
        for (int i = start; i < end; i++) {
            value |= arr[i] << ((size - 1 - i - start) * offset);
        }
        return value;
    }

    public static int arrToInt(short[] arr, int offset, int start, int end) {
        long mask = (long) Math.pow(2, offset)-1;
        int value = 0;
        int size = end - start;
        for (int i = start; i < end; i++) {
            value |= (arr[i] & mask) << ((size - 1 - i - start) * offset);
        }
        return value;
    }

    public static long arrToLong(short[] arr, int offset, int start, int end) {
        long mask = (long) Math.pow(2, offset)-1;
        long value = 0;
        int size = end - start;
        for (int i = start; i < end; i++) {
            value |= (arr[i] & mask) << ((size - 1 - i - start) * offset);
        }
        return value;
    }

    public static byte arrToByte(byte[] arr, int offset, int start, int end) {
        byte value = 0;
        int size = end - start;
        for (int i = start; i < end; i++) {
            value |= arr[i] << ((size - 1 - i - start) * offset);
        }
        return value;
    }

    public static short arrToShort(byte[] arr, int offset, int start, int end) {
        long mask = (long) Math.pow(2, offset)-1;
        short value = 0;
        int size = end - start;
        for (int i = start; i < end; i++) {
            value |= (arr[i] & mask) << ((size - 1 - i - start) * offset);
        }
        return value;
    }

    public static int arrToInt(byte[] arr, int offset, int start, int end) {
        long mask = (long) Math.pow(2, offset)-1;
        int value = 0;
        int size = end - start;
        for (int i = start; i < end; i++) {
            value |= (arr[i] & mask) << ((size - 1 - i - start) * offset);
        }
        return value;
    }

    public static long arrToLong(byte[] arr, int offset, int start, int end) {
        long mask = (long) Math.pow(2, offset)-1;
        long value = 0;
        int size = end - start;
        for (int i = start; i < end; i++) {
            value |= (arr[i] & mask) << ((size - 1 - i - start) * offset);
        }
        return value;
    }

    public static byte arrToByte(boolean[] arr, int offset, int start, int end) {
        byte value = 0;
        int size = end - start;
        for (int i = start; i < end; i++) {
            value |= (arr[i] ? 1L : 0L) << ((size - 1 - i - start) * offset);
        }
        return value;
    }

    public static short arrToShort(boolean[] arr, int offset, int start, int end) {
        short value = 0;
        int size = end - start;
        for (int i = start; i < end; i++) {
            value |= (arr[i] ? 1L : 0L) << ((size - 1 - i - start) * offset);
        }
        return value;
    }

    public static int arrToInt(boolean[] arr, int offset, int start, int end) {
        int value = 0;
        int size = end - start;
        for (int i = start; i < end; i++) {
            value |= (arr[i] ? 1L : 0L) << ((size - 1 - i - start) * offset);
        }
        return value;
    }

    public static long arrToLong(boolean[] arr, int offset, int start, int end) {
        long value = 0;
        int size = end - start;
        for (int i = start; i < end; i++) {
            value |= (arr[i] ? 1L : 0L) << ((size - 1 - i - start) * offset);
        }
        return value;
    }

    /**
     * They provide the same functionality as the methods they are composing,
     * but only with the condition that range in equal to
     * size of given array.
     *
     * Cases, when count of bits of src <= count of bits primitive of the array,
     * ignored for obvious reasons.
     *
     * @param arr     array to be converted to a number
     * @param offset  the offset by number.
     *        Represents the count of bits of the number from array
     *        which will be written in number of result.
     *
     * @return number result of array join
     */

    public static byte arrToByte(int offset, boolean...arr) {
        return arrToByte(arr, offset, 0, arr.length);
    }

    public static short arrToShort(int offset, boolean...arr) {
        return arrToShort(arr, offset, 0, arr.length);
    }

    public static int arrToInt(int offset, boolean...arr) {
        return arrToInt(arr, offset, 0, arr.length);
    }

    public static long arrToLong(int offset, boolean...arr) {
        return arrToLong(arr, offset, 0, arr.length);
    }

    public static byte arrToByte(int offset, byte...arr) {
        return arrToByte(arr, offset, 0, arr.length);
    }

    public static short arrToShort(int offset, byte...arr) {
        return arrToShort(arr, offset, 0, arr.length);
    }

    public static int arrToInt(int offset, byte...arr) {
        return arrToInt(arr, offset, 0, arr.length);
    }

    public static long arrToLong(int offset, byte...arr) {
        return arrToLong(arr, offset, 0, arr.length);
    }

    public static byte arrToByte(int offset, short...arr) {
        return arrToByte(arr, offset, 0, arr.length);
    }

    public static short arrToShort(int offset, short...arr) {
        return arrToShort(arr, offset, 0, arr.length);
    }

    public static int arrToInt(int offset, short...arr) {
        return arrToInt(arr, offset, 0, arr.length);
    }

    public static long arrToLong(int offset, short...arr) {
        return arrToLong(arr, offset, 0, arr.length);
    }

    public static byte arrToByte(int offset, int...arr) {
        return arrToByte(arr, offset, 0, arr.length);
    }

    public static short arrToShort(int offset, int...arr) {
        return arrToShort(arr, offset, 0, arr.length);
    }

    public static int arrToInt(int offset, int...arr) {
        return arrToInt(arr, offset, 0, arr.length);
    }

    public static long arrToLong(int offset, int...arr) {
        return arrToLong(arr, offset, 0, arr.length);
    }

    public static byte arrToByte(int offset, long...arr) {
        return arrToByte(arr, offset, 0, arr.length);
    }

    public static short arrToShort(int offset, long...arr) {
        return arrToShort(arr, offset, 0, arr.length);
    }

    public static int arrToInt(int offset, long...arr) {
        return arrToInt(arr, offset, 0, arr.length);
    }

    public static long arrToLong(int offset, long...arr) {
        return arrToLong(arr, offset, 0, arr.length);
    }
}
