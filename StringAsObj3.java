package by.jonline.grow.string;

/**
 * Проверить, является ли заданное слово палиндромом.
 */

public class StringAsObj3 {
    public static void main(String[] args) {

        String s = "Anna";
        StringBuilder str = new StringBuilder(s);


        str.reverse();
        if (s.equalsIgnoreCase(str.toString())) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }
}
