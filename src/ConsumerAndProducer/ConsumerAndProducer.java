package ConsumerAndProducer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConsumerAndProducer {
    private static BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);
//    private static BlockingQueueExample queue = new BlockingQueueExample(5);

    private static class Producer extends Thread {
        @Override
        public void run() {
            try {
                queue.put("product  ");

            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.print("Producer  ");
        }
    }

    private static class Consumer extends Thread {

        @Override
        public void run() {
            try {
                String product=(String) queue.take();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.print("Consumer  ");
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Producer producer = new Producer();
            producer.start();
        }
        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }
        for (int i = 0; i < 3; i++) {
            Producer producer = new Producer();
            producer.start();
        }
    }
}
