package by.jonline.grow.string;

/**
 * С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.
 */

public class StringAsObj4 {
    public static void main(String[] args) {

        String str = "информатика";
        String res;

        res = str.copyValueOf(str.toCharArray(), 7, 1)
                + str.copyValueOf(str.toCharArray(), 3, 2)
                + str.copyValueOf(str.toCharArray(), 7, 1);

        System.out.println(res);
    }
}
