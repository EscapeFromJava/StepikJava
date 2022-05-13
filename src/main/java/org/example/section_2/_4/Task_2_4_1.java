package org.example.section_2._4;

import java.math.BigInteger;

public class Task_2_4_1 {
    public static BigInteger factorial(int value) {
        if (value == 1)
            return BigInteger.valueOf(1);
        return BigInteger.valueOf(value).multiply(factorial(value - 1));
    }
}
