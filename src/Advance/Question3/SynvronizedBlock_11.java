package Advance.Question3;

import java.util.function.Consumer;
public class SynvronizedBlock_11 {

//Use the Synchronize block to enable synchronization between
// multiple threads trying to access the method at same time.
    public static void main(String[] args) {

        Consumer<String> func = (String param) -> {

            synchronized (SynvronizedBlock_11.class) {

                System.out.println(
                        Thread.currentThread().getName() +
                                " step 1: " + param);

                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(
                        Thread.currentThread().getName() +
                                " step 2: " + param);
            }

        };


        Thread thread1 = new Thread(() -> {
            func.accept("Parameter");
        }, "Thread 1");

        Thread thread2 = new Thread(() -> {
            func.accept("Parameter");
        }, "Thread 2");

        thread1.start();
        thread2.start();
    }


    }