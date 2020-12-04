package by.jonline.grow.string;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Дана строка, содержащая следующий текст (xml-документ):
 * <notes>
 * <note id = "1">
 * <to>Вася</to>
 * <from>Света</from>
 * <heading>Напоминание</heading>
 * <body>Позвони мне завтра!</body>
 * </note>
 * <note id = "2">
 * <to>Петя</to>
 * <from>Маша</from>
 * <heading>Важное напоминание</heading>
 * </body>
 * </note>
 * </notes>
 * Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип (открывающий
 * тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи
 * нельзя.
 */

public class Regex2 {
    public static void main(String[] args) {
        String str = " <notes>\n" +
                "\t<note id = \"1\">\n" +
                "\t\t<to>Вася</to>\n" +
                "\t\t<from>Света</from>\n" +
                "\t\t<heading>Напоминание</heading>\n" +
                "\t\t<body>Позвони мне завтра!</body>\n" +
                "\t</note>\n" +
                "\t<note id = \"2\">\n" +
                "\t\t<to>Петя</to>\n" +
                "\t\t<from>Маша</from>\n" +
                "\t\t<heading>Важное напоминание</heading>\n" +
                "\t\t<body/>\n" +
                "\t</note>\n" +
                " </notes>\n";

        System.out.println(str);

        while (true) {

            System.out.println("введите тег");
            Scanner read = new Scanner(System.in);
            String teg = read.nextLine();

            Pattern pattern = Pattern.compile("<" + teg + "( .+)?/?>(((\n.+?)+)?(.+)?</" + teg + ">)?");
            Matcher matcher = pattern.matcher(str);

            while (matcher.find()) {
                System.out.println("--------------------");
                System.out.println(matcher.group());
                System.out.println("--------------------");
            }

        }

    }
}
