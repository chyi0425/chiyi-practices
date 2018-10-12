package com.chiyi.foundation;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author chiyi
 * @date 2018/10/12.
 */
public class UnsafeTest {
    private static int byteArrayBaseOffset;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe UNSAFE = (Unsafe) theUnsafe.get(null);
        System.out.println(UNSAFE);

        byte[] data = new byte[10];
        System.out.println(Arrays.toString(data));

        byteArrayBaseOffset = UNSAFE.arrayBaseOffset(byte[].class);
        System.out.println(byteArrayBaseOffset);
        UNSAFE.putByte(data,byteArrayBaseOffset,(byte)1);
        UNSAFE.putByte(data,byteArrayBaseOffset+5,(byte)5);

        System.out.println(Arrays.toString(data));

    }
}
