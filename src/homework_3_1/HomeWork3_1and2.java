/*
1.Написать метод, который меняет два элемента массива местами (массив может быть любого
ссылочного типа);
2. Написать метод, который преобразует массив в ArrayList;

*/


package homework_3_1;

import java.util.Arrays;
import java.util.List;

public class HomeWork3_1and2 {

    public static void main(String[] args) {
        Integer[] iarray = {1, 2, 3, 4, 5};
        replacement(iarray, 2, 3);
        List<Integer> list=convertToList(iarray);
        System.out.println(list);
        String[] sarray = {"a", "b", "c"};
        replacement(sarray, 1, 2);
        List<String> list1=convertToList(sarray);
        System.out.println(list1);


    }

    public static <T> void replacement(T[] array, int index1, int index2) {
        System.out.println(Arrays.toString(array));
        T N = array[index1];
        array[index1] = array[index2];
        array[index2] = N;
        System.out.println(Arrays.toString(array));
    }

    public static <T> List<T> convertToList(T[] arr){
        return Arrays.asList(arr);
    }
}
