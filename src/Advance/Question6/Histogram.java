package Advance.Question6;


//import acm.program.*;
//import acm.util.*;
import java.io.*;

    public class Histogram   {
          int[] histogramArray;


            /* Initializes the histogram array */
              public void initHistogram () {
                histogramArray = new int[11];
                for (int i = 0; i <= 10; i++) {
                    histogramArray[i] = 0;
                }
            }

            /* Reads the exam scores, updating the histogram */
            public   void readScoresIntoHistogram () {
                try {
                    BufferedReader rd = new BufferedReader(new FileReader(DATA_FILE));
                    while (true) {
                        String line = rd.readLine();
                        if (line == null) break;
                        int score = Integer.parseInt(line);
                        if (score < 0 || score > 100) {
                           // throw new  Exception("That score is out of range");
                            System.out.print("that score is out of range");
                        } else
                        {
                            int range = score / 10;
                            histogramArray[range]++;
                        }
                    }
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }

            /* Displays the histogram */
             public void printHistogram () {
                for (int range = 0; range <= 10; range++) {
                    String label;
                    switch (range) {
                        case 0:
                            label = "00-09";
                            break;
                        case 10:
                            label = "  100";
                            break;
                        default:
                            label = (10 * range) + "-" + (10 * range + 9);
                            break;
                    }
                    String stars = createStars(histogramArray[range]);
                    System.out.println(label + ": " + stars);
                }
            }

            /* Creates a string consisting of n stars */
            public String createStars ( int n){
                String stars = "";
                for (int i = 0; i < n; i++) {
                    stars += "*";
                }
                return stars;
            }
            /* Private instance variables */


            /* Name of the data file */
            private static final String DATA_FILE = "src/com/Advacne/Question6/midterm.txt";
        public void run () {
            initHistogram();
            readScoresIntoHistogram();
            printHistogram();
        }

        public static void main(String... args) {
            Histogram obj=new Histogram();
            obj.run();

         }

    }
