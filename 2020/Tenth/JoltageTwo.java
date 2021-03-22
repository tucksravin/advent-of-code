import java.util.*;
import java.io.*;

//template: put date and number here
public class JoltageTwo{
  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("input.txt"))) {


        LinkedList<Long> adaptors = new LinkedList<Long>();

        while(input.hasNext())
         {
           adaptors.add(Long.parseLong(input.next()));
         }

         adaptors.sort(Comparator.naturalOrder());

         ArrayList<AbstractMap.SimpleEntry<Boolean, Long>> a = new ArrayList<AbstractMap.SimpleEntry<Boolean, Long>>();

         a.add(new AbstractMap.SimpleEntry(true, (long)-1));

         for(int i = 1 ; i<adaptors.get(adaptors.size()-1).intValue()+3 ; i++)
          {
            a.add(new AbstractMap.SimpleEntry(false, (long)-1));
          }

          a.add(new AbstractMap.SimpleEntry(true, (long)-1));
          a.add(new AbstractMap.SimpleEntry(false, (long)-1));
          a.add(new AbstractMap.SimpleEntry(false, (long)-1));
          a.add(new AbstractMap.SimpleEntry(false, (long)-1));

          Iterator<Long> it = adaptors.iterator();

          while(it.hasNext())
          {
            a.set(it.next().intValue(),new AbstractMap.SimpleEntry(true, (long) -1));
          }

          for(int i = 0 ; i<a.size() ; i++)
            {
              System.out.println(i + ": "+a.get(i).getKey());
            }


          System.out.println(path(0, a));






  }
catch (IOException e) {
    e.printStackTrace();
}
}

public static long path(int i, ArrayList<AbstractMap.SimpleEntry<Boolean,Long>> a)
  {
    long count = (long) 0;
    Long n = (long) -1;

    System.out.println(a.get(i+1).getValue());

    if(a.get(i+1).getKey())
    {
      if(a.get(i+1).getValue().longValue()==n)
        a.get(i+1).setValue(path(i+1, a));


      count=count + a.get(i+1).getValue();
    }


    if(a.get(i+2).getKey())
    {
      if(a.get(i+2).getValue()<0)
        a.get(i+2).setValue(path(i+2, a));

      count=count + a.get(i+2).getValue();
    }

    if(a.get(i+3).getKey())
    {
      if(a.get(i+3).getValue()<0)
        a.get(i+3).setValue(path(i+3, a));

      count=count + a.get(i+3).getValue();
    }

    if(count==0)
      return (long)1;

    return count;
  }
}
