
public class JavaHome2_6 {
    //задание 6
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1, 2, 1}, {2, 1, 1, 2, 1}, {10, 10}};
        for (int i = 0; i < arr.length; i++)
            System.out.println(checkBalance(arr[i]));

    }






    static boolean checkBalance(int[] arr) {
        if (arr == null || arr.length < 0) {
            return false;
        }
        int summaArr = 0;//сумма массива
        int summma1 = 0;//первая часть массива
        for (int i = 0; i < arr.length; i++) {
            summaArr += arr[i];
        }
        if (summaArr % 2 != 0) {
            return false;

        }
        for (int i = 0; i < arr.length - 1; i++) {
            summma1 += arr[i];
            if (summma1*2 == summaArr)
                return true;
        }
        return false;
    }
    }

