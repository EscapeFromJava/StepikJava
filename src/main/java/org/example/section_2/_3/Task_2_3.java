//Реализуйте метод, проверяющий, является ли заданная строка палиндромом. Палиндромом называется строка, которая читается одинаково слева направо и
//справа налево (в том числе пустая). При определении "палиндромности" строки должны учитываться только буквы и цифры. А пробелы, знаки препинания,
//а также регистр символов должны игнорироваться. Гарантируется, что в метод попадают только строки, состоящие из символов ASCII
//(цифры, латинские буквы, знаки препинания). Т.е. русских, китайских и прочих экзотических символов в строке не будет.

package org.example.section_2._3;

public class Task_2_3 {
    public static boolean isPalindrome(String text) {
        StringBuilder stringBuilder = new StringBuilder(text.replaceAll("[^\\da-zA-Z]", ""));
        return String.valueOf(stringBuilder).equalsIgnoreCase(String.valueOf(stringBuilder.reverse()));
    }
}
