package Advance.Question9.P;

import Advance.Question9.P1.TwoDim;
import Advance.Question9.P2.ThreeDim;

public class Main {
    public static void main(String... args) {
        TwoDim dimension;
       dimension = new TwoDim(4, 5);
       System.out.println(dimension);

       dimension= new ThreeDim(2, 4, 6);
       System.out.println(dimension);
    }
}