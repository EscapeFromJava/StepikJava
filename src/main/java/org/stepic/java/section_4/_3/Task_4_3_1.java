//� ���� ������ ��� ����� ����������� �����, ������������� ��������� �����������.
// ���������������� � ���� ��������� ��������� ����� ������ � ������ ���������, ��� ��� ������ properties-�����.
//��������� ��������� ����� ���������, �����:
//������ � ������ "org.stepic.java.logging.ClassA" �������� ��������� ���� �������.
//������ � ������ "org.stepic.java.logging.ClassB" �������� ������ ��������� ������ WARNING � ���������.
//��� ���������, ��������� �� ����������� �������� �� ������� "org.stepic.java",
// ���������� �� ����������� ��������� ���������� � ������� � ������� XML (*) � �� ������������ ����������� ������������ �� ������� "org.stepic", "org" � "".
//�� ���������� ����� ��������� ���������� �� ������.
//(*) � �������� ���������� �� �� ������� �������� XML �� � �������, � � ����. �� ����������� ������� �� ��������� ��������� ����� �� �����, ������� �������� ���.
//���������:
//Level ���� �� ������ � Logger, �� � � Handler.
//�������� ��������� �� ��������� ������������� Handler'� ������������ ��������� useParentHandlers.

package org.stepic.java.section_4._3;

import java.util.logging.*;

public class Task_4_3_1 {

    public static void main(String[] args) {
        configureLogging();
    }

    private static void configureLogging() {
        Logger logA = Logger.getLogger("org.stepic.java.logging.ClassA");
        logA.setLevel(Level.ALL);

        Logger logB = Logger.getLogger("org.stepic.java.logging.ClassB");
        logB.setLevel(Level.WARNING);

        Logger log = Logger.getLogger("org.stepic.java");
        log.setUseParentHandlers(false);

        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        log.addHandler(handler);

        XMLFormatter formatter = new XMLFormatter();
        handler.setFormatter(formatter);
    }
}

