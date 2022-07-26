package draft.J2Lesson5.join;

public class Join {
    public static void main(String[] args) {

        System.out.println("Main thread started...");

        for (int i = 0; i < 10; i++) {
            System.out.println("Count in main Thread: " + i);

            try {
                Thread.sleep(1000);//main tread sleep
                if (i == 3) {
                    JThread t = new JThread("JTread");
                    t.start();
                    try {
                        t.join();//запускает второй поток. Пока он не выполниться основной поток не продолжает
                    } catch (InterruptedException e) {

                        System.out.printf("%s has been interrupted", t.getName());

                    }
                    System.out.println("Main thread finished...");
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}