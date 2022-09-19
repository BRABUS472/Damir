package draft.J2Lesson5.PC;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer implements Runnable {
    Q q;

    Producer(Q q){
        this.q=q;
        new Thread(this, "Producer").start();
    }
    @Override
    public void run(){
        int i = 0;

        while (true){
            try {
                q.put(i++);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE,null, ex);
            }
        }
    }
}
