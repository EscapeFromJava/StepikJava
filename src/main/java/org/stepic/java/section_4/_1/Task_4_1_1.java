//���������� ����� sqrt(), ����������� ���������� ������ �����.
//� ������� �� Math.sqrt(), ��� ����� ��� �������� �������������� ��������� ������ ������� ���������� java.lang.IllegalArgumentException
//� ���������� "Expected non-negative number, got ?", ��� ������ ��������� ����� ����������� ���������� ���������� � ����� �����.

package org.stepic.java.section_4._1;

public class Task_4_1_1 {
    public static double sqrt(double x) {
        if (x < 0)
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        return Math.sqrt(x);
    }

}
