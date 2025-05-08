package revision.thread;

public class CreateThreadByImplementRunnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());

        thread.start();
        thread.run();

    }
}

class Mythread implements Runnable{

    @Override
    public void run() {
        System.out.println("running method");
    }
}
