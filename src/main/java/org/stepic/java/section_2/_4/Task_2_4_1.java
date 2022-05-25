//Реализуйте метод, вычисляющий факториал заданного натурального числа.
//Факториал NN вычисляется как 1 \cdot 2 \cdot ... \cdot N1?2?...?N.
//Поскольку это очень быстро растущая функция, то даже для небольших NN вместимости типов int и long очень скоро не хватит. Поэтому будем использовать BigInteger.

package org.stepic.java.section_2._4;

import java.math.BigInteger;

public class Task_2_4_1 {
    public static BigInteger factorial(int value) {
        if (value == 1)
            return BigInteger.valueOf(1);
        return BigInteger.valueOf(value).multiply(factorial(value - 1));
    }
}
