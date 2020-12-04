package by.jonline.grow.string;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных
 * операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
 * отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по
 * алфавиту.
 */

public class Regex1 {
    public static void main(String[] args) {
        String str = "\tДаны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой. Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить, пройдет ли кирпич через отверстие.\n\n\tДан массив названий переменных в camelCase!? Преобразовать названия в snake_case. Замените в строке все вхождения 'word' на 'letter'! В строке найти количество цифр?\nВ строке найти количество чисел!!\n\n\tДан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем. В строке вставить после каждого символа 'a' символ 'b'!?\n\n\tCоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине; отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.\n\n";
        String str1;
        str = "\tДаны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой. Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить, пройдет ли кирпич через отверстие.\n" +
                "\n" +
                "\tДан массив названий переменных в camelCase!? Преобразовать названия в snake_case. Замените в строке все вхождения 'word' на 'letter'! В строке найти количество цифр?\n" +
                "В строке найти количество чисел!!\n" +
                "\n" +
                "\tДан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем. В строке вставить после каждого символа 'a' символ 'b'!?\n" +
                "\n" +
                "\tСоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине; отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.\n" +
                "\n\n";
        str1 = "\tВ функции микроконтроллера на устройстве ПУ входят формирование\n" +
                "запросов на КП, получение и декодирование ответных посылок, а также\n" +
                "фиксации получаемых измерений на дисплей.\n\n" +
                "\tКак и в случае с устройством КП, для связи используется модем.\n\n" +
                "\tДля подключения дисплея используется параллельный интерфейс LPT.\n" +
                "Так как уровни сигналов микроконтроллера одинаковые с уровнями\n" +
                "интерфейса, то используется прямое подключение линий микроконтроллера.\n\n" +
                "\tДля соединения ЖКИ - модуля с управляющей системой используется\n" +
                "параллельная синхронная шина, насчитывающая 8 линий данных, линию\n" +
                "выбора операции R/W, линию выбора регистра и линию стробирования и\n" +
                "синхронизации E.\n\n";
        //str = "\tпривет я,,,,, денис. меня зовут денис. как твои дела денис. все хорошо. я студент.\n\n";
        System.out.println(str);

        int kod;
        Scanner read = new Scanner(System.in);

        System.out.println("1 - отсортировать абзацы по количеству предложений;\n" +
                "2 - в каждом предложении отсортировать слова по длине;\n" +
                "3 - отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по\n" +
                "алфавиту");
        kod = read.nextInt();

        switch (kod) {
            case 1:
                sortParagraph(str);
                break;
            case 2:
                sortWord(str);
                break;
            case 3:
                sortLetter(str);
                break;
            default:
                System.out.println("что-то не то");
        }

    }

    static void sortParagraph(String str) {

        if (str.equals(null)) {
            return;
        }

        int[] count;
        String paragraph[] = getParagraph(str);
        String[][] sentence;

        sentence = getSentence(paragraph);
        count = getCountOf(sentence);
        sort(count, paragraph);

        System.out.println("--------Result--------");
        out(paragraph);

    }

    static void sortWord(String str) {

        if (str.equals(null)) {
            return;
        }

        String[] sentence;
        String[][] word;
        int[][] count;

        sentence = getSentence(str);
        word = getWord(sentence);

        count = new int[word.length][];
        for (int i = 0; i < word.length; i++) {
            count[i] = new int[word[i].length];
        }

        for (int i = 0; i < word.length; i++) {
            for (int j = 0; j < word[i].length; j++) {
                count[i][j] = word[i][j].length();
            }
        }

        for (int i = 0; i < word.length; i++) {
            sort(count[i], word[i]);
        }

        System.out.println("--------Result--------");
        for (int i = 0; i < word.length; i++) {
            out(word[i], ' ');
            out(null, '\n');
        }

    }

    static void sortLetter(String str) {

        if (str.equals(null)) {
            return;
        }

        String[] sentence;
        String[][] letter;

        sentence = getSentence(str);
        letter = getLetter(sentence);

        for (int i = 0; i < letter.length; i++) {    //сортировка по алфавиту
            sortABC(letter[i]);
        }

        for (int i = 0; i < letter.length; i++) {    //сортировка по количеству вхождений
            letter[i] = sort(letter[i]);
        }

        System.out.println("--------Result--------");
        for (int i = 0; i < letter.length; i++) {
            out(letter[i], ' ');
            out(null, '\n');
        }

    }

    static String[] getParagraph(String str) {                      //возвращает абзацы по исходному тексту

        Pattern pattern = Pattern.compile("\t.+((\n.+)+)?\n\n");
        Matcher matcher = pattern.matcher(str);

        int size = 0;
        while (matcher.find()) {
            size++;
        }
        String paragraph[] = new String[size];

        matcher.reset();
        for (int i = 0; i < size; i++) {
            if (matcher.find()) {
                paragraph[i] = matcher.group();
            }
        }
        return paragraph;
    }

    static String[][] getSentence(String[] paragraph) {             //возвращает предложения по абзацам

        Pattern pattern = Pattern.compile("\\!\\s|\\.\\s|\\?\\s");
        String[][] sentence = new String[paragraph.length][];

        for (int i = 0; i < paragraph.length; i++) {
            sentence[i] = pattern.split(paragraph[i]);
        }

        return sentence;
    }

    static String[] getSentence(String str) {             //возвращает предложения по тексту

        Pattern pattern = Pattern.compile("\\!\\s|\\.\\s|\\?\\s");
        String[] sentence;

        sentence = pattern.split(str);

        return sentence;
    }

    static String[][] getWord(String[] sentence) {             //возвращает слова по предложениям

        Pattern pattern = Pattern.compile("\\s");
        String[][] word = new String[sentence.length][];

        for (int i = 0; i < sentence.length; i++) {
            word[i] = pattern.split(sentence[i]);
        }

        return word;
    }

    static String[][] getLetter(String[] sentence) {             //возвращает слова по предложениям

        Pattern pattern = Pattern.compile("");
        String[][] letter = new String[sentence.length][];

        for (int i = 0; i < sentence.length; i++) {
            letter[i] = pattern.split(sentence[i]);
        }

        return letter;
    }


    static int[] getCountOf(String[][] arr) {        //возвращает количество элементов в совокупности

        int[] count = new int[arr.length];

        for (int i = 0; i < count.length; i++) {
            count[i] = arr[i].length;
        }

        return count;
    }

    static void sort(int[] arr, String[] str) {
        int swap;
        String swapStr;

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] > arr[i + 1]) {
                swap = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = swap;

                swapStr = str[i];
                str[i] = str[i + 1];
                str[i + 1] = swapStr;

                i = -1;
            }

        }


    }

    static void sortABC(String[] str) {
        String swapStr;

        for (int i = 0; i < str.length - 1; i++) {

            if (str[i].compareTo(str[i + 1]) > 0) {                 //если сортировка не чувствительна к регистру, то compareToIgnoreCase

                swapStr = str[i];
                str[i] = str[i + 1];
                str[i + 1] = swapStr;

                i = -1;
            }

        }


    }

    static String[] sort(String[] str) {
        String swapStr = "";

        for (int i = 0; i < str.length; i++) {                          //преобразование в строку
            swapStr += str[i];
        }

        String unique;
        unique = swapStr.replaceAll("(.)(?=.*?\\1)", "");//получение уникальных символом

        String[] group = new String[unique.length()];

        for (int i = 0; i < unique.length(); i++) {         //один элемент массива - одна уникальная группа

            char ch = unique.charAt(i);
            Pattern pattern;

            if (ch == '(') {
                pattern = Pattern.compile("\\(+");

            } else if (ch == ')') {
                pattern = Pattern.compile("\\)+");

            } else if (ch == '?') {
                pattern = Pattern.compile("\\?+");
            } else {
                pattern = Pattern.compile(ch + "+");
            }

            Matcher matcher = pattern.matcher(swapStr);
            matcher.find();
            group[i] = matcher.group();
        }


        for (int i = 0; i < group.length - 1; i++) {            //сортировка

            if (group[i].length() > group[i + 1].length()) {

                swapStr = group[i];
                group[i] = group[i + 1];
                group[i + 1] = swapStr;

                i = -1;
            }

        }

        return group;

    }


    static void out(String[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

    }

    static void out(String[] arr, char ch) {

        if (ch == '\n') {
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ch);
        }

    }

}
