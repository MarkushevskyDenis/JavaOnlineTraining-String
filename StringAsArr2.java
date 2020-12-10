package by.jonline.grow.string;

import java.util.Arrays;

/**
 * Замените в строке все вхождения 'word' на 'letter'
 */

public class StringAsArr2 {
    public static void main(String[] args) {

        String str = "123w12wordworwordword letterword worwordword";

        str = new String(transform(str.toCharArray()));

        System.out.println(str);
    }

    static char[] transform(char[] arr) {

        for (int j = 0; j < arr.length; j++) {

            if (arr[j] == 'w') {
                if (arr[j + 1] == 'o' && arr[j + 2] == 'r' && arr[j + 3] == 'd') {

                    arr = Arrays.copyOf(arr, arr.length + 2);
                    move(arr, j, 2);
                    arr[j] = 'l';
                    arr[j + 1] = 'e';
                    arr[j + 2] = 't';
                    arr[j + 3] = 't';
                    arr[j + 4] = 'e';
                    arr[j + 5] = 'r';

                    j += 5;

                }
            }
        }

        return arr;
    }


    static void move(char[] arr, int j, int n) {

        for (int i = 0; i < n; i++) {
            for (int k = arr.length - 1; k > j; k--) {
                arr[k] = arr[k - 1];
            }
        }

    }


}


