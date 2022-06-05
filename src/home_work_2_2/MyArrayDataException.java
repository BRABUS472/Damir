package home_work_2_2;

public class MyArrayDataException extends IllegalArgumentException {

    public MyArrayDataException() {
        super("не удалось перевести строку в число");
    }

    public void printMessage() {
        System.err.println(getMessage());
    }
}
