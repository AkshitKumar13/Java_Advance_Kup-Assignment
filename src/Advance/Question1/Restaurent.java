package Advance.Question1;
 import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

    class  Dish{
            int dishId;
           String dishName;
            double creationTime;

    public Dish(int dishId,String dishName,double creationTime) { // create parameterize constructer
        super();
        this.dishId=dishId;
        this.dishName=dishName;
        this.creationTime=creationTime;
    }

    @Override  // override to string method
        public String toString() {
            return "Dish{" +
                    "dishId=" + dishId +
                    ", dishName='" + dishName + '\'' +
                    ", creationTime=" + creationTime +
                    '}';
        }
    }
    class Menu   {
        static List<Dish> menuList;

        static Dish obj2=new Dish(121,"paneer",10.5);
        static Dish obj3=new Dish(120," cholle",5.2);
        static Dish obj4=new Dish(122," Rajma",5.0);
        static Dish obj5=new Dish(123," Saahi panner",8.0);

//        static ArrayList<Dish> menuList= new ArrayList<Dish>();
         static{
            menuList = Arrays.asList(obj2,obj3,obj4,obj5);
    //menuList.add(obj2);
         }

}

  class Restaurent {


      public static void main(String... args) {
          Menu objMenu = new Menu();
          Scanner sc = new Scanner(System.in);

          int input ;

          do {
              System.out.println(" press 1 for dishes \n"+"press 2 for search dish enter dish Id"+"\n"+"enter 0 for exit");

              input = sc.nextInt();
              if (input == 1) {

                  // if input (press 1) is equal to 1 then it shows the menulist

                  System.out.println(objMenu.menuList);
              } else if (input == 2) {
                  // if input is equal to 2 then it prompt a message enter dishid if dish id is correct it shows Dish details
                  System.out.println("enter dishId for search dish");
                  int input2 = sc.nextInt();

                  for (int i = 0; i < objMenu.menuList.size(); i++) {
                      if (input2 == objMenu.menuList.get(i).dishId) {
                          System.out.println(objMenu.menuList.get(i));
                      }
//                      else  {
//
//                              System.out.println("Id is not exit");
//
//                      }
                  }

                  }
              }
              while (input != 0) ;


      }
  }

