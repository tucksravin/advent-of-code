import java.util.*;
import java.io.*;

public class runOne{
  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("input.txt"))) {

        int fuel = 0;

        //solve
        while(input.hasNextLine())
        {
          fuel = fuel+ Integer.parseInt(input.nextLine())/3-2;
        }


        System.out.println(fuel);

  }
catch (IOException e) {
    e.printStackTrace();
}
}
}
