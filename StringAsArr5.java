package by.jonline.grow.string;

/**
 * Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
 * Крайние пробелы в строке удалить.
 */

public class StringAsArr5 {
    public static void main(String[] args) {

        String str = "denis   denis denis  denis    denis denis  denis       denis";
        int count = 0;
        char[] arr;

        arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == ' ') {

                if (arr[i + 1] == ' ') {

                    count++;

                } else {
                    move(arr, i - count + 1, count);
                    arr = changeSize(arr, -count);
                    count = 0;
                }

            }

        }

        str = new String(arr);
        System.out.println(str);

    }

    static void move(char[] arr, int j, int n) {

        for (int i = 0; i < n; i++)
            for (int k = j; k < arr.length - 1; k++) {
                arr[k] = arr[k + 1];
            }

    }

    static char[] changeSize(char[] arr, int n) {

        char[] clone = new char[arr.length + n];

        if (n > 0) {
            for (int k = 0; k < arr.length; k++) {
                clone[k] = arr[k];
            }
        } else if (n < 0) {
            for (int k = 0; k < clone.length; k++) {
                clone[k] = arr[k];
            }
        } else {
            //System.out.println("введен 0, массив не изменен");
            return arr;
        }

        return clone;

    }


}
