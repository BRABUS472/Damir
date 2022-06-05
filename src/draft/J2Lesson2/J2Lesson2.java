package draft.J2Lesson2;

public class J2Lesson2 {
    private final static int i=0 ;
    private final static int j=0;

    public static int division(){
        return j/i;
    }

    public static void main(String[] args) {
        try {//попытаться выполнить метод
            division();
        }
        catch (ArithmeticException e){
            System.out.println("An Exception occurred "+ e.getMessage());// метод getMessage() дает информацию о исключении
        }
        finally {
            System.out.println("End");
        }

    }
}
