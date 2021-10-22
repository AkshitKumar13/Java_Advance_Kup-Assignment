package Advance.Question3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//   Use a singleThreadExecutor to submit multiple threads.
//   Try shutdown() and shutdownNow() and observe the difference.
//    Use isShutDown() and isTerminated() with ExecutorService.


  class UsingThreadExecutor implements Runnable{
    private String name;

    public  UsingThreadExecutor(String name) {

        this.name = name;
    }

    public void run() { // Start of step 4
        System.out.println("Start executing " + name);
        try {
            Thread.sleep(1000);
            System.out.println("Executing " + name);
        } catch (InterruptedException e) {
            // skipping the catch as of now
            e.printStackTrace();
        }
        System.out.println("Finished execution " + name);
        System.out.println();
    } /// End of step 4
}

class SecondThread{
      String name;
      public void run(){
          System.out.println("Start Second executing " + name);
          try {
              Thread.sleep(1000);
              System.out.println("Second Executing " + name);
          } catch (InterruptedException e) {
              // skipping the catch as of now
              e.printStackTrace();
          }
          System.out.println("Finished Second execution " + name);
          System.out.println();
      }
}
 class SingleThreadPool {
    public static void main(String[] args) {
        // Step No 1
        ExecutorService executor = Executors.newSingleThreadExecutor();//using executor service
      //  for (int number = 0; number < 4; number++) {
            // Step No 2
            Runnable worker = new UsingThreadExecutor("MyTask " );
        Runnable worker2 = new UsingThreadExecutor("Second Task "  );

            // Step No 3
            executor.execute(worker);

      //  }
        executor.execute(worker2);
        executor.shutdown();
System.out.println(executor.isTerminated());
executor.shutdownNow();
        // Waiting for all thread to finish
       while (!executor.isTerminated()) ;
        System.out.println("All threads finished"+" "+executor.isTerminated());
    }
}