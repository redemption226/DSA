package DSA.Multithreading;

import java.util.concurrent.locks.Lock;

public class PrintEvenOdd {

    public static class PrintEvenOddThread {
        int maxCounter;
        int counter;

        PrintEvenOddThread(int maxCounter) {
            this.maxCounter = maxCounter;
            this.counter = 1;
        }

        public synchronized void printOdd() {
            while (counter <= maxCounter) {
                // While it's not the odd thread's turn, wait
                while (counter % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                if (counter <= maxCounter) {
                    System.out.println(Thread.currentThread().getName() + " " + counter);
                    counter++;
                    notifyAll(); // Wake up even thread
                }
            }
        }

        public synchronized void printEven() {
            while (counter <= maxCounter) {
                // While it's not the even thread's turn, wait
                while (counter % 2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                if (counter <= maxCounter) {
                    System.out.println(Thread.currentThread().getName() + " " + counter);
                    counter++;
                    notifyAll(); // Wake up odd thread
                }
            }
        }

    }

    public static void main(String[] args) {
        PrintEvenOddThread printEvenOddThread = new PrintEvenOddThread(10);

        Thread oddThread = new Thread( () -> {

                printEvenOddThread.printOdd();

        }, "Odd");
        Thread evenThread = new Thread( () -> {
                printEvenOddThread.printEven();

        }, "Even");

        oddThread.start();
        evenThread.start();
    }

//    public static void printEvenOdd(int n) {
//
//
//        Thread t1 = new Thread( () -> {
//            for (int i = 0; i< n; i++) {
//                if (i%2 == 0)
//                    System.out.println(Thread.currentThread().getName() + " " +   i);
//            }
//        }, "Even");
//
//        Thread t2 = new Thread( () -> {
//            for (int i = 0; i< n; i++) {
//                if (i%2 != 0)
//                    System.out.println( Thread.currentThread().getName() + " " +  i);
//            }
//        }, "Odd");
//
//
//        t1.start();
//        t2.start();
//    }

}
