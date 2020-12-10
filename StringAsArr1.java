package by.jonline.grow.string;

import java.util.Arrays;

/**
 * Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
 */

public class StringAsArr1 {
    public static void main(String[] args) {

        String[] str = {"varMF", "str", "countOfNumber", "copySTA", "hFEAADF"};

        for (int i = 0; i < str.length; i++) {

            str[i] = new String(transform(str[i].toCharArray()));

        }

        for (int i = 0; i < str.length; i++)
            System.out.println(str[i]);
    }

    static char[] transform(char[] arr) {

        for (int j = 0; j < arr.length; j++) {

            if (arr[j] >= 'A' && arr[j] <= 'Z') {

                arr[j] += 32;

                arr = Arrays.copyOf(arr,arr.length + 1);

                for (int k = arr.length - 1; k > j; k--) {
                    arr[k] = arr[k - 1];
                }
                arr[j] = '_';

            }
        }

        return arr;
    }


}
