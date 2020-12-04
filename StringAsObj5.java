package by.jonline.grow.string;

/**
 * Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.
 */

public class StringAsObj5 {
    public static void main(String[] args) {

        String str = "afsadfsafsafsdfsdfaaaa";
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') count++;
        }

        System.out.println(count);

    }
}
