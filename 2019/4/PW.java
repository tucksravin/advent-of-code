import java.util.*;
import java.io.*;

//template: put date and number here
public class PW{
  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("input.txt"))) {

        int sum = 0;
        int dc = 0;
        int dp = 0;

        for(int i = 245182 ; i<790573 ; i++)
        {
          String a = Integer.toString(i);
          char[] b = a.toCharArray();
          int[] curr = new int[b.length];

          int ind = 0;

          for(char digit : b)
          {
            curr[ind] = digit;
            ind++;
          }

          boolean db = false;
          boolean inc= true;

          if(curr.length==6)
          {
            for(int j = 1 ; j<curr.length ; j++)
            {
              if(curr[j]==curr[j-1])
                db=true;

              if(curr[j]<curr[j-1])
              {
                inc=false;
                j=curr.length;
              }
            }
            if(inc&&db)
              sum++;
          }
        }

        System.out.println(sum);



  }
catch (IOException e) {
    e.printStackTrace();
}
}
}
