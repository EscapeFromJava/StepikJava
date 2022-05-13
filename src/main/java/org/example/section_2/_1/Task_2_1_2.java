package org.example.section_2._1;

public class Task_2_1_2 {
    public static int leapYearCount(int year) {
        return (year / 4) + (year / 400) - (year / 100);
    }
}
