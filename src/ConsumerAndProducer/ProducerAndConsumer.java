package ConsumerAndProducer;

public class ProducerAndConsumer {

    private static BlockingQueueImpl<String> queue = new BlockingQueueImpl<String>(5);
    private static class Producer implements Runnable{

        @Override
        public void run() {
            try {
                String item = "item";
                queue.put(item);
                System.out.println("Producer");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private static class Consumer implements Runnable{
        @Override
        public void run() {
            try {
                String item = queue.take();
                System.out.println("Consumer  "+ item);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {


        for (int i=1;i<=3;i++){
            Producer producer = new Producer();
            Thread thread = new Thread(producer);
            thread.start();
        }
        for (int j=1;j<=5;j++){
            Consumer consumer = new Consumer();
            Thread thread = new Thread(consumer);
            thread.start();
        }
        for (int i = 1;i<=2;i++){
            Producer producer = new Producer();
            Thread thread = new Thread(producer);
            thread.start();
        }
    }
}
