package ConsumerAndProducer;

import java.util.concurrent.*;

public class cyclicbarrierTest {
    public static void main(String[] args) throws Exception {

        // cyclicbarrier  TEST
        final int totalThread = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            executorService.execute(() -> {
                System.out.print("before..");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.print("after..");
            });
        }
        executorService.shutdown();

        //////  countdownlatch  test
        CountDownLatch countDownLatch = new CountDownLatch(10);

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 15; i++) {
            executor.execute(() -> {
                System.out.println("before ");
                try {
                    countDownLatch.countDown();
                    System.out.println("after ");
                } catch (Exception e){
                    e.printStackTrace();
                }

            });
        }
        countDownLatch.await();
        System.out.println("end ");
        executor.shutdown();
    }
}
