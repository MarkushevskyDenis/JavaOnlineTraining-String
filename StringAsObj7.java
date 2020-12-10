package by.jonline.grow.string;

/**
 * Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde
 * def", то должно быть выведено "abcdef".
 */

public class StringAsObj7 {
    public static void main(String[] args) {

        StringBuilder str = new StringBuilder("dddde n   isdddd");

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    str.deleteCharAt(j);
                    j--;
                }
            }

            if (str.charAt(i) == ' ') {
                str.deleteCharAt(i);
                i--;
            }
        }

        System.out.println(str);
    }
}
