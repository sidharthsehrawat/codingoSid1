package folder.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PerformTasksUsingExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            DoTask("Task1");
        });
        executorService.submit(() -> {
            DoTask("Task2");
        });

        executorService.submit(() -> {
            DoTask("Task3");
        });

        executorService.shutdown();
    }

    public static void DoTask(String taskName) {
        System.out.println("Task started by this " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task completed by this " + Thread.currentThread().getName());
    }
}
