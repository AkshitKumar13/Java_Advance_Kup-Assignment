package Advance.Question3;

public class JoinAndSleepExample extends Thread {


        public void run(){
            for(int i=1;i<=5;i++){
                try{
                    Thread.sleep(500);  // sleep thread 500 ms
                }catch(Exception e){System.out.println(e);}
                System.out.println(i);
            }
        }
        public static void main(String args[]){
            JoinAndSleepExample t1=new JoinAndSleepExample();
            JoinAndSleepExample t2=new JoinAndSleepExample();
            JoinAndSleepExample t3=new JoinAndSleepExample();
            t1.start();
            try{
                t1.join(); // join thread
                t2.start();
                //until t2 thread is not completed t3 will not be start
                t2.join();
                t3.start();
            }catch(Exception e){System.out.println(e);}


        }
    }


