package home_work_2_2;
/*1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
        подаче массива другого размера необходимо бросить исключение MyArraySizeException.
        2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
        просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
        ячейке лежит символ или текст вместо числа), должно быть брошено исключение
        MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
        3 В методе main() вызвать полученный метод, обработать возможные исключения
        MyArraySizeException и MyArrayDataException и вывести результат расчета (сумму элементов,
       при условии что подали на вход корректный массив).
*/

public class HomeWork2_2 {
    int summa = 0;

    public static void main(String args[]) throws MyArrayDataException, MyArraySizeException {

        String[][] table = {{"2", "6", "4", "0"}, {"2", "20", "4", "4"}, {"20", "4", "6", "7"}, {"2", "5", "2", "8"}};
        HomeWork2_2 a = new HomeWork2_2();


        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

        try {
            a.check(table);

        } catch (MyArraySizeException exception) {
            exception.printMessage();
        }
        try {
            a.integer(table);
        } catch (MyArrayDataException e) {
            e.printMessage();
        }

        System.out.println("Продолжение банкета");
        a.summ(a.integer(table));
        System.out.println(a.summa);
    }

    public String[][] check(String[][] table) throws MyArraySizeException {
        for (int i = 0; i < table.length; i++) {
            if ((table.length != 4) | (table[i].length != 4)) {
                throw new MyArraySizeException();
            }
        }
        return table;
    }

    public int[][] integer(String[][] table) {
        int[][] arr = new int[table.length][table.length];
        System.out.println();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                try {
                    arr[i][j] = Integer.parseInt(table[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException();
                }
            }
        }
        return arr;
    }

    public int summ(int[][] table) {

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                summa += table[i][j];
            }
        }
        return summa;
    }
}



