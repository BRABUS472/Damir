package draft.J2Lesson5.locker;

import java.util.concurrent.locks.ReentrantLock;

public class Locker {

    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource();
        ReentrantLock locker = new ReentrantLock();//создаем заглушку
        for (int i = 1; i < 6; i++) {
            Thread t = new Thread(new CountThread(commonResource, locker));
            t.setName("Thread" + i);
            t.start();
        }
    }
}
    class CommonResource{  //общий ресурс

        int x = 0;

    }

    class CountThread implements Runnable{

        CommonResource res; //ресурс
        ReentrantLock locker; //защелка
        CountThread(CommonResource res, ReentrantLock lock){
            this.res=res;
            locker=lock;
        }
        @Override
        public void run(){ //устанавливаем блокировку на время работы

            locker.lock();//устанавливаем блокировку (поток пытается заблокировать ресурс(все ждут)), пока не произойдет unlock
            try {
                res.x=1;
                for (int i=1; i<5;i++){
                    System.out.printf("%s %d \n", Thread.currentThread().getName(),res.x);
                    res.x++;
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());;
            }
            finally {
                locker.unlock();//снимаем блокировку ОБЯЗАТЕЛЬНО!
            }
        }
    }

