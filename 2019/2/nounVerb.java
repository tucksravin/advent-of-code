import java.util.*;
import java.io.*;

public class nounVerb{


    private  IntComp hi;
    public ArrayList<Integer> origin;
    public  ArrayList<Integer> ck;

public nounVerb(ArrayList<Integer> receive){
origin = receive;
}



  public void run(){

    for(int i=0;i<100;i++)
    {
      for(int j=0;j<100;j++)
        {
          ck = new ArrayList<Integer>();

          for(int k = 0 ; k < origin.size() ; k++)
          {
            ck.add(origin.get(k));
          }
          ck.set(1,i);
          ck.set(2,j);
          hi = new IntComp(ck);
          if(hi.run(0)==19690720)
          {]
            System.out.println(i*100+j);
          }
        }

    }

    System.out.println("failed");
}

}
