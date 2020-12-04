package by.jonline.grow.string;

/**
 * С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.
 */

public class StringAsObj4 {
    public static void main(String[] args) {

        String str = "информатика";
        String res;

        res = str.substring(7, 8) + str.substring(3, 5) + str.substring(7, 8);

        System.out.println(res);
    }
}
