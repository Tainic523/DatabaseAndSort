package ConsumerAndProducer;

public class DeadLockTest {
    public static void main(String[] args) {
    Object a=new Object();
    Object b=new Object();
    Thread thread1=new Thread(()->{
        synchronized (a){
            try {
                System.out.println(" i am in thread1 lock a");
                Thread.sleep(1000);
                synchronized (b){
                    System.out.print("i am in thread1 lock b");
                }
        }catch (InterruptedException e){
                e.printStackTrace();
            }

        }

    });
        Thread thread2=new Thread(()->{
            synchronized (b){
                try {
                    System.out.println(" i am in thread2 lock b");
                    Thread.sleep(1000);
                    synchronized (a){
                        System.out.print("i am in thread2 lock a");
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }

        });
        thread1.start();
        thread2.start();

    }
}
