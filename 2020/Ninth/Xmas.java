import java.util.*;
import java.io.*;

//template: put date and number here
public class Xmas{
  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("input.txt"))) {

        ArrayList<Double> nums = new ArrayList<Double>();
        double curr = 0;
        boolean valid = false;
        double target = -1;


        while(input.hasNext())
          {
            nums.add(Double.parseDouble(input.nextLine()));
          }

          for(int point = 25 ; point<nums.size() ; point++)
          {
            curr=nums.get(point);
            valid=false;

            for(int i = point-25; i<point-1 ; i++)
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
          int b = 0;
          int t = 0;
          double top = -1;
          double bot = -1;

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

                b=i;
                t=i+a-1;
                break;
              }



            }

            top = nums.get(b);
            bot = top;
            System.out.println("init bot: "+ top);

            for(int i = b+1 ; i < t ; i++)
            {
              if(nums.get(i)>top)
                top=nums.get(i);

              if(nums.get(i)<bot)
                {
                  bot=nums.get(i);
                  System.out.println(i);
                }
            }

          System.out.println("range: "+ b + " to "+t);

          System.out.println("bot: "+ bot +"\n top: " +top);
          System.out.println( bot +top);



  }
catch (IOException e) {
    e.printStackTrace();
}
}
}
