//Ќа игровом поле находитс€ робот. ѕозици€ робота на поле описываетс€ двум€ целочисленным координатами: X и Y.
//ќсь X смотрит слева направо, ось Y Ч снизу вверх. (ѕомните, как рисовали графики функций в школе?)
//¬ начальный момент робот находитс€ в некоторой позиции на поле. “акже известно, куда робот смотрит: вверх, вниз, направо или налево.
//¬аша задача Ч привести робота в заданную точку игрового пол€.
//–обот описываетс€ классом Robot. ¬ы можете пользоватьс€ следующими его методами (реализаци€ вам неизвестна):
//
//public class Robot {
//
//    public Direction getDirection() {
//        // текущее направление взгл€да
//    }
//
//    public int getX() {
//        // текуща€ координата X
//    }
//
//    public int getY() {
//        // текуща€ координата Y
//    }
//
//    public void turnLeft() {
//        // повернутьс€ на 90 градусов против часовой стрелки
//    }
//
//    public void turnRight() {
//        // повернутьс€ на 90 градусов по часовой стрелке
//    }
//
//    public void stepForward() {
//        // шаг в направлении взгл€да
//        // за один шаг робот измен€ет одну свою координату на единицу
//    }
//}
//Direction, направление взгл€да робота,  Ч это перечисление:
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