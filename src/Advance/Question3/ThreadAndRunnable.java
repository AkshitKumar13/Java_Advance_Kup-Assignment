package Advance.Question3;


class ThreadAndRunnable extends Thread
{
    public void run(){
        System.out.println("thread is running...");
    }

}

class  RunnableExample implements Runnable {

    @Override
    public void run() {

        System.out.println("Runnable is running");
    }

    public static void main(String... args) {
        ThreadAndRunnable t=new ThreadAndRunnable();
        t.start();
        RunnableExample obj = new RunnableExample();
        Thread thread = new Thread(obj);
        thread.start();
    }
}
