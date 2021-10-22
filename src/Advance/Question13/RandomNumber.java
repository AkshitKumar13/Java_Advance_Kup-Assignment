package Advance.Question13;

import java.util.Random;

 public class RandomNumber extends Thread{

     public void run(){
         Random random=new Random();
         for(int i=0;i<10;i++){
             int randomNumber= random.nextInt(30);
             System.out.println("\n Random Numbers--  "+randomNumber);

             if((randomNumber%2)==0){
             Square obj=new Square(randomNumber);
            obj.start();
            }
             else{
                 Cube cubeObj=new Cube(randomNumber);
                 cubeObj.start();
             }
             try {
                 Thread.sleep(1000);
             }
             catch (InterruptedException ex) {
                 System.out.println(ex);
             }
         }
     }

}
class Square extends Thread{
    int num;

    public Square(int randomNumber) {
        num=randomNumber;

    }
    public void run(){
      System.out.print("\nSquare "+num+" - "+num*num);
    }
}
class Cube extends Thread{
     int num;
     public Cube(int randomNumber){
         num=randomNumber;
     }
     public void run(){
         System.out.print("\nCube  "+ num+" - "+num*num*num);

     }
}
 class MultiThreadMain {
     public static void main(String... args) {
         RandomNumber Randomobj = new RandomNumber();
          Randomobj.start();
     }
 }