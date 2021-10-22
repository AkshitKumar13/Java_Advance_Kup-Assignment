package Advance.Question3;

import java.util.Date;
import java.util.concurrent.*;

  class ScheduleAtFixedRate {

    public static void main(String[] args) {
//        //        Using newFixedThreadPool() method
//        //Get ExecutorService from Executors utility class, thread pool size is 4
//        ExecutorService executor = Executors.newFixedThreadPool(4);


        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

//         By using scheduleAtFixedRate() method

        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Start making coffee At:" + new Date());
            }
        }, 1, 3L , TimeUnit.SECONDS);
//Using scheduleWithFixedDelay() method
        executor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("Start making coffee At: " + new Date());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 1, 3L , TimeUnit.SECONDS);
    }
}