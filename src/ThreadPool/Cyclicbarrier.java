package ThreadPool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cyclicbarrier {
    public static void main(String[] args){
        final int total=10;
        CyclicBarrier cyclicBarrier=new CyclicBarrier(total);
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i=0;i<total;i++){
            executorService.execute(()->{
                System.out.print("before..");
                try {
                    cyclicBarrier.await();
                }catch (InterruptedException | BrokenBarrierException e){
                    e.printStackTrace();
                }
                System.out.print("After ..");// 等到所有的线程都调用await方法之后  这个语句才会执行
            });
        }
        executorService.shutdown();
    }
}
