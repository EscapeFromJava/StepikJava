//�� ������� ���� ��������� �����. ������� ������ �� ���� ����������� ����� ������������� ������������: X � Y.
//��� X ������� ����� �������, ��� Y � ����� �����. (�������, ��� �������� ������� ������� � �����?)
//� ��������� ������ ����� ��������� � ��������� ������� �� ����. ����� ��������, ���� ����� �������: �����, ����, ������� ��� ������.
//���� ������ � �������� ������ � �������� ����� �������� ����.
//����� ����������� ������� Robot. �� ������ ������������ ���������� ��� �������� (���������� ��� ����������):
//
//public class Robot {
//
//    public Direction getDirection() {
//        // ������� ����������� �������
//    }
//
//    public int getX() {
//        // ������� ���������� X
//    }
//
//    public int getY() {
//        // ������� ���������� Y
//    }
//
//    public void turnLeft() {
//        // ����������� �� 90 �������� ������ ������� �������
//    }
//
//    public void turnRight() {
//        // ����������� �� 90 �������� �� ������� �������
//    }
//
//    public void stepForward() {
//        // ��� � ����������� �������
//        // �� ���� ��� ����� �������� ���� ���� ���������� �� �������
//    }
//}
//Direction, ����������� ������� ������,  � ��� ������������:
//public enum Direction {
//    UP,
//    DOWN,
//    LEFT,
//    RIGHT
//}

package org.stepic.java.section_3._3;

public class Task_3_3_1 {
    public static void moveRobot(Robot robot, int toX, int toY) {
        if (robot.getX() < toX) {
            while (robot.getDirection() != Direction.RIGHT) {
                robot.turnRight();
            }
        }
        else {
            while (robot.getDirection() != Direction.LEFT) {
                robot.turnRight();
            }
        }
        while (robot.getX() != toX) {
            robot.stepForward();
        }

        if (robot.getY() < toY) {
            while (robot.getDirection() != Direction.UP) {
                robot.turnLeft();
            }
        }
        else {
            while (robot.getDirection() != Direction.DOWN) {
                robot.turnLeft();
            }
        }
        while (robot.getY() != toY) {
            robot.stepForward();
        }
    }
}

class Robot {
    public Direction getDirection() {
        return null;
    }

    public int getX() {
        return 0;
    }

    public int getY() {
        return 0;
    }

    public void turnLeft() {
    }

    public void turnRight() {
    }

    public void stepForward() {
    }
}

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}