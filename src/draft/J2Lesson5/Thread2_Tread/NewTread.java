package draft.J2Lesson5.Thread2_Tread;

public class NewTread extends Thread {//наследование от класса Tread

    NewTread() {
        //создание второго потока
        super("Demo Tread");//имя потока
        System.out.println("Child tread: " + this);
        start();//старт потока
    }

    //обязательно переобпределить метод run
    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child Tread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child tread interrupted");
        }
        System.out.println("Child tread exiting.");
    }
}
