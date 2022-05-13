package org.example.section_2._3;

public class Task_2_3 {
    public static boolean isPalindrome(String text) {
        StringBuilder stringBuilder = new StringBuilder(text.replaceAll("[^\\da-zA-Z]", ""));
        return String.valueOf(stringBuilder).equalsIgnoreCase(String.valueOf(stringBuilder.reverse()));
    }
}
