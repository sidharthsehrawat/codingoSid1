package folder.executor.threadsCreation;

public class ThreadByRunnable {
    public static void main(String[] args) {

        char[] ch = new char[2];
        ch[0]= 'a';
        ch[1] = 'b';

        String s = String.valueOf(ch);
        Thread thread = new Thread(new MyThread1());
        thread.run();
        thread.start();
    }
}

class MyThread1 implements Runnable {

    public void run() {
        try {
            System.out.println("Thread name " + Thread.currentThread().getName() + " and thread id " + Thread.currentThread().getId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
