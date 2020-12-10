package by.jonline.grow.string;

/**
 * Из заданной строки получить новую, повторив каждый символ дважды.
 */

public class StringAsObj6 {
    public static void main(String[] args) {

        StringBuilder str = new StringBuilder("deniss");
        int length;

        length = str.length() * 2;

        for (int i = 0; i < length; i += 2) {
            str.insert(i + 1, str.charAt(i));
        }

        System.out.println(str);
    }
}
