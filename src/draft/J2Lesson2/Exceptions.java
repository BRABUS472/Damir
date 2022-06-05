package draft.J2Lesson2;

public class Exceptions {
    public Exceptions(String message) {
    }

    public static void main(String[] args) // throws OverStepException отлавливание ошибок со сбоем без try и catch
    {
       Collatz cl = new Collatz();
       try
       {
           cl.get_collatz_sequence(3,2);
       }
       catch (OverStepException e)
       {
           System.out.println(e.getMessage());
           e.printmessage();//ради знаний
       }
    }

}
