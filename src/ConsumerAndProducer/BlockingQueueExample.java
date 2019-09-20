package ConsumerAndProducer;

import java.util.LinkedList;

public class BlockingQueueExample {

    private LinkedList<Object> queue = new LinkedList<>();
    private int limit = 10;

    public BlockingQueueExample(int limit) {
        this.limit = limit;
    }


    public synchronized void put(Object item)
            throws InterruptedException {
        while (this.queue.size() == this.limit) {
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(item);
    }


    public synchronized Object take()
            throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }

        return this.queue.remove();
    }

}


