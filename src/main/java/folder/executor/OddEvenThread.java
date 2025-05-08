package folder.executor;

class Printer {
    boolean odd = true;
    public synchronized void printOdd(int number) throws InterruptedException {
        if (!odd) {
            wait();
        }
        System.out.println("odd print :" + number);
        odd = false;
        notify();
    }

    public synchronized void printEven(int number) throws InterruptedException {
        if(odd){
            wait();
        }
        System.out.println("even print :" + number);
        odd = true;
        notify();
    }
}

public class OddEvenThread {
    public static void main(String[] args) {
        int number = 10;
        Printer printer = new Printer();

        Thread evenThread = new Thread(() -> {
            for (int i = 0; i <= number; i += 2) {
                try {
                    printer.printEven(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= number; i += 2) {
                try {
                    printer.printOdd(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
