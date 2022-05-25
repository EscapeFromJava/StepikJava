//���������� �����, ����������� ������ ������� ������, ������ �� �������.
//����� getCallerClassAndMethodName() ������ ���������� ��� ������ � ������, ������ ������ �����, ��������� ������ ��������� �����.
//��� null (������� ������, � �� ������ "null"), ���� �����, ��������� getCallerClassAndMethodName() �������� ������ ����� � ���������, �.�. ��� ����� �� �������.
//��� ���������, ��������, � ����������� �����������, ��� ��� ������� ��������� � ���� ���� �������� ����� � �����, ������ ��������� ���� ������������.
//������
//package org.stepic.java.example;
//public class Test {
//    public static void main(String[] args) {
//        System.out.println(getCallerClassAndMethodName());
//        anotherMethod();
//    }
//    private static void anotherMethod() {
//        System.out.println(getCallerClassAndMethodName());
//    }
//    public static String getCallerClassAndMethodName() {
//        // ...
//    }
//}
//��� ������� ��� ��������� ������ �������:
//null
//org.stepic.java.example.Test#main
//P.S. ��� ������������ ���� ��������� � ����� ���������� �� ������ �������� ������ ���������:
//������ null � ������ ������� ����� ��������� �����-�� ����������� ����� � �����.
//��� ������� � ���, ��� ����� ���������� ������ ��������� �� ��� �����, � ���� �����������,
//������� ����� ��� �������� ���. ����� ����� ��������, ���������� ��������� �������� "java" � ��������� ������.

package org.stepic.java.section_4._1;

public class Task_4_1_2 {

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] methods = Thread.currentThread().getStackTrace();
        if (methods.length > 3) {
            return methods[3].getClassName() + "#" + methods[3].getMethodName();
        }
        return null;
    }
}
