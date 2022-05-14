//��� ��� ������ ����� � �������� ����� � ���� ������� �������.
//
//������ ������� �������� ����� ���� � ��������� ����:
//����: �����
//
//����� ����� ��������� ����� �������.
//
//�������� �����, ������� ����� ������������ ������� �� �����, ��������������� �� � ���������� ��������� � ���� �������� ������ (��. ������). ������ ������ ��������������� � ��������� ����:
//
//����:
//i) �����
//j) �����2
//...
//==������� ������==
//
//i � j -- ������ ����� � ��������. ���������� ������� ���������� � �������, �������� ������ ������� � ������������ � �������� �����. �������� ����� ����� �������� �����������, �������� ����� � ����� ������ �� �����������.
//
//�������, ��� ��� ��������� ��������� �������� ����� � 50 000 ����� ��� 10 ����� � ��������������, ������������ ������ �������������� ������� ����� ����� �� ����������� �� �������.
//
//�������� �������� ��� �� ��������� �������:
//
//��� ��������� ����� ����������� � ������ ����� ������ ����, � ��� ����� � ����������;
//�������� ����� ���� ����� ���� ��������� �������� ������ ���� (��������, "����" � "���� �����");
//����, � ������� ��� ������, ���� ������ �������������� � �������� �����;
//� �������� �������� ������ ���� ������������ ������ '\n' (������� ������ � ����� UNIX);
//������ �����������, �� ���������� ������ �������� � ����� �����.
//Sample Input:
//
//roles:
//����������
//����� ���������
//������� ����������
//���� �����
//textLines:
//����������: � ��������� ���, �������, � ���, ����� �������� ��� ������������� ��������: � ��� ���� �������.
//����� ���������: ��� �������?
//������� ����������: ��� �������?
//����������: ������� �� ����������, ���������. � ��� � ��������� ������������.
//����� ���������: ��� �� ��!
//������� ����������: ��� �� ���� ������, ��� �����!
//���� �����: ������� ����! ��� � � ��������� ������������!
//Sample Output:
//
//����������:
//1) � ��������� ���, �������, � ���, ����� �������� ��� ������������� ��������: � ��� ���� �������.
//4) ������� �� ����������, ���������. � ��� � ��������� ������������.
//
//����� ���������:
//2) ��� �������?
//5) ��� �� ��!
//
//������� ����������:
//3) ��� �������?
//6) ��� �� ���� ������, ��� �����!
//
//���� �����:
//7) ������� ����! ��� � � ��������� ������������!

package org.example.section_2._4;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Task_2_4_3 {
    private String printTextPerRoleVar1(String[] roles, String[] textLines) {
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

    private static String printTextPerRoleVar2(String[] roles, String[] textLines) {
        LinkedHashMap<String, ArrayList<String>> linkedHashMap = new LinkedHashMap<>();
        for (String role : roles) {
            linkedHashMap.put(role, new ArrayList<>());
        }

        for (int i = 0; i < textLines.length; i++) {
            int indexChar = textLines[i].indexOf(':');
            String currentRole = textLines[i].substring(0, indexChar).split(" ")[0];
            String currentActor = linkedHashMap.keySet().stream().filter(el -> el.contains(currentRole)).findFirst().get();
            String currentText = textLines[i].substring(indexChar + 1).trim();
            linkedHashMap.get(currentActor).add((i + 1) + ") " + currentText);
        }

        StringBuilder text = new StringBuilder();
        for (String role : linkedHashMap.keySet()) {
            text.append(role.concat(":\n"));
            for (String roleText : linkedHashMap.get(role)) {
                text.append(roleText.concat("\n"));
            }
            text.append("\n");
        }
        return String.valueOf(text);
    }
}
