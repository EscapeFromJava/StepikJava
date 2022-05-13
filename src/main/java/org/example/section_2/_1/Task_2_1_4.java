package org.example.section_2._1;

public class Task_2_1_4 {
    public static int flipBit(int value, int bitIndex) {
        return 1 << (bitIndex - 1) ^ value; //подглядел решение, ну т.к. слишком экзотика
    }
}
