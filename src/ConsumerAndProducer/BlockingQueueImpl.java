package ConsumerAndProducer;

import java.util.LinkedList;

public class BlockingQueueImpl<E> {
    private volatile LinkedList<E> queue = new LinkedList<>();
    private int limit = 10;

    public BlockingQueueImpl(int limit){
        this.limit = limit;
    }

    public synchronized void put(E item)
            throws InterruptedException {
            while (this.queue.size()== this.limit){
                wait();
            }
            if (this.queue.size()==0){
                notifyAll();
            }
            this.queue.add(item);

    }
    public synchronized E take()
            throws InterruptedException {
            while (this.queue.size()== 0){
                wait();
            }
            if (this.queue.size()==this.limit){
                notifyAll();
            }
            return this.queue.remove();
    }
}
