//Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c?
//Допустимая погрешность – 0.0001 (1E-4)

package org.example.section_2._1;

public class Task_2_1_3 {
    public static boolean doubleExpression(double a, double b, double c) {
        return (float) a + (float) b == (float) c;
    }
}
