import java.util.*;
import java.io.*;

//template: put date and number here
public class TheThirdOne{
  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("input.txt"))) {

        ArrayList<String> trees = new ArrayList<String>();
        while(input.hasNextLine())
        {
          int i = 0;
          trees.add(input.nextLine());
          System.out.println(trees.get(i));
          i++;
        }

        int bruises = 0;
        int pos = 0;
  

        //System.out.println(trees.size());

        for(int j = 0 ; j < trees.size() ; j++)
        {
          //System.out.println(trees.get(j).charAt(pos%trees.get(0).length()));
          if(trees.get(j).charAt(pos%trees.get(0).length())=='#')
              bruises++;
          pos = pos+3;
        }

        System.out.println(bruises);

  }
catch (IOException e) {
    e.printStackTrace();
}
}
}
