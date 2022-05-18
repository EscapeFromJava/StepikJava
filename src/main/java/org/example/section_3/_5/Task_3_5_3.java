//����������, �� ������� ������� ���������� ������������ �� �����-�� ���-�������, ���� �� �������, �����-�������, � ����� ���� ��� ������� ������-�������� :)
//�� ������ ����������� ����������� �� ������ ���������, ����� ����� ��������� ����� ������� � �������������� ������.
//��������, �� ����� ����������� ����, ����������� � ���������� ����������� � ������� ������� �����������.
//���� ����� ����������� �� ������� ��������� �������� ���� � ������.
//���������� ���������� ����� ���������� �� ������� ������ �� ���� ��������� � :( =( :|
//������� ������� ����������� ����� ���������� ������ �� ������� ����� � ������������ ����� �����������.
//�� ������ �������������� ������ � ���� ���������� ����������:
//interface TextAnalyzer {
//    Label processText(String text);
//}
//Label � ���-������������, ������� �������� �����, �������� ����� �������� �����:
//enum Label {
//    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
//}
//������, ��� ���������� ����������� ��� ������, ������� ��������� ������ ���������: SpamAnalyzer, NegativeTextAnalyzer � TooLongTextAnalyzer.
//SpamAnalyzer ������ ���������������� �� ������� ����� � ��������� �������. ������ ����� ������ ������ ��������� � ����� ��������� ���� ������ ����� � ��������� ���� keywords.
//NegativeTextAnalyzer ������ ���������������� ������������� ��-���������.
//TooLongTextAnalyzer ������ ���������������� �� int'� � ������������ ���������� ������ �����������.
// ������ ����� ������ ������ ��������� � ����� ��������� ��� ����� � ��������� ���� maxLength.
//��������� �� ��� ��������, ��� SpamAnalyzer � NegativeTextAnalyzer �� ������ ������ � ��� ��� ��������� ����� �� ������� �����-���� �������� ����
// (� ������ ����� �� �������� �� �� ������������, � ������ ����������� ������ �� ������� ����� ����� �������� ���������)
// � � ������ ���������� ������ �� �������� ���� ����������  Label (SPAM � NEGATIVE_TEXT ��������������), � ���� ������ �� ������� � ���������� OK.
//������� ��� ������ ������������ � ����������� ����� KeywordAnalyzer ��������� �������:
//������� ��� ����������� ������ getKeywords � getLabel, ���� �� ������� ����� ���������� ����� �������� ����, � ������ �����,
// ������� ���������� �������� ������������� ������������. ��� ������� ���������� ��� ������ ������������ �������, ������� ������� ������ � ��� ������ ��� �����������.
//��������� processText ����� �������, ����� �� ������� ������ �� getKeywords � getLabel.
//������� SpamAnalyzer � NegativeTextAnalyzer ������������ KeywordAnalyzer � ��������� ����������� ������.
//��������� ����� � �������� ����� checkLabels, ������� ����� ���������� ����� ��� ����������� �� ������ ������������ ������.
// checkLabels ������ ���������� ������ ��-OK ����� � ������� ������� ������ ������������, � OK, ���� ��� ����������� ������� OK.
//�����������, ����������, ����������� ������� ��-��������� ��� ���� �������.
//� �����, ���������� ������ KeywordAnalyzer, SpamAnalyzer, NegativeTextAnalyzer � TooLongTextAnalyzer � ����� checkLabels.
// TextAnalyzer � Label ��� ����������, ������ ������� ��� �� �����������.

package org.example.section_3._5;

public class Task_3_5_3 {
    public static void main(String[] args) {

        // ������������� ������������ ��� �������� � ������� ������� ������ ������������
        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers1 = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers2 = {
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers3 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers4 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords)
        };
        TextAnalyzer[] textAnalyzers5 = {
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers6 = {
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords)
        };
        // �������� �����������
        String[] tests = new String[8];
        tests[0] = "This comment is so good.";                            // OK
        tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
        tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
        tests[4] = "This comment is so bad....";                          // SPAM
        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
        tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
        tests[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG
        TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3,
                textAnalyzers4, textAnalyzers5, textAnalyzers6};
        Task_3_5_3 testObject = new Task_3_5_3();
        int numberOfAnalyzer; // ����� �����������, ��������� � �������������� textAnalyzers{�}
        int numberOfTest = 0; // ����� �����, ������� ������������� ������� �������� ������������
        for (String test : tests) {
            numberOfAnalyzer = 1;
            System.out.print("test #" + numberOfTest + ": ");
            System.out.println(test);
            for (TextAnalyzer[] analyzers : textAnalyzers) {
                System.out.print(numberOfAnalyzer + ": ");
                Label result = testObject.checkLabels(analyzers, test);
                System.out.println(result);
                numberOfAnalyzer++;
            }
            numberOfTest++;
        }

    }

    public static Label checkLabels(TextAnalyzer[] analyzers, String test) {
        for (TextAnalyzer t : analyzers) {
            if(t.processText(test) != Label.OK) return t.processText(test);
        }
        return Label.OK;
    }
}

abstract class KeywordAnalyzer implements TextAnalyzer {
    abstract protected String[] getKeywords();
    abstract protected Label getLabel();
    @Override
    public Label processText(String text) {
        for (String keyword : getKeywords()) {
            if (text.contains(keyword))
                return getLabel();
        }
        return Label.OK;
    }
}

class SpamAnalyzer extends KeywordAnalyzer {
    private String[] keywords;
    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords.clone();
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }
}

class NegativeTextAnalyzer extends KeywordAnalyzer {

    @Override
    protected String[] getKeywords() {
        return new String[] {":(", "=(", ":|"};
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}

class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
        if (text.length() > maxLength) {
            return Label.TOO_LONG;
        }
        return Label.OK;
    }
}

interface TextAnalyzer {
    Label processText(String text);
}

enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}