package by.jonline.grow.string;

/**
 * Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.
 */

public class StringAsObj1 {
    public static void main(String[] args) {

        int max = 0;
        int count = 0;
        String str = "sdfds    sdfdsfd    sdf ds      dsfdsf      d         ";

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == ' ') {
                count++;
            } else {
                count = 0;
            }

            if (count > max) {
                max = count;
            }

        }

        System.out.println(max);

    }
}
