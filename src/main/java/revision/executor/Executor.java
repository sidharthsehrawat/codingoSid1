package revision.executor;

import java.util.concurrent.LinkedBlockingQueue;

public class Executor {
    LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    Thread[] workers;
    boolean isRunning = true;

    public Executor(int size) {
        workers = new Thread[size];
        for (int i = 0; i < size; i++) {
            workers[i] = new Thread(() -> {
                while (isRunning) {
                    try {
                        Runnable task = queue.take();
                        task.run();
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            workers[i].start();
        }
    }

    public void submit(Runnable task) {
        if (isRunning) {
            queue.offer(task);
        }
    }

    public void shutdown() throws InterruptedException {
        isRunning = false;
        for (Thread t : workers) {
            t.interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Executor executor = new Executor(3);
        for (int i = 0; i < 5; i++) {
            int task = i;
            executor.submit(new Thread(() ->
                    System.out.println("Task " + task + "Running by Thread " + Thread.currentThread().getName())));
        }

        executor.shutdown();
    }
}
