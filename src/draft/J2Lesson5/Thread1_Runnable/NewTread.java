package draft.J2Lesson5.Thread1_Runnable;

public class NewTread implements Runnable { //Runnable-реализация нового потока
    Thread t;

    NewTread() {
        //second tread
        t = new Thread(this, "Demo Tread");//this-образован поток от данного экземпляра NewTread
        System.out.println("Child tread: " + t);
        t.start();//start-запускает поток
    }

    @Override
    public void run() { // описание метода, чем будет заниматься поток
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
