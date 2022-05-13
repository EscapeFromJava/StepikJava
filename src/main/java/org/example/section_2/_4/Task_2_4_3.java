package org.example.section_2._4;

public class Task_2_4_3 {
    private String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder text = new StringBuilder();
        for (String role : roles) {
            text.append(role);
            text.append(":\n");
            for (int i = 0; i < textLines.length; i++) {
                if (textLines[i].startsWith(role.concat(":"))) {
                    int indexChar = textLines[i].indexOf(':');
                    String currentRole = textLines[i].substring(0, indexChar);
                    String currentText = textLines[i].substring(indexChar + 1);
                    text.append(++i);
                    text.append(")");
                    text.append(currentText);
                    text.append("\n");
                }
            }

            text.append("\n");
        }
        return String.valueOf(text);
    }
}
