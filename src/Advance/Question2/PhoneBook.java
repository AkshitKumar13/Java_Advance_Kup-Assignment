package Advance.Question2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
public static void main(String...args){
    Map<String,String> map=new HashMap<>();
    Scanner sc=new Scanner(System.in);
    int input;
    do {
        System.out.println("press 1 for add contact\n"+"press 2 for search contact"+"\n"+"for exit press 8");
       input =sc.nextInt();// its take input from user
        if (input == 1) {
            //enter contact name to add
            System.out.println("enter name");
            String name = sc.next();
          //enter mobile number
            System.out.println("enter phone number");
            String number = sc.next();
            //contact added
            map.put(name, number);
        }
        else if (input == 2) {
            System.out.println("enter contact name");
            String searchName = sc.next();

        if(map.containsKey(searchName) ){  // if map contains the key then it return true else return does not match
            System.out.println(map.get(searchName));
        }
        else{
            System.out.println("name does not match");
        }
        }
    }
    while(input!=8);
 }
}
