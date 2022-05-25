//�������� ������ ������� ��������� ������ �� ���� ������. ������ �� ����� ������ ������ ������� ��������, ����������� � ���� �� ������������� ������ �����.
//����������� � ������ �������������� � ��������� ����������� RobotConnection:
//public interface RobotConnection extends AutoCloseable {
//    void moveRobotTo(int x, int y);
//    @Override
//    void close();
//}
//��, ����� � ��� ��� ������� � ���� �������� ������� �� ����������� � �������� ����� (����� moveRobotTo). ��� ������ �� ����� ��������� ����������.
//RobotConnection � ��� �������� ��������������� ����������, ������� ���� ���������, ����� ��� ������ �� �����. ��� �������� ���������� � ���������� ���� ����� close().
//�� ��������� ���������� �������� RobotConnectionManager:
//
//public interface RobotConnectionManager {
//    RobotConnection getConnection();
//}
//����� getConnection() ������ ������� ����������� � ������� � ���������� ������������� ����������, ����� ������� ����� �������� ������ �������.
//��������� ���������� ����� ����������� ���������, � ����� ��� ������������� ���������� ����� �������� �����������. ������ ������.
//������� ����� ����� RobotConnectionManager � RobotConnection ����� ������� ������������� ���������� RobotConnectionException:
//
//public class RobotConnectionException extends RuntimeException {
//
//    public RobotConnectionException(String message) {
//        super(message);
//
//    }
//
//    public RobotConnectionException(String message, Throwable cause) {
//        super(message, cause);
//    }
//}
//���� ������ � ����������� ����� ������� ������������� ���������� � �������, ������ ��� ������� �� ����������� � �������� ����� �
// ����� ��������� ����������, �������� ��� ������������� ������ ���� ������������������ �� ���� ���.
//
//��� ����:
//������� ������ ������� ������ ��������� ��������, ���� ������� ���������� ���������� � ��������� ����� RobotConnection.moveRobotTo() ��� ����������.
//������ �������� ���������� �� ����� � ������ ��������������.
//���� ������ ������� ������������ � ������ ������� ��������� ����������, �� ��������� ���������� � ��������� ������ �������.
//���� ������ ���� �� �������, �� ����������� ������. ����� ������� ������� ����� ������ ������� ���������� RobotConnectionException.
//����� �������� �� �������� � �������� ����������. ���� ���������� ������� ����������, �� ��� ����������� ������ ���� �������
//�������� �� ��������� ����������, ����������� � ���������� �� ����� ������ ������.
//���� �� ����� ������ ������ ��������� ���������� ������ ����, ��������� �� RobotConnectionException, ����� ������ ����������� �
//��������� ��� ����������, �� �������� ��������� ������� ���������� � �������. ������������, ��� ����� ������ ������� �����
//�������� ����� ���������� � ������� �������� ���������� RobotConnection.

package org.stepic.java.section_4._2;

public class Task_4_2_1 {

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        for (int i = 0; i < 3; i++) {
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
                robotConnection.moveRobotTo(toX, toY);
                i = 3;
            } catch (RobotConnectionException e) {
                if (i == 2) {
                    throw new RobotConnectionException("error");
                }
            }
        }
    }
}


interface RobotConnectionManager {
    RobotConnection getConnection();
}

interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);

    @Override
    void close();
}

class RobotConnectionException extends RuntimeException {

    public RobotConnectionException(String message) {
        super(message);

    }

    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}

