package by.jonline.grow.string;

/**
 *В строке найти количество цифр
 */

public class StringAsArr3 {
    public static void main(String[] args) {
        int count = 0;
        String str = "13jkj7140k5j6214klj2481l24";
        char[] arr;

        arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= '1' && arr[i] <= '9') {
                count++;
            }
        }

        System.out.println(count);

    }
}
