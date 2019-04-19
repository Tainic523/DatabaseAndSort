package ThreadPool;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args){
        ThreadPoolExecutor executor=new ThreadPoolExecutor(5,10,200, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));
        ExecutorService executor1= Executors.newCachedThreadPool();
        Future<?> future=executor1.submit(()->{

            try {
                Thread.sleep(50000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Future task is running ");
        });
        for (int i=0;i<15;i++){
            MyTask task=new MyTask(i);
            executor1.execute(task);
            System.out.println("线程池中的线程数量"+ executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        future.cancel(true);
        System.out.println("future task is shutdown");
        executor1.shutdown();
        System.out.println("线程池已关闭");
    }

     static class MyTask implements Runnable{

        private int taskNum;
        public MyTask(int m){
            this.taskNum=m;
        }
        @Override
        public void run(){
            System.out.println("正在执行task"+ taskNum);
            try {
                Thread.sleep(4000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("task"+ taskNum+"执行完毕");
        }

    }
}
