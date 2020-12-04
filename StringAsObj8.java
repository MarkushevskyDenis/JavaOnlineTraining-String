package by.jonline.grow.string;

/**
 * Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда самых
 * длинных слов может быть несколько, не обрабатывать.
 */

public class StringAsObj8 {
    public static void main(String[] args) {

        String str = "1234 12345678    123    1234567       ";
        int count = 0;
        int max = 0;
        int ind = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) != ' ') {
                count++;
            } else {
                count = 0;
            }

            if (count > max) {
                max = count;
                ind = i;
            }

        }
        System.out.println(str.substring(ind - max + 1, ind + 1));

    }
}
