import java.util.*;
import java.io.*;

//template: put date and number here
public class TheThirdTwo{
  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("input.txt"))) {

        ArrayList<String> trees = new ArrayList<String>();
        while(input.hasNextLine())
        {
          int i = 0;
          trees.add(input.nextLine());
          //System.out.println(trees.get(i));
          i++;
        }




         long multibruises = checkTrees(1,1,trees) * checkTrees(3,1,trees) * checkTrees(5,1,trees) *checkTrees(7,1,trees)*checkTrees(1,2,trees);


        System.out.println(multibruises);

  }
catch (IOException e) {
    e.printStackTrace();
}
}

public static long checkTrees(int right, int down, ArrayList<String> forest)
{
  int bruises = 0;
  int pos = 0;

  for(int j = 0 ; j < forest.size() ; j = j + down)
  {
    //System.out.println(trees.get(j).charAt(pos%trees.get(0).length()));
    if(forest.get(j).charAt(pos%forest.get(0).length())=='#')
        bruises++;

    pos = pos+right;
  }

  return bruises;
}
}
