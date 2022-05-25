//���������� �����, ����������� ��������� �������������� �������� ������� �� �������� ��������� �� ������� ����� ���������������.
//������� ������ ��������, ����������� ��������� java.util.function.DoubleUnaryOperator.
//��� ����� applyAsDouble() ��������� �������� ��������� � ���������� �������� ������� � �������� �����.
//�������� �������������� �������� ��� ��������� ������� a � b, ������ a<=b.
//��� ��������� ���������� ������� ���������� ����������� ��� ����� �� ������ 10^{-6}.
//������.
//����� integrate(x -> 1, 0, 10) ������ ���������� �������� 10.

package org.stepic.java.section_3._5;

import java.util.function.DoubleUnaryOperator;

public class Task_3_5_1 {
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double step = 1e-7;
        double area = 0;
        while (a < b) {
            area += f.applyAsDouble(a + step) * step;
            a += step;
        }
        return area;
    }
}
