//��� ����� ComplexNumber. �������������� � ��� ������ equals() � hashCode() ���,
//����� equals() ��������� ���������� ComplexNumber �� ����������� ����� re � im, � hashCode() ��� �� ������������� � ����������� equals().
//���������� hashCode(), ������������ ��������� ��� �� ����������� ������� ����� re � im, ��������� �� �����

package org.example.section_3._4;

import java.util.Objects;

public class Task_3_4_1 {
    public final class ComplexNumber {
        private final double re;
        private final double im;

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ComplexNumber that = (ComplexNumber) o;
            return Double.compare(that.re, re) == 0 && Double.compare(that.im, im) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(re, im);
        }
    }
}
