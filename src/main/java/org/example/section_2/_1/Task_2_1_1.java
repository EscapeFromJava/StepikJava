package org.example.section_2._1;

public class Task_2_1_1 {
    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        int temp = 0;
        if (a) temp++;
        if (b) temp++;
        if (c) temp++;
        if (d) temp++;
        return temp == 2;
    }
}
