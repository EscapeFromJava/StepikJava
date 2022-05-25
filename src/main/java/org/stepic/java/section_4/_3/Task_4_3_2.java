/*Вам необходимо описать набор классов, каждый из которых является MailService:

1) UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты, который вместо того, чтобы передать почтовый
 объект непосредственно в сервис почты, последовательно передает этот объект набору третьих лиц, а затем, в конце концов,
 передает получившийся объект непосредственно экземпляру RealMailService. У UntrustworthyMailWorker должен быть конструктор
  от массива MailService ( результат вызова processMail первого элемента массива передается на вход processMail второго элемента, и т. д.)
  и метод getRealMailService, который возвращает ссылку на внутренний экземпляр RealMailService.

2) Spy – шпион, который логгирует о всей почтовой переписке, которая проходит через его руки. Объект конструируется от
 экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях. Он следит только за объектами класса
 MailMessage и пишет в логгер следующие сообщения (в выражениях нужно заменить части в фигурных скобках на значения полей почты):
2.1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог сообщение с уровнем WARN:
Detected target mail correspondence: from {from} to {to} "{message}"
2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}

3) Thief – вор, который ворует самые ценные посылки и игнорирует все остальное. Вор принимает в конструкторе переменную
 int – минимальную стоимость посылки, которую он будет воровать. Также, в данном классе должен присутствовать метод
  getStolenValue, который возвращает суммарную стоимость всех посылок, которые он своровал. Воровство происходит
   следующим образом: вместо посылки, которая пришла вору, он отдает новую, такую же, только с нулевой ценностью и содержимым посылки "stones instead of {content}".

4) Inspector – Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения,
 если была обнаружена подобная посылка. Если он заметил запрещенную посылку с одним из запрещенных содержимым ("weapons"
 и "banned substance"), то он бросает IllegalPackageException. Если он находит посылку, состоящую из камней (содержит
 слово "stones"), то тревога прозвучит в виде StolenPackageException. Оба исключения вы должны объявить самостоятельно в виде непроверяемых исключений.

Все классы должны быть определены как публичные и статические, так как в процессе проверки ваш код будет подставлен
во внешний класс, который занимается тестированием и проверкой структуры. Для удобства во внешнем классе объявлено
 несколько удобных констант и импортировано все содержимое пакета java.util.logging. Для определения, посылкой или
  письмом является Sendable объект воспользуйтесь оператором instanceof.*/

package org.stepic.java.section_4._3;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Task_4_3_2 {

    public static class Thief implements MailService {
        private static int stolenValue;
        private static int minValue;

        public Thief(int m) {
            minValue = m;
        }

        public int getStolenValue() {
            return stolenValue;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                if (minValue <= ((MailPackage) mail).getContent().getPrice()) {
                    stolenValue += ((MailPackage) mail).getContent().getPrice();
                    return new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of " + ((MailPackage) mail).getContent().getContent(), 0));
                }
            }
            return mail;
        }

    }

    public static class Spy implements MailService {

        private final Logger logger;

        public Spy(Logger l) {
            logger = l;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                if (((MailMessage) mail).from.equals(AUSTIN_POWERS) || ((MailMessage) mail).to.equals(AUSTIN_POWERS)) {
                    logger.log(Level.WARNING, "Detected target mail correspondence: from " + ((MailMessage) mail).from + " to " + ((MailMessage) mail).to + " \"" + ((MailMessage) mail).message + "\"");
                } else {
                    logger.log(Level.INFO, "Usual correspondence: from " + ((MailMessage) mail).from + " to " + ((MailMessage) mail).to);
                }
            }
            return null;
        }
    }

    public static class IllegalPackageException extends RuntimeException {

        public IllegalPackageException() {
        }

        public IllegalPackageException(String message) {
        }
    }

    public static class StolenPackageException extends RuntimeException {
        public StolenPackageException() {
        }

        public StolenPackageException(String message) {
        }
    }

    public static class Inspector implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                if (((MailPackage) mail).content.content.contains(WEAPONS) || ((MailPackage) mail).content.content.contains(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                }
                if (((MailPackage) mail).content.content.contains("stones")) {
                    throw new StolenPackageException();
                }
            }
            return null;
        }
    }

    public static class UntrustworthyMailWorker implements MailService {

        protected final MailService[] mailServices;
        protected final RealMailService realMailService;

        public UntrustworthyMailWorker(MailService[] mailServices){
            this.mailServices = mailServices;
            this.realMailService = new RealMailService();
        }

        public RealMailService  getRealMailService() {
            return realMailService;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            Sendable processed = mail;
            for (int i = 0; i < mailServices.length; i++) {
                processed = mailServices[i].processMail(processed);
            }
            return realMailService.processMail(mail);
        }
    }

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Task_4_3_2.class.getName());

        Inspector inspector = new Inspector();
        Spy spy = new Spy(logger);
        Thief thief = new Thief(10000);
        MailService variousWorkers[] = new MailService[]{spy, thief, inspector};
        UntrustworthyMailWorker worker = new UntrustworthyMailWorker(variousWorkers);

        AbstractSendable correspondence[] = {
                new MailMessage("Oxxxymiron", "Гнойный", "Я здесь чисто по фану, поглумиться над слабым\n" +
                        "Ты же вылез из мамы под мой дисс на Бабана...."),
                new MailMessage("Гнойный", "Oxxxymiron", "....Что? Так болел за Россию, что на нервах терял ганглии.\n" +
                        "Но когда тут проходили митинги, где ты сидел? В Англии!...."),
                new MailMessage("Жриновский", AUSTIN_POWERS, "Бери пацанов, и несите меня к воде."),
                new MailMessage(AUSTIN_POWERS, "Пацаны", "Го, потаскаем Вольфовича как Клеопатру"),
                new MailPackage("берег", "море", new Package("ВВЖ", 32)),
                new MailMessage("NASA", AUSTIN_POWERS, "Найди в России ракетные двигатели и лунные stones"),
                new MailPackage(AUSTIN_POWERS, "NASA", new Package("рпакетный двигатель ", 2500000)),
                new MailPackage(AUSTIN_POWERS, "NASA", new Package("stones", 1000)),
                new MailPackage("Китай", "КНДР", new Package("banned substance", 99)),
                new MailPackage(AUSTIN_POWERS, "ИГИЛ (запрещенная группировка", new Package("tiny bomb", 9000)),
                new MailMessage(AUSTIN_POWERS, "Психиатр", "Помогите"),
        };
        Arrays.stream(correspondence).forEach(parcell -> {
            try {
                worker.processMail(parcell);
            } catch (StolenPackageException e) {
                logger.log(Level.WARNING, "Inspector found stolen package: " + e);
            } catch (IllegalPackageException e) {
                logger.log(Level.WARNING, "Inspector found illegal package: " + e);
            }
        });
    }


    /*
    Интерфейс: сущность, которую можно отправить по почте.
    У такой сущности можно получить от кого и кому направляется письмо.
    */
    public interface Sendable {
        String getFrom();

        String getTo();
    }

    /*
Абстрактный класс,который позволяет абстрагировать логику хранения
источника и получателя письма в соответствующих полях класса.
*/
    public static abstract class AbstractSendable implements Sendable {

        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (!from.equals(that.from)) return false;
            return to.equals(that.to);
        }

    }

    /*
Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
*/
    public static class MailMessage extends AbstractSendable {

        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            return message != null ? message.equals(that.message) : that.message == null;
        }

    }

    /*
Посылка, содержимое которой можно получить с помощью метода `getContent`
*/
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            return content.equals(that.content);
        }

    }

    /*
Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
*/
    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            return content.equals(aPackage.content);
        }
    }

    /*
Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
*/
    public interface MailService {
        Sendable processMail(Sendable mail);
    }

    /*
    Класс, в котором скрыта логика настоящей почты
    */
    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }

}