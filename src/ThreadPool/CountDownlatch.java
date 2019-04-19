package ThreadPool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownlatch {
    public static void main(String[] args)throws Exception{
        final int total=10;
        CountDownLatch countDownLatch=new CountDownLatch(total);
        ExecutorService  executorService= Executors.newCachedThreadPool();
        for (int i=0;i<total;i++){
            executorService.execute(()->{
                System.out.println("run..");
                countDownLatch.countDown();
                System.out.println("do my business");
            });
        }
        countDownLatch.await();
        System.out.println("end");
        executorService.shutdown();
    }
}
