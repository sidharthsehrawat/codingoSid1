package revision.executor;


import java.util.concurrent.*;

class MyTask implements Callable<Object> {
    String message;

    public MyTask(String message){
        this.message= message;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("Message is : " + message);
        return null;
    }
}
public class ExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask("Hello");
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(cores);
        Future<Object> future = executorService.submit(myTask);
        System.out.println(future.get());
    }
}
