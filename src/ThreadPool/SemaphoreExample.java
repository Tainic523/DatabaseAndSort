package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args){
        final int number=3;
        final int clients=10;
        Semaphore semaphore=new Semaphore(number);
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i=0;i<clients;i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    System.out.print(semaphore.availablePermits());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    semaphore.release();
                }
            });
        }
        executorService.shutdown();
    }
}
