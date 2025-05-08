package your;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "-> " + Thread.currentThread().getPriority());
        int counter = 0;
        return counter;
    }
}

public class TestClass {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Create 3 FutureTasks
        FutureTask<Integer> future1 = new FutureTask<>(new MyTask());
        FutureTask<Integer> future2 = new FutureTask<>(new MyTask());
        FutureTask<Integer> future3 = new FutureTask<>(new MyTask());

        // Assign each to a Thread
        Thread t1 = new Thread(future1, "t1");
        Thread t2 = new Thread(future2, "t2");
        Thread t3 = new Thread(future3, "t3");

        t1.setPriority(1);
        t2.setPriority(2);
        t3.setPriority(3);

        // Start all threads
        t1.start();
        t2.start();
        t3.start();

        // Wait for results
        System.out.println("Result t1: " + future1.get());
        System.out.println("Result t2: " + future2.get());
        System.out.println("Result t3: " + future3.get());


    }
}
