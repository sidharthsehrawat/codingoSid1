package folder.design_patterns.taskScheduler;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

// =================== Task ===================
class Task implements Runnable {
    private static final AtomicLong idGenerator = new AtomicLong(0);

    private final long id;
    private final Runnable command;
    private long scheduledTime; // in ms
    private final long interval; // for recurring tasks, 0 if one-time

    public Task(Runnable command, long scheduledTime, long interval) {
        this.id = idGenerator.incrementAndGet();
        this.command = command;
        this.scheduledTime = scheduledTime;
        this.interval = interval;
    }

    @Override
    public void run() {
        command.run();
    }

    public long getScheduledTime() {
        return scheduledTime;
    }

    public long getInterval() {
        return interval;
    }

    public void updateNextExecution() {
        if (interval > 0) {
            this.scheduledTime = System.currentTimeMillis() + interval;
        }
    }

    public long getId() {
        return id;
    }
}

// =================== TaskScheduler ===================
class TaskScheduler {
    private final PriorityQueue<Task> taskQueue;
    private final ExecutorService workers;
    private final Thread dispatcher;

    public TaskScheduler(int workerThreads) {
        this.taskQueue = new PriorityQueue<>(Comparator.comparingLong(Task::getScheduledTime));
        this.workers = Executors.newFixedThreadPool(workerThreads);

        // Dispatcher thread
        this.dispatcher = new Thread(() -> {
            while (true) {
                try {
                    Task nextTask;
                    synchronized (taskQueue) {
                        while (taskQueue.isEmpty()) {
                            taskQueue.wait();
                        }
                        nextTask = taskQueue.peek();
                        long waitTime = nextTask.getScheduledTime() - System.currentTimeMillis();
                        if (waitTime > 0) {
                            taskQueue.wait(waitTime);
                            continue;
                        }
                        taskQueue.poll(); // remove task
                    }

                    workers.submit(() -> {
                        try {
                            nextTask.run();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });

                    if (nextTask.getInterval() > 0) {
                        nextTask.updateNextExecution();
                        schedule(nextTask);
                    }
                } catch (InterruptedException e) {
                    break; // exit if interrupted
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Schedule new tasks
    public void schedule(Runnable command, long delay, long interval) {
        long scheduledTime = System.currentTimeMillis() + delay;
        Task task = new Task(command, scheduledTime, interval);
        schedule(task);
    }

    // Internal scheduling
    private void schedule(Task task) {
        synchronized (taskQueue) {
            taskQueue.add(task);
            taskQueue.notify(); // wake dispatcher
        }
    }

    // Start scheduler
    public void start() {
        dispatcher.start();
    }

    // Stop scheduler (graceful shutdown)
    public void stop() {
        workers.shutdownNow();
        dispatcher.interrupt();
    }
}

// =================== Main (Demo) ===================
public class Main {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler(3);
        scheduler.start();

        // Task 1: runs once after 2 seconds
        scheduler.schedule(() -> System.out.println("Task 1 executed at " + System.currentTimeMillis()),
                2000, 0);

        // Task 2: runs every 3 seconds (after initial 1 second delay)
        scheduler.schedule(() -> System.out.println("Task 2 executed at " + System.currentTimeMillis()),
                1000, 3000);

        // Task 3: runs every 5 seconds
        scheduler.schedule(() -> System.out.println("Task 3 executed at " + System.currentTimeMillis()),
                0, 5000);
    }
}
