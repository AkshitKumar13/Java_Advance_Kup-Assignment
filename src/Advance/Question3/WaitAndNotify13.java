package Advance.Question3;


//Coordinate 2 threads using wait() and notify().
       class WaitAndNotify  extends Thread
    {
        public static void main(String[] args)
        {
            NotifyMehtod notify = new NotifyMehtod();
            notify.start();
            synchronized(notify)
            {
                try
                {
                    System.out.println("Waiting for 2 to complete...");
                    notify.wait();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("Total is: " + notify.total);
            } } }
    class  NotifyMehtod extends  WaitAndNotify
    {
        int total;
        @Override public void run()
        {
            synchronized(this)
            {
                for(int i=0; i<=100 ; i++)
                {
                    total += i;
                }
                notify();
            }}}

