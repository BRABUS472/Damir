public class JavaHome2_5 {
    //задание 5
    /* 5. ** Задать одномерный массив и найти в нём минимальный
     *    и максимальный элементы
     */
    public static void main(String args[]) {
        int[] w = { 1, 5, 3, 2, 55, 4, 5, 2, 4, 8, 9, 1 };
        int xmax=w[0];
        int xmin=w[0];
        for (int i = 0; i < w.length; i++) {
            if (xmax<w[i]) {
                xmax=w[i];
            }
            if(xmin>w[i]) {
                xmin = w[i];
            }

        }
        System.out.print("максимальное число = "+xmax+" минимальное число равно = "+xmin);
    }
}

