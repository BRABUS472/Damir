public class JavaHome2_7 {
    //задание 7
// метод написал, но как вывести измененный массив в консоль хз

    public static void main(String args[]) {

        int[] arr = {1, 2, 3, 4, 5,6,7,8};
        int n = -1;// ввели переменную n
        if (arr == null || arr.length < 2
                || n == 0 || n % arr.length == 0)
            System.out.println("не верные данные");
        System.out.println("не верные данные");
        if (n > 0) {
            int i;
            for (int j = 0; j < n; j++) {
                int p = arr[arr.length - 1];//временная переменная
                for (i = 0; i < arr.length - 1; i++) {
                    arr[arr.length - 1 - i] = arr[arr.length - 2 - i];
                }
                arr[0] = p;
            }
        }
        if (n < 0)
            n += arr.length;
        int i;
        for (int c = 0; c < n; c++) {
            int p = arr[arr.length - 1];
            for (i = arr.length - 1; i > 0; i--)
                arr[i] = arr[i - 1];
            arr[0] =p;
        }

    }
}


