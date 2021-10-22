package Advance.Question8;

public class MultipleCatchBlock {


    public static void main(String[] args) {

        try{
            int a[]=new int[5];

            System.out.println(a[10]);
        }
        catch(ArithmeticException e)
        {
            System.out.println("Arithmetic Exception occurs");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ArrayIndexOutOfBounds Exception occurs");
        }
        catch(Exception e)
        {
            System.out.println("Parent Exception occurs");
        }
        finally {
            System.out.println("Finally block execute");
            int a[]=new int[5];
            a[0]=10;
            a[1]=15;
            a[2]=2;
            a[3]=5;
            a[4]=8;

            for(int i=0; i<a.length;i++){
                System.out.println((a[i]));
            }

        }

    }
}