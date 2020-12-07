import java.util.*;
import java.io.*;

//template: put date and number here
public class PWTwo{
  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("input.txt"))) {

        int sum = 0;
        int dc = 0;
        int dp = 0;

        for(int i = 245182 ; i<790572 ; i++)
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


          for(int ka = 0 ; ka<curr.length ; ka++)
          {
            //System.out.println(curr[ka]);

          }



          boolean db = false;
          boolean inc= true;
          boolean trip = true;

          if(curr.length==6)
          {
            for(int j = 1 ; j<curr.length ; j++)
            {
              if(curr[j]==curr[j-1])
              {
                if(j<curr.length&&curr[j]==curr[j+1])
                {
                  System.out.println("check trips on "+i);
                  int c = 0;
                  boolean first = true;

                  for(int k = j; k!=curr.length-1&&curr[k]==curr[k+1] ; k++)
                  {
                    //System.out.println(j);

                      while(k>0&&curr[k]==curr[k-1]&&first)
                        {
                          k--;
                        }

                      first = false;

                      c++;
                  }

                  if(c%2!=0&&c!=1)
                    {
                      trip=false;
                      j=curr.length;
                    }
                }

                db=true;
              }

              if(trip&&curr[j]<curr[j-1])
              {
                inc=false;
                j=curr.length;
              }
            }
            if(inc&&db&&trip)
              {
                sum++;
                System.out.println("f");
              }
          }
        }

        System.out.println(sum);



  }
catch (IOException e) {
    e.printStackTrace();
}
}
}
