import java.util.*;
import java.io.*;

//template: put date and number here
public class Orders{
  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("input.txt"))) {

      WaypointShip titanic = new WaypointShip();
      String comm;

      while(input.hasNextLine())
      {
        System.out.println(titanic.x()+","+titanic.y()+" : "+titanic.wx()+","+titanic.wy());
        comm = input.nextLine();
        titanic.order(comm.substring(0,1), Integer.parseInt(comm.substring(1)));
      }

      System.out.println(titanic.x()+","+titanic.y());



  }
catch (IOException e) {
    e.printStackTrace();
}
}
}
