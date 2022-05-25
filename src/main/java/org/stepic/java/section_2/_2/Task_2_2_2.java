//–еализуйте метод, провер€ющий, €вл€етс€ ли заданное число по абсолютной величине степенью двойки.

package org.stepic.java.section_2._2;

public class Task_2_2_2 {
    public static boolean isPowerOfTwo(int value) {
        return Integer.toBinaryString(Math.abs(value)).replace("0", "").length() == 1;
    }
}
