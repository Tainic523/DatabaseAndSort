package ConsumerAndProducer;

public class Singleton {

    private static Singleton singleton;

    public static Singleton getInstance(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton==null)
                    singleton = new Singleton();
            }
        }
        return singleton;
    }
}
