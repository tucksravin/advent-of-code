import java.util.*;
import java.io.*;

public class runTwo{

  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("input.txt"))) {

        int fuel = 0;

        //solve
        while(input.hasNextLine())
        {
          fuel = fuel + fuelPerMod(Integer.parseInt(input.nextLine()));
        }

        System.out.println(fuel);

  }
catch (IOException e) {
    e.printStackTrace();
}
}

private static int fuelPerMod(int mass)
{
  int moreFuel= mass/3-2;

  if(moreFuel<1)
    return 0;
  else
    return moreFuel + fuelPerMod(moreFuel);
}
}
