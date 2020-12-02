import java.util.*;

public class TheFirstOne{
  public static void main(String args[]){

      LinkedList<Integer> input = new LinkedList<Integer>();

      for(int i = 0; i < args.length; i++) {
            input.add(Integer.parseInt(args[i]));
        }

      while(input.size()>1){
        int curr = input.pop();
        for(int j = 0; j<input.size() ; j++){
          if(curr+input.get(j)==2020){
            int output = curr*input.get(j);
            System.out.println(curr +" + "+input.get(j)+ " = 2020");
            System.out.println(curr +" x "+input.get(j)+ " = "+ output);
          }
        }
      }

      System.out.println("complete");
}
}
