package Advance.Question14;

import java.util.Scanner;
import java.util.Vector;

public class VectorObject {
 public static void main(String...args){
     int input;
     String fname;
     String lname;
    Vector<String> vectorObj=new Vector<>();
     Scanner sc=new Scanner(System.in);
     try {

         do {
             System.out.print("\nEnter 1 to add Name\n Enter 2 for view detail\n Enter 3 for Exit\n");
             input = sc.nextInt();
             if (input == 1) {
                 System.out.print("\nEnter first name\n");
                  fname = sc.next();
                 System.out.print("\nEnter last name\n");
                 lname = sc.next();
                 vectorObj.add(fname + " " + lname);


             } else if (input == 2) {
                 System.out.print(vectorObj);
             }
         }

         while (input != 3);
     }
     catch (Exception e){
         System.out.print(e);
     }
 }


}
