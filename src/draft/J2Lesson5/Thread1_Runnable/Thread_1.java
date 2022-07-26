package draft.J2Lesson5.Thread1_Runnable;

public class Thread_1 {
    public static void main(String[] args) {

        new NewTread();//создание нового потока

        try{
            for(int i =5;i>0;i--){
                System.out.println("Main Tread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main tread interrupted");
        }
        System.out.println("Main tread exiting");
    }
}
