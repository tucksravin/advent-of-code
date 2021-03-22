import java.util.*;
import java.io.*;

//template: put date and number here
public class Acc{
  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("input.txt"))) {

      ArrayList<Command> comms =  new ArrayList<Command>();

      String line;
      Scanner parse;

      while(input.hasNextLine())
      {
        line = input.nextLine();
        parse =  new Scanner(line);
        comms.add(new Command(parse.next(), Integer.parseInt(parse.next())));

      }

      int changeItem = 0;
      boolean comp = false;
      int a = 0;
      int p = 0;
      boolean loop = false;
      Command curr;

      while(!comp)
      {


      if(comms.get(changeItem).change())
      {
        System.out.println();
        System.out.println("new run");

        for(int i = 0 ; i<comms.size(); i++ )
        {
          comms.get(i).reset();
        }

        a = 0;
        p = 0;
        loop = false;
        curr = comms.get(0);

        curr.run();

        while(!loop&&p<comms.size())
          {
            System.out.println(curr.toString());

            if(curr.getOp().equals("acc"))
            {
              a = a + curr.getVal();
              p++;
            }

            if(curr.getOp().equals("nop"))
            {
              p++;
            }

            if(curr.getOp().equals("jmp"))
            {
              p=p+curr.getVal();
              if(curr.getVal()==0)
              {
                loop = true;
              }
            }

            if(p>=comms.size())
              comp=true;

            else
            curr=comms.get(p);

            loop = !curr.run();


          }


        }

        comms.get(changeItem).change();
        changeItem++;
      }
        System.out.println(a);





  }
catch (IOException e) {
    e.printStackTrace();
}
}
}
