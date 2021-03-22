import java.util.*;
import java.io.*;

//template: put date and number here
public class BusList{
  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("input.txt"))) {
        int now = Integer.parseInt(input.nextLine());

        ArrayList<Integer> busTimes = new ArrayList<Integer>();

        Scanner buses = new Scanner(input.nextLine());
        buses.useDelimiter(",");

        String token;
        while(buses.hasNext())
        {
          token=buses.next();
          if(!token.equals("x"))
            busTimes.add(Integer.parseInt(token));

          //System.out.println(token);
        }

        Iterator<Integer> it = busTimes.iterator();

        int curr = it.next();

        int bestTime = curr-now%curr;
        int bestBus = curr;

        while(it.hasNext())
          {
            curr = it.next();

            if(curr-now%curr<bestTime)
              {
                bestTime=curr-now%curr;
                bestBus=curr;
              }
          }

          System.out.println(bestTime*bestBus);






  }
catch (IOException e) {
    e.printStackTrace();
}
}
}
