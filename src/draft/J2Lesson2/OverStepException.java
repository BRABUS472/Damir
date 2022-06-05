package draft.J2Lesson2;

public class OverStepException extends Exception implements MessageInterface {
    //если необходимо, создем поля
    private int number_1;
    private int number_2;

    public OverStepException(String message) {
       super(message);
    }

    //вариант конструктора с перегруженным методоми
    public OverStepException(String message, int number_1, int number_2) {
        super(message);
        this.number_1 = number_1;
        this.number_2 = number_2;

    }

    @Override
    public String getMessage() {
        return "переопределенный метод getMessage";
    }

    @Override
    public void printmessage(){
        System.out.println("Ошибка");
    }
}
