public class JavaHome2_3 {
    //задание3
    /* 3. Задать массив [1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1] пройти по нему
     *   циклом, и числа меньшие 6 умножить на 2
     */
    public static void main(String args[]) {
        int[] w = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < w.length; i++) {
            if (w[i]<6) {
                w[i]*=2;

            }
            System.out.print(w[i]+" ");
        }
    }

}
