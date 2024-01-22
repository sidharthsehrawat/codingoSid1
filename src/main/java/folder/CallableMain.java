package folder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableMain {
    private static int sum = 10;
    private static int ans = 0;

    static class Task implements Callable {
        @Override
        public Integer call() throws Exception {
            for (int i = 0; i < sum; i++) {
                ans = ans + i;
            }
            return ans;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        Thread thread = new Thread(futureTask);
        thread.start();
        Integer ans1 = futureTask.get();
        System.out.println(ans1);
    }

}
