public class JavaHome2_1 {
    //задание 1
    /*Задать целочисленный массив,
    состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    public static void  main(String args[]){
        int[] a = {1, 0, 0, 1, 1, 1, 0, 1, 0, 0};
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0)
                a[i]++;
            else
                a[i]--;
            System.out.print(a[i] + " ");
        }
    }
}

