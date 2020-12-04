import java.util.*;
import java.io.*;

//use AbstractMap.SimpleEntry
public class Passport{
  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("input.txt"))) {
        String line;
        String token;
        Scanner lineRead;
        LinkedList<AbstractMap.SimpleEntry<String,String>> id = new LinkedList<AbstractMap.SimpleEntry<String,String>>();

        boolean byr = false;
        boolean iyr =false;
        boolean eyr =false;
        boolean hgt = false;
        boolean hcl = false;
        boolean ecl =false;
        boolean pid =false;
        boolean cid = false;


        int valid = 0;

        while(input.hasNextLine())
        {
          line = input.nextLine();
          if(!line.isEmpty())
          {
            lineRead = new Scanner(line);
            while(lineRead.hasNext())
            {
                token=lineRead.next();
                id.add(new AbstractMap.SimpleEntry<String,String>(token.substring(0,3),token.substring(4)));

            }
          }
          if(line.isEmpty()||!input.hasNextLine()){
            Iterator<AbstractMap.SimpleEntry<String,String>> checker = id.iterator();
            while(checker.hasNext())
            {
              token = checker.next().getKey();
              
              if(token.equals("byr"))
                byr=true;
              else if(token.equals("iyr"))
                iyr=true;
              else if(token.equals("hgt"))
                hgt=true;
              else if(token.equals("eyr"))
                eyr=true;
              else if(token.equals("hcl"))
                hcl=true;
              else if(token.equals("ecl"))
                ecl=true;
              else if(token.equals("pid"))
                pid=true;
              else if(token.equals("cid"))
                cid=true;
            }

            if(byr&&iyr&&eyr&&hgt&&hcl&&ecl&&pid)
              valid++;

              System.out.println(valid);

              byr = false;
              iyr =false;
              eyr =false;
              hgt = false;
              hcl = false;
              ecl =false;
              pid =false;
              cid = false;

              id= new LinkedList<AbstractMap.SimpleEntry<String,String>>();
          }
        }

  }
catch (IOException e) {
    e.printStackTrace();
}
}
}
