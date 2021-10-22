package Advance.Question7;

public class JavaHungary {
    public static void main(String args[])
    {
        try
        {
            int arr[]= {1, 2, 3, 4, 5};
            for (int i = 0; i <= 5; i++)
            {
                System.out.print ("Array elements are : " + arr[i] + "\n");
            }
        }
        catch (Exception e)
        {
            System.out.println ("Exception : " + e);
        }
  //      catch (ArrayIndexOutOfBoundsException ex)  // ArrayIndexOutOfBoundsException has already been caught in Exception e
  //      {
        //       System.out.println ("ArrayIndexOutOfBoundsException : "+ ex);
  //      }
    }
}
