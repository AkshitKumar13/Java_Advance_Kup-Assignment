package Advance.Question3;

  class SynchronizeTest extends Thread{
    public static void main(String[] args) {
        PrintTable printTable =new PrintTable();
        Thread1 thread1 =new Thread1(printTable);
        Thread2 thread2 =new Thread2(printTable);
        Thread3 thread3 =new Thread3(printTable);

        thread1.start();

        thread2.start();

        thread3.start();
    }
}
class Thread2 extends Thread{
    PrintTable obj;
    Thread2(PrintTable obj){

        this.obj = obj;
    }
    @Override
    public void run() {

        obj.printTable(10);
    }
}
class PrintTable{
    synchronized void printTable(int n){//synchronized method
        for(int i=1;i<=5;i++){
            System.out.println(n*i);
            try{
                Thread.sleep(1000);
            }catch(Exception e){System.out.println(e);}
        }
    }
}
class Thread1 extends Thread{
    PrintTable obj;
    Thread1(PrintTable obj){

        this.obj = obj;
    }
    @Override
    public void run() {
        obj.printTable(20);
    }
}
class Thread3 extends Thread{
    PrintTable obj;
    Thread3(PrintTable obj){
        this.obj = obj;
    }
    @Override
    public void run() {
        obj.printTable(3);
    }
}