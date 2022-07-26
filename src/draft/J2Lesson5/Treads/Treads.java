package draft.J2Lesson5.Treads;

import java.util.concurrent.*;

public class Treads {
    public static void main(String[] args) {
        //new CreateNewTreadRunnable();
      // new CreateNewThreadExtends();//не понятно не объяснимо

        Thread t = Thread.currentThread(); //экземпляр класса Thread
        System.out.println("Текущий поток: " + t);

        t.setName("First thread");
        System.out.println("Имя потока изменено: " + t);

        try {
            for (int i = 10; i > 0; i--) {
                System.out.println("Главный поток выводит: " + i);
                // t.sleep(500);
                // или изменить время
                TimeUnit.MILLISECONDS.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }

        //использование анонимного метода

        new Thread(new  Runnable() {
            @Override
            public void run() {
                System.out.println("Привет из анонимного метода");
            }
        }).start();
    }
}

