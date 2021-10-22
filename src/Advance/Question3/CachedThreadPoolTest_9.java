package Advance.Question3;

import java.util.concurrent.*;

  class CachedThreadPoolTest {
    public static void main(String[] args) {

//        Using newCachedThreadPool() method
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ExecutorService executorService = Executors.newCachedThreadPool(threadFactory);

        // Cast the object to its class type
        ThreadPoolExecutor pool = (ThreadPoolExecutor) executorService;

        //Stats before tasks execution
       System.out.println("Largest executions: " + pool.getLargestPoolSize());
        System.out.println("Maximum allowed threads: " + pool.getMaximumPoolSize());
        System.out.println("Current threads in pool: " + pool.getPoolSize());
        System.out.println("Currently executing threads: " + pool.getActiveCount());
       System.out.println("Total number of threads(ever scheduled): " + pool.getTaskCount());

        executorService.submit(new Task());
        executorService.submit(new Task());

        //Stats after tasks execution
        System.out.println("Core threads: " + pool.getCorePoolSize());
        System.out.println("Largest executions: " + pool.getLargestPoolSize());
      System.out.println("Maximum allowed threads: " + pool.getMaximumPoolSize());
       System.out.println("Current threads in pool: " + pool.getPoolSize());
        System.out.println("Currently executing threads: " + pool.getActiveCount());
        System.out.println("Total number of threads(ever scheduled): " + pool.getTaskCount());
        executorService.shutdown();
    }
}

class Task implements Runnable {
    public void run() {
        try {
            Long duration = (long) (Math.random() * 5);
           System.out.println("Running Task! Thread Name: " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(duration);
             System.out.println("Task Completed! Thread Name: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}