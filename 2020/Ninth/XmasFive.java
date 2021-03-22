import java.util.*;
import java.io.*;

//template: put date and number here
public class XmasFive{
  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("inputTwo.txt"))) {

        ArrayList<Double> nums = new ArrayList<Double>();
        double curr = 0;
        boolean valid = false;
        double target = -1;


        while(input.hasNext())
          {
            nums.add(Double.parseDouble(input.nextLine()));
          }

          for(int point = 5 ; point<nums.size() ; point++)
          {
            curr=nums.get(point);
            valid=false;

            for(int i = point-5; i<point-1 ; i++)
            {
              for(int j = i+1 ; j<point ; j++)
              {
                if(nums.get(i)+nums.get(j)==curr)
                  valid=true;
              }
            }

            if(!valid)
            {
              target = curr;
            }
          }

          double sum = 0;
          int a = 2;
          int m = 0;
          double top =0;
          double bot = 0;

          System.out.println(target);

          for(int i = 0; i<nums.size()-1 ; i++)
            {
              sum=nums.get(i)+nums.get(i+1);
              a = 2;
              while(sum<target)
              {
                sum = sum+nums.get(i+a);
                a++;
              }


              if(sum==target)
              {
                bot = nums.get(i);
                top = nums.get(i+a-1);

                break;
              }


            }

          System.out.println("bot: "+ bot +"\n top: " +top);
          System.out.println( bot +top);



  }
catch (IOException e) {
    e.printStackTrace();
}
}
}
