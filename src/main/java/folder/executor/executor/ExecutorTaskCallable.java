package folder.executor.executor;

import java.util.Random;
import java.util.concurrent.*;

class Task implements Callable {
    String message;

    Task(String message) {
        this.message = message;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("Hello  " + message);
        return message;
    }
}

public class ExecutorTaskCallable {
    public static void main(String[] args) {
        Task task = new Task("Sidharth!!");
       int core =  Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(core);
        Future result = executorService.submit(task);
        try {
            System.out.println("Result : " + result.get());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }
}
