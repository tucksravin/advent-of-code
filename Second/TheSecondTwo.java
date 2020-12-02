import java.util.*;
import java.io.File;
import java.io.IOException;

public class TheSecondTwo{

  public static void  main(String args[]){

    try (Scanner input = new Scanner(new File("Second.txt"))) {



    int total = 0;
    int valid = 0;

    while(input.hasNextLine())
      {
        //System.out.println("next line is:");
        String curr = input.nextLine();

        //System.out.println(curr);

        int posOne = Integer.parseInt(curr.substring(0, curr.indexOf("-")))-1;


        //System.out.println(curr);
        int posTwo = Integer.parseInt(curr.substring(curr.indexOf("-")+1, curr.indexOf(' ')))-1;
          System.out.println("Position two: " + posTwo);
        char letter = curr.charAt(curr.indexOf(" ")+1);
        char[] pw = curr.substring(curr.indexOf(":")+2,curr.length()).toCharArray();

//System.out.println("Position one: " + posOne);
//System.out.println(pw[posOne]);

//System.out.println("Position twp: " + posTwo);
//System.out.println(pw[posTwo]);


        if((letter==pw[posOne])^(letter==pw[posTwo]))
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
