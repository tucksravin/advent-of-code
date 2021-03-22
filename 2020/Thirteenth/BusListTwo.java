import java.util.*;
import java.io.*;

//template: put date and number here
public class BusListTwo{

  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("input.txt"))) {
        long now = Long.parseLong(input.nextLine());

        ArrayList<Long> busTimes = new ArrayList<Long>();

        Scanner buses = new Scanner(input.nextLine());
        buses.useDelimiter(",");

        String token;
        while(buses.hasNext())
        {
          token=buses.next();
          if(token.equals("x"))
              busTimes.add((long)-1);

          else
            busTimes.add(Long.parseLong(token));

          //System.out.println(token);
        }

        long factor = busTimes.get(0);
        long currBus;
        boolean f = false;

        System.out.println("# of buses: "+busTimes.size());

        for(int i = 1 ; i<busTimes.size() ; i++)
        {
          f=false;
          currBus=busTimes.get(i);
          System.out.println("New bus: "+currBus+" loop| minutes after:"+i);
          if(currBus!=-1)
          {
            for(int j = 1 ; !f ; j++ )
            {
              System.out.println(j);
              if((factor*j+i)%currBus==0)
              {
                System.out.println("New factor: "+factor);
                f=true;
                factor=factor*j;
              }
            }
          }
        }

        System.out.println(factor);


  }
catch (IOException e) {
    e.printStackTrace();
}
}

}
