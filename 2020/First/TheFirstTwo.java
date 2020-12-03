import java.util.*;

public class TheFirstTwo{
  public static void main(String args[]){

      LinkedList<Integer> input = new LinkedList<Integer>();

      for(int i = 0; i < args.length; i++) {
            input.add(Integer.parseInt(args[i]));
        }

      while(input.size()>1){
        int curr = input.pop();
        for(int i = 0; i<input.size() ; i++){
          int smallSum = curr + input.get(i);
          for(int j = i+1; j<input.size(); j++){
            if(smallSum+input.get(j)==2020){
              int output = curr*input.get(i)*input.get(j);
              System.out.println(curr +" + "+input.get(j)+" + "+input.get(i)+ " = 2020");
              System.out.println(curr +" x "+input.get(j)+" * "+input.get(i)+ " = "+ output);
            }
          }
        }
      }

      System.out.println("complete");
}
}
