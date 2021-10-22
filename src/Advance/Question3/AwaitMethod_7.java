package Advance.Question3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;


//Submit List of tasks to ExecutorService and wait for the completion of all the tasks.
class ActionService implements Runnable {

    private CountDownLatch latch;

    public ActionService(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {

        System.out.println("Start Action Service");

        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            System.out.println(ex);
        }

        this.latch.countDown();
    }
}

  class AwaitMethod {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        IntStream.range(0, 3).forEach(item -> executor.execute(new ActionService(latch)));
        executor.shutdown();
//        boolean awaitTermination(long timeout, TimeUnit unit);
        ExecutorService executor2 = Executors.newSingleThreadExecutor();
        IntStream.range(0, 3).forEach(item -> executor2.execute(() -> System.out.println("Thread " + item + "th")));

        executor.shutdown();

        try {
            if (!executor.awaitTermination(50, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        try {
            latch.await();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

        System.out.println("End of Action Services");
    }
}