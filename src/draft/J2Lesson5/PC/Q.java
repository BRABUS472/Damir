package draft.J2Lesson5.PC;

public class Q {
    int n;
    boolean valueSet = false;

    synchronized int get() throws InterruptedException{
        while (!valueSet)
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println("InterruptedException caught");
            }
        Thread.sleep(1000);
        System.out.println("Got: "+n);
        valueSet=false;
        notify();
        return n;
    }

    synchronized void put(int n) throws InterruptedException{  //синхронизация методов
        while (valueSet)
            try{
                wait(); //ожидание пока выполниться метод
            }catch (InterruptedException e){
                System.out.println("InterruptedException caught");
            }

        this.n=n;
        valueSet=true;
                Thread.sleep(1000);
        System.out.println("Put: " +n);
        notify(); //оповещает об окончании работы с монитором
    }
}
