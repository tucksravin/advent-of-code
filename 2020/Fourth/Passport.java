import java.util.*;
import java.io.*;

//use AbstractMap.SimpleEntry
public class Passport{
  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("input.txt"))) {
        String line;
        String token;
        Scanner lineRead;
        AbstractMap.SimpleEntry<String,String> pair;
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
        String value;

        char c;
        boolean g = false;
        boolean k = false;
        String hairColors = "1234567890abcdef";

        String digits = "0123456789";

        LinkedList<String> eyes = new LinkedList<String>();

        eyes.add("amb");
        eyes.add("blu");
        eyes.add("brn");
        eyes.add("grn");
        eyes.add("oth");
        eyes.add("gry");
        eyes.add("hzl");


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
              pair = checker.next();
              value = pair.getValue();

              System.out.println(pair.getKey()+ ": "+value);

              if(pair.getKey().equals("byr"))
                  {
                    if(Integer.parseInt(value)<2003&&Integer.parseInt(value)>1919)
                    byr=true;
                  }

              if(pair.getKey().equals("iyr")){
                if(Integer.parseInt(value)<2021&&Integer.parseInt(value)>2009)
                  iyr=true;
                }

              if(pair.getKey().equals("hgt"))
                {

                  if(value.substring(value.length()-2).equals("cm"))
                    {
                      value=value.substring(0,value.length()-2);
                      if(Integer.parseInt(value)<194&&Integer.parseInt(value)>149)
                        hgt=true;
                    }

                  if(value.substring(value.length()-2).equals("in"))
                      {
                        value=value.substring(0,value.length()-2);
                        if(Integer.parseInt(value)<77&&Integer.parseInt(value)>58)
                          hgt=true;
                      }
                }


              if(pair.getKey().equals("eyr"))
                if(Integer.parseInt(value)<2031&&Integer.parseInt(value)>2019)
                  eyr=true;

              if(pair.getKey().equals("hcl"))
                if(value.substring(0,1).equals("#")&&value.length()==7)
                  {
                  g=true;
                  for(int i=1; i< value.length() ; i++)
                  {
                    c = value.charAt(i);

                    k = false;
                    for(int j = 0; j<hairColors.length() ; j++)
                      {
                        if(c==hairColors.charAt(j))
                        k=true;
                      }

                    if(!k)
                      g=false;
                  }
                  if(g)
                    hcl=true;

                  g = false;

                }

              if(pair.getKey().equals("ecl"))
                if(eyes.contains(value))
                ecl=true;

              if(pair.getKey().equals("pid"))
                if(value.length()==9)
                {

                  g=true;
                  for(int i=0; i< value.length() ; i++)
                  {
                    c = value.charAt(i);

                    k = false;
                    for(int j = 0; j<digits.length() ; j++)
                      {
                        if(c==digits.charAt(j))
                        k=true;
                      }


                    if(!k)
                      g=false;
                  }

                  if(g)
                    pid=true;

                  g = false;
                }

            if(pair.getKey().equals("cid"))
                cid=true;
            }

            if(byr&&iyr&&eyr&&hgt&&hcl&&ecl&&pid)
              valid++;

              System.out.println("\n"+"bry: " + byr);
              System.out.println("iry: " + iyr);
              System.out.println("ery: " + eyr);
              System.out.println("hgt: " + hgt);
              System.out.println("hcl: " + hcl);
              System.out.println("ecl: " + ecl);
              System.out.println("pid: " + pid);
              System.out.println(valid);

              System.out.println();
              System.out.println();



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

System.out.println(valid);


  }
catch (IOException e) {
    e.printStackTrace();
}
}
}
