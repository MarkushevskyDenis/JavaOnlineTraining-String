package by.jonline.grow.string;

import java.util.Arrays;

/**
 * Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
 * Крайние пробелы в строке удалить.
 */

public class StringAsArr5 {
    public static void main(String[] args) {

        String str = "     denis   denis       denis  denis    denis denis  denis       denis ";
        char[] arr;

        arr = str.toCharArray();

        arr = firstSpace(arr);
        arr = centerSpace(arr);
        arr = lastSpace(arr);

        str = new String(arr);
        System.out.println("\\" + str + "\\");

    }

    static char[] firstSpace(char[] arr) {
        int count = 0;
        int i = 0;

        if (arr[i] == ' ') {

            while (arr[i] == ' ') {
                count++;
                i++;
            }

            move(arr, 0, count);
            arr = Arrays.copyOf(arr, arr.length - count);
        }
        return arr;
    }

    static char[] centerSpace(char[] arr) {

        int count = 0;
        int j = 0;
        boolean q = true;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == ' ') {

                if (q) {
                    j = i;
                    q = false;
                }

                if (i + 1 != arr.length && arr[i + 1] == ' ') {
                    count++;
                } else {
                    move(arr, i - count + 1, count);
                    arr = Arrays.copyOf(arr, arr.length - count);
                    count = 0;

                    i = j;
                    q = true;
                }
            }
        }
        return arr;
    }

    static char[] lastSpace(char[] arr) {

        int i = arr.length - 1;

        if (arr[i] == ' ') {
            move(arr, arr.length - 1, 1);
            arr = Arrays.copyOf(arr, arr.length - 1);
        }

        return arr;
    }

    static void move(char[] arr, int j, int n) {

        for (int i = 0; i < n; i++)
            for (int k = j; k < arr.length - 1; k++) {
                arr[k] = arr[k + 1];
            }

    }

}
