import java.util.*;
import java.io.File;
import java.io.IOException;

public class TheSecondOne{

  public static void  main(String args[]){

    try (Scanner input = new Scanner(new File("Second.txt"))) {



    int total = 0;
    int valid = 0;

    while(input.hasNextLine())
      {
        //System.out.println("next line is:");
        String curr = input.nextLine();

        //System.out.println(curr);

        int floor = Integer.parseInt(curr.substring(0, curr.indexOf("-")));
        //System.out.println("Floor: " + floor);

        //System.out.println(curr);
        int ceiling = Integer.parseInt(curr.substring(curr.indexOf("-")+1, curr.indexOf(' ')));
          //System.out.println("Ceiling: " + ceiling);
        char letter = curr.charAt(curr.indexOf(" ")+1);
        char[] pw = curr.substring(curr.indexOf(":")+1,curr.length()).toCharArray();

        int letterCount = 0;

        for(int i = 0 ; i < pw.length ; i++)
        {
          if(pw[i]==letter)
            letterCount++;
        }

        if(letterCount>=floor&&letterCount<=ceiling)
          valid++;

        total++;

      }

      System.out.println(valid + " of " + total +" passwords were valid.");

    }
    catch (IOException e) {
        e.printStackTrace();
    }
  }

}
