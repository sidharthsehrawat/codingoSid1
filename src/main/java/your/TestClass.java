package your;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyTask implements Callable {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "-> " + Thread.currentThread().getPriority());
        int counter = 0;
        return counter;
    }
}

public class TestClass {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // t1 - 1
        // t2 - 2
        // t3 - 3

        // 1 2 3

        // JOIN() predesecor

        MyTask task = new MyTask();
        Thread t1 = new Thread();
        t1.setPriority(1);

        Thread t2 = new Thread();
        t2.setPriority(2);

        Thread t3 = new Thread();
        t2.setPriority(3);

        FutureTask<Integer> futureTask = new FutureTask<>(task);
        t1.start();
        t2.start();
        t3.start();

        Integer res = futureTask.get();
        System.out.println(res + " ");

    }
}
