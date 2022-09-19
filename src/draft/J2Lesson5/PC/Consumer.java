package draft.J2Lesson5.PC;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable {
    Q q;
    Consumer(Q q){
        this.q=q;
        new Thread(this, "Consumer").start();
    }

    @Override
public void run(){
        while (true) {
            try {
                q.get();
            }catch (InterruptedException ex){
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE,null, ex);
            }
        }
    }
}
