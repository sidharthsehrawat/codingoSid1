package folder.design_patterns.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

enum Singleton1 {
    INSTANCE;

    public String getConfigurarion() {
        return "dsdsds";
    }
}

public class Singleton {

    private static volatile Singleton singleton = null;  //lazy initialization...

    //private static volatile Singleton singleton = new Singleton();  //lazy initialization...
    private Singleton() {/*
     if(singleton!=null){
         throw new RuntimeException("instance is already created , please use getInstance() method instead");
     }
        System.out.println("Creating ... ");*/
    }

    public static Singleton getInstance() {
        //Singleton1 singleton = Singleton1.INSTANCE;

        if (singleton == null) {  // double check condition ...
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
            return singleton;
        }
        return singleton;
    }

  /*  public Object readResolve () throws ObjectStreamException {
        System.out.println("read resolve");
        return singleton;
    }
*/
 /*   @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/
}

class Test {

    static void useSingleton() {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.hashCode());
    }

    public static void main(String[] args) {
        // not affecting eager loading case, need to use synchrnize only for lazy init.
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(Test::useSingleton);
        executorService.submit(Test::useSingleton);

        executorService.shutdown();

     /*   Singleton obj = Singleton.getInstance();
        System.out.println(obj.hashCode());
        Singleton obj1 = Singleton.getInstance();
        System.out.println(obj1.hashCode());*/
    }
}
