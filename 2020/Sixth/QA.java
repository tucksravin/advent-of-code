import java.util.*;
import java.io.*;

//template: put date and number here
public class run{
  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("input.txt"))) {

        ArrayList<ArrayList<ArrayList<Boolean>>> everyone = new ArrayList<ArrayList<ArrayList<Boolean>>>();
        ArrayList<Character> alphabet = new ArrayList<Character>();
        char[] a = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        for(int i = 0 ; i<26 ; i++)
          {
            alphabet.add(a[i]);
          }

        ArrayList<ArrayList<Boolean>> bg = new ArrayList<ArrayList<Boolean>>();
        ArrayList<Boolean> ind;
        ArrayList<Boolean> ans = new ArrayList<Boolean>();
        int sum = 0;
        String line;
        char[] lineChar;

        while(input.hasNextLine())
        {
          line = input.nextLine();

          if(!line.isEmpty())
          {
            ind = new ArrayList<Boolean>();
            for(int i = 0 ; i < 26 ; i++)
            {
              ans.add(false);
            }

            lineChar = line.toCharArray();

            for(int i = 0 ; i<lineChar.length ; i++)
            {
              System.out.print(lineChar[i]);

              ind.set(alphabet.indexOf(lineChar[i]), true);
            }
            System.out.println();

            bg.add(ind);
          }

          if(line.isEmpty()||!input.hasNextLine())
          {
            System.out.println();
            System.out.println();

            for(int i = 0 ; i<26 ; i++)
              {
                if(ans.get(i))
                  sum++;
              }

              everyone.add(bg);
              ans = new ArrayList<Boolean>();
              for(int i = 0 ; i < 26 ; i++)
              {
                ans.add(false);
              }
              bg = new ArrayList<ArrayList<Boolean>>();

          }

        }

        System.out.println(sum);


  }
catch (IOException e) {
    e.printStackTrace();
}
}
}
