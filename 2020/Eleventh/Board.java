import java.util.*;
import java.io.*;

//template: put date and number here
public class Board{
  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("input.txt"))) {

      SeatMap m = new SeatMap();

      String ln;

      while(input.hasNextLine())
      {
        ln = input.nextLine();

        m.setSeat(true, ln.substring(0,1));

        for(int i = 1 ; i<ln.length() ; i++)
        {
          m.setSeat(false, ln.substring(i,i+1));
        }
      }

      System.out.println(m.toString());
      System.out.println();

      SeatMap old = m;

      SeatMap curr = new SeatMap(m.musicalChairs());

      
      while(!curr.equals(old))
        {
          System.out.println(curr.toString());

          System.out.println();

          old = curr;
          curr = new SeatMap(curr.musicalChairs());

        }




      //System.out.println(curr.toString());

      System.out.println();

      /*
      Iterator<Integer> it = curr.checkDebug(1,0).iterator();

      System.out.println(curr.toString());

      System.out.println();

      while(it.hasNext())
      {
       System.out.println(it.next());
      }
      */

      curr = new SeatMap(curr.musicalChairs());

      System.out.println(curr.toString());

      System.out.println();
      System.out.println(curr.countPassengers());



  }
catch (IOException e) {
    e.printStackTrace();
}
}
}
