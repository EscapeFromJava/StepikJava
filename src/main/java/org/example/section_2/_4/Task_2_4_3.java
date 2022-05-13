package org.example.section_2._4;

public class Task_2_4_3 {
    private String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder text = new StringBuilder();
        for (String role : roles) {
            text.append(role.concat(":\n"));
            for (int i = 0; i < textLines.length; i++) {
                if (textLines[i].startsWith(role.concat(":"))) {
                    text.append(i+1);
                    text.append(")".concat(textLines[i].substring( textLines[i].indexOf(":")+ 1)).concat("\n"));
                }
            }
            text.append("\n");
        }
        return String.valueOf(text);
    }
}
