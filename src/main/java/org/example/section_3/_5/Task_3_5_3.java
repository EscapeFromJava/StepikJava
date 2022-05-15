package org.example.section_3._5;

public class Task_3_5_3 {
    public static void main(String[] args) {

    }
}

interface TextAnalyzer {
    Label processText(String text);
}

enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}