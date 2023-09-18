package folder.executor.threadsCreation;

public class ThreadByExtendThreadClass {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            MyThread object = new MyThread();
            Thread.sleep(3000);
            object.start();
        }
    }
}

class MyThread extends Thread {
    public void run() {
        try {
            System.out.println(" Thread " + Thread.currentThread().getId() + " is running ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
