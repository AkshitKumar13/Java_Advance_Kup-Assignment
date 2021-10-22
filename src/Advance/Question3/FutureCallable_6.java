package Advance.Question3;

import java.util.concurrent.*;
//Return a Future from ExecutorService by using callable and
// use get(), isDone(), isCancelled() with the Future object to know the status of the task submitted.





import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

 class FutureCallable implements Callable {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        //return the thread name executing this callable task
        return Thread.currentThread().getName();
    }

    public static void main(String args[]){
//        Using newFixedThreadPool() method
        //Get ExecutorService from Executors utility class, thread pool size is 4
        ExecutorService executor = Executors.newFixedThreadPool(4);
        //create a list to hold the Future object associated with Callable
        List<Future<String>> list = new ArrayList<Future<String>>();
        Callable<String> callable = new FutureCallable();

        ScheduledExecutorService executor2 = Executors.newScheduledThreadPool(1);
        LocalDateTime now = LocalDateTime.now();


      System.out.println("WorkerTasks scheduled at : "+ LocalDateTime.now());
        ScheduledFuture<String> result1 = executor2.schedule(new WorkerTask("WorkerTask-1"),
                Duration.between(now, now.plusSeconds(2)).toMillis(),
                TimeUnit.MILLISECONDS);
        ScheduledFuture<String> result2 = executor2.schedule(new WorkerTask("WorkerTask-2"),
                Duration.between(now, now.plusSeconds(2)).toMillis(),
                TimeUnit.MILLISECONDS);


        for(int i=0; i< 20; i++){
            //submit Callable tasks to be executed by thread pool
            Future<String> future = executor2.submit(callable);
            //add Future to the list, we can get return value using Future
            list.add(future);
        }

        for(Future<String> fut : list){
            try {
                //print the return value of Future, notice the output delay in console
                // because Future.get() waits for task to get completed
                System.out.println(new Date()+ "::"+fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        //shut down the executor service now
        executor.shutdown();

        System.out.println("Task-1 is done : " + result1.isDone());
        System.out.println("Task-1 is done : " + result2.isDone());
        System.out.println("**** Waiting for tasks to be complete ****");

        try {
            executor2.awaitTermination(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Cancel the taks-2
        result2.cancel(true);
        System.out.println("****All tasks are completed now ****");
        System.out.println("Task-1 is done : " + result1.isDone());
        System.out.println("Task-2 is done : " + result2.isDone());
        System.out.println("Task-2 is cancel : " + result2.isCancelled());


        // Waiting for all thread to finish
//        while (!executor.isTerminated());
       System.out.print("Terminated Successfully");
    }
}
class WorkerTask implements Callable<String>
{
    private final String name;
    public WorkerTask(String name) {
        this.name = name;
    }
    @Override
    public String call() throws Exception {
        System.out.println("WorkerTask [" + name + "] executed on : " + LocalDateTime.now().toString());
        return "WorkerTask [" + name + "] is SUCCESS !!";
    }
}