//Реализуйте метод, который возвращает букву, стоящую в таблице UNICODE после символа "\" (обратный слэш) на расстоянии a.

package org.stepic.java.section_2._2;

public class Task_2_2_1 {
    public static char charExpression(int a) {
        return Character.toChars('\\' + a)[0];
    }
}
