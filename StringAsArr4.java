package by.jonline.grow.string;

/**
 * В строке найти количество чисел
 */

public class StringAsArr4 {
    public static void main(String[] args) {

        int count = 0;
        String str = "sdg13jkj7140k5j6214klj2481l24 3j8";
        char[] arr;

        arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= '1' && arr[i] <= '9') {
                while (i != arr.length && arr[i] >= '1' && arr[i] <= '9') {
                    i++;
                }
                count++;
            }
        }

        System.out.println(count);

    }
}
