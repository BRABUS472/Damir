package home_work_2_2;

public class MyArrayDataException extends IllegalArgumentException {

    public MyArrayDataException(int i, int j) {
        super("не удалось перевести строку в число, ошибка в строке "+(i+1)+"  и столбец "+(j+1));
    }

    public void printMessage() {
        System.err.println(getMessage());
    }
}
