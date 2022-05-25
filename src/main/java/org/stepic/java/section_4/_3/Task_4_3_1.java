//В этой задаче вам нужно реализовать метод, настраивающий параметры логирования.
// Конфигурирование в коде позволяет выполнить более тонкую и хитрую настройку, чем при помощи properties-файла.
//Требуется выставить такие настройки, чтобы:
//Логгер с именем "org.stepic.java.logging.ClassA" принимал сообщения всех уровней.
//Логгер с именем "org.stepic.java.logging.ClassB" принимал только сообщения уровня WARNING и серьезнее.
//Все сообщения, пришедшие от нижестоящих логгеров на уровень "org.stepic.java",
// независимо от серьезности сообщения печатались в консоль в формате XML (*) и не передавались вышестоящим обработчикам на уровнях "org.stepic", "org" и "".
//Не упомянутые здесь настройки изменяться не должны.
//(*) В реальных программах мы бы конечно печатали XML не в консоль, а в файл. Но проверяющая система не разрешает создавать файлы на диске, поэтому придется так.
//Подсказки:
//Level есть не только у Logger, но и у Handler.
//Передача сообщения на обработку родительскому Handler'у регулируется свойством useParentHandlers.

package org.stepic.java.section_4._3;

import java.util.logging.*;

public class Task_4_3_1 {

    public static void main(String[] args) {
        configureLogging();
    }

    private static void configureLogging() {
        Logger logA = Logger.getLogger("org.stepic.java.logging.ClassA");
        logA.setLevel(Level.ALL);

        Logger logB = Logger.getLogger("org.stepic.java.logging.ClassB");
        logB.setLevel(Level.WARNING);

        Logger log = Logger.getLogger("org.stepic.java");
        log.setUseParentHandlers(false);

        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        log.addHandler(handler);

        XMLFormatter formatter = new XMLFormatter();
        handler.setFormatter(formatter);
    }
}

