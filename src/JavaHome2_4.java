public class JavaHome2_4 {
    public static void main(String args[]) {
    //задание 4
        /* 4. Создать квадратный двумерный целочисленный массив (количество
         *    строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить
         *    его диагональные элементы единицами
         */
        int n=4;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    arr[i][i] = 1;
                    arr[j][n-i-1]=1;
                    arr[n-j-1][i]=1;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

}

