package ThreadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadTest {
    static class fristThreadTest extends Thread{
        int num;
        public  fristThreadTest(int num){
            this.num=num;
        }
        @Override
        public void run(){
            System.out.println(num);
        }
    }
    static class secondThread implements Runnable{
        int num;
        public  secondThread(int num){
            this.num=num;
        }
        @Override
        public void run(){
            System.out.println(num);
        }

    }
    static class thirdThread implements Callable<Integer>{
        @Override
        public Integer call() throws Exception{
            int i=0;
            for(;i<100;i++)
            {
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
            return i;
        }
    }
    public static void main(String [] args)throws Exception{
        fristThreadTest fristThreadTest=new fristThreadTest(1);
        fristThreadTest.start();
        System.out.println("frist  STrat");

        secondThread secondThread=new secondThread(2);
        Thread thread=new Thread(secondThread);
        thread.start();
        System.out.println(" second STrat");

//        thirdThread thirdThread=new thirdThread();
//        FutureTask<Integer> futureTask=new FutureTask<>(thirdThread);
//        futureTask.run();
//        futureTask.get();
    }
}
