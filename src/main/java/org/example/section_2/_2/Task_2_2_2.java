package org.example.section_2._2;

public class Task_2_2_2 {
    public static boolean isPowerOfTwo(int value) {
        return Integer.toBinaryString(Math.abs(value)).replace("0", "").length() == 1;
    }
}
