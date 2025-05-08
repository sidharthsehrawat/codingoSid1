package revision.thread;

public class CreateThreadByExtendThread {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        Thread.sleep(3000);
        myThread.start();
    }
}

class MyThread extends Thread {
    public void run(){
        System.out.println("Running thread");
    }
}
