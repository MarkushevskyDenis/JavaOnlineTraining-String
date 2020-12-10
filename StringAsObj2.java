package by.jonline.grow.string;

/**
 * В строке вставить после каждого символа 'a' символ 'b'.
 */

public class StringAsObj2 {
    public static void main(String[] args) {
        String s = "a b a c d a";
        StringBuilder str = new StringBuilder(s);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                str.insert(i + 1, "b");
            }
        }

        System.out.println(str);

    }
}
