package ThreadPool;

public class Threadimplrment {

        public static void main(String[] args) throws InterruptedException {
            ThreadExcutor excutor = new ThreadExcutor(3);
            for (int i = 0; i < 10; i++) {
                excutor.exec(()->{System.out.println("线程 " + Thread.currentThread().getName() + " 在帮我干活");}
                );
            }
            excutor.shutdown();
        }
    }

