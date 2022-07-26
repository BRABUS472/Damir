package draft.J2Lesson5.callabledemo;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();//позволяет получит pool потоков
        ArrayList<Future<String>> results = new ArrayList<>();

        for(int i = 0; i<10;i++)
            results.add(exec.submit(new TaskWithResult(i)));//метод submit - созжает объект класса future,
        // который параметризирован по конкретному типу(в данном случае String) результата который возвращает callable

        for (Future<String> fs: results)
            try{
                System.out.println(fs.get());
            }catch (InterruptedException e){
        System.out.println(e);
        return;
    }catch (ExecutionException e){
                System.out.println(e);
            }finally {
                exec.shutdown();
            }
        return;
    }
}