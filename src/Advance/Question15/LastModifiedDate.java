package Advance.Question15;



import java.io.File;
import java.util.Date;
public class LastModifiedDate {



        public static void main(String[] args) {
            File myFile = new File("/home/knoldus/IdeaProjects/ Java Basic Assignment/src/com/Advacne/Question15/java.txt");

            long modifiedValue = myFile.lastModified();
            Date modifiedDate = new Date(modifiedValue);
            System.out.println(modifiedDate);
        }
    }


