package Advance.Question12;
import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Employee {
    int empID;
    String empName;
    int empAge;

    public Integer getEmpID() {
        return empID;
    }

    public void setEmpID(Integer empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getempAge() {
        return empAge;
    }

    public void setempAge(int empAge) {
        this.empAge = empAge;
    }


    public Employee() {
    }





    static {
        try {

            ArrayList<String> empList = new ArrayList<>();
            File file = new File("src/com/Advacne/Question12/employee.txt");

              String line;
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                System.out.print(empList);
                while ((line = br.readLine()) != null) {
                    if (line.contains("Akshit")) // you can add here any value you want to change
                        line = line.replace("Akshit", "Aman");// himanshu change in Akshit
                    line = line.replace("22", "28");

                    empList.add(line);
                }
                fr.close();
                br.close();

                FileWriter fw = new FileWriter(file);
                BufferedWriter out = new BufferedWriter(fw);
                System.out.print(empList);
                for (String s : empList)
                    out.write(s);
                out.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            out.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public static void main (String[]args) throws FileNotFoundException {
//          ArrayList<Employee> empList1 = new ArrayList<>();
//            File file = new File("src/com/Advacne/Question12/employee.txt");
//            if ( file.exists() )
//            {
//                Scanner inFile = new Scanner( file );
//                inFile.useDelimiter("[;]");
//                while ( inFile.hasNext() )
//                {
//                    String line = inFile.next() ;
//                    line = line.trim().replaceAll("\n", "");
//                    line = line.trim().replaceAll("\t", "");
//                    line = line.trim().replaceAll(" ", "");
//                    if ( line.length() > 0 ) {
//                        String delims = "[,]+";
//                        String[] tokens = line.split(delims);
//                        Employee  emp = new Employee () ;
//                        emp.setEmpID(Integer.parseInt(tokens[0]));
//                        emp.setEmpName(tokens[1]);
//                        emp.setempAge(Integer.parseInt(tokens[2]));
//
//                        empList1.add(emp) ;
//                    }
//                }
//
//                inFile.close();
//
//            }
//            else {
//                out.println( "File Not Found");
//            }
//            int rec = 0 ;
//            for (Employee  employee : empList1) {
//                out.println( "Employee-"+ ++rec +":");
//                out.println( "ID = " + employee.getEmpID());
//                out.println( "Name = " + employee.getEmpName());
//                out.println( "City = " + employee.getempAge());
//            }
       }


        }


