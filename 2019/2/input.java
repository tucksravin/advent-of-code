import java.util.*;
import java.io.*;

public class input{

public static void main(String args[]){

    try (Scanner input = new Scanner(new File("input.txt"))) {

    ArrayList<Integer> rec = new ArrayList();

    input.useDelimiter(",");

  //add one "," to end of data

    while(input.hasNextInt()){
       rec.add(input.nextInt());
    }

  nounVerb nv = new nounVerb(rec);
  nv.run();
}
catch (IOException e) {
  e.printStackTrace();
}
}
}
