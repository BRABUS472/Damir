package home_work_2_2;

public class MyArraySizeException extends Exception {

    public MyArraySizeException() {
        super("ошибка неправильный массив");
    }

    public void printMessage() {
        System.err.println(getMessage());
    }
}

