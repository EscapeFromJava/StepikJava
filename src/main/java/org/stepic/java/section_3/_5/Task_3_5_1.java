//Реализуйте метод, выполняющий численное интегрирование заданной функции на заданном интервале по формуле левых прямоугольников.
//Функция задана объектом, реализующим интерфейс java.util.function.DoubleUnaryOperator.
//Его метод applyAsDouble() принимает значение аргумента и возвращает значение функции в заданной точке.
//Интервал интегрирования задается его конечными точками a и b, причем a<=b.
//Для получения достаточно точного результата используйте шаг сетки не больше 10^{-6}.
//Пример.
//Вызов integrate(x -> 1, 0, 10) должен возвращать значение 10.

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
