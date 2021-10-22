package Advance.Question3;

import java.util.*;


//Schedule task using schedule(), scheduleAtFixedRate() and scheduleAtFixedDelay()

  class ScheduleExample_8 {
    public static void main(String[] args) {
// creating timer task, timer
        Timer t = new Timer();
        TimerTask task1 = new TimerTask() {
         ///////using Schedule method   /
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    System.out.print("* ");
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
        };
      t.schedule(task1, new Date(),1000);



        //scheduleAtFixedRate
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task Timer on Fixed Rate");
            }

            ;
        };
        t.scheduleAtFixedRate(task2,new Date(),1000);

    }
}