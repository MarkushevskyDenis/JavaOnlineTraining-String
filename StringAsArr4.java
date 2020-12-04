package by.jonline.grow.string;

/**
 * В строке найти количество чисел
 */

public class StringAsArr4 {
    public static void main(String[] args) {

        int count = 0;
        String str = "13jkj7140k5j6214klj2481l243j8";
        char[] arr;

        str += '\0';
        arr = str.toCharArray();


        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= '1' && arr[i] <= '9') {
                if (arr[i + 1] >= '1' && arr[i + 1] <= '9') {
                    continue;
                }
                count++;
            }
        }

        System.out.println(count);

    }
}
