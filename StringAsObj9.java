package by.jonline.grow.string;

/**
 * Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только английские
 * буквы.
 */

public class StringAsObj9 {
    public static void main(String[] args) {
        int lowercase = 0;
        int uppercase = 0;
        String str = "Denis dEniS dEN dnis";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 97 && str.charAt(i) <= 122) {
                lowercase++;
            } else if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
                uppercase++;
            }
        }

        System.out.println("uppercase = " + uppercase + "; lowercase = " + lowercase);

    }
}
