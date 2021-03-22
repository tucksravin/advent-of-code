import java.util.*;
import java.io.*;

//template: put date and number here
public class Joltage{
  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("input.txt"))) {

 LinkedList<Integer> adaptors = new LinkedList<Integer>();
 int ones = 0;
 int twos = 0;
 int threes = 0;
 int diff;

 while(input.hasNext())
  {
    adaptors.add(Integer.parseInt(input.next()));
  }

  adaptors.sort(Comparator.naturalOrder());

  for(int i = 1 ; i<adaptors.size();i++)
  {
    diff = adaptors.get(i)-adaptors.get(i-1);

    if(diff==1)
      ones++;

    if(diff==2)
      twos++;

    if(diff==3)
      threes++;

    if(diff>3)
      break;

    System.out.println(adaptors.get(i));
  }

  threes++;
  ones++;

  System.out.println("ones: "+ones);
  System.out.println("twos: "+twos);
  System.out.println("threes: "+threes);


  }
catch (IOException e) {
    e.printStackTrace();
}
}
}
