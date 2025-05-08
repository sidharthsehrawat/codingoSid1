package folder.executor;

import java.util.concurrent.*;

public class SqaureUsingCallableExecuter {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> res = executorService.submit((Callable<Integer>) () -> getSquare(2));
        System.out.println("res " + res.get());
    }

    private static Integer getSquare(int i) {
        return i*i;
    }

}
