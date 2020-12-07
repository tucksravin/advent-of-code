import java.util.*;
import java.io.*;


//template: put date and number here
public class Bags{
  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("input.txt"))) {

        LinkedList<Color> catalog = new LinkedList<Color>();
        LinkedList<Color> interior = new LinkedList<Color>();

        String rule;

        //exterior color name
        String en;

        //interior color name
        String in;

        String ics;

        //exterior color
        Color ec;

        //interior color
        Color ic;



        while(input.hasNextLine())
        {
          rule = input.nextLine();
          en = rule.substring(0, rule.indexOf("bags")-1);
          ec = new Color(en);
          ec = unique(catalog, ec);
          interior = new LinkedList<Color>();

          ics = rule.substring(rule.indexOf("contain")+7);

          Scanner sc = new Scanner(ics);

          int i = 0;

          while(sc.hasNext())
          {

            //int
            if(i==0&&sc.next().equals("no"))
                {
                  sc.next();
                  sc.next();
                  i=-1;
                }

            if(i==1)
              {

                ic = new Color(sc.next()+" "+sc.next());

                ic = unique(catalog, ic);

                interior.add(ic);
                }

            if(i==2)
              {
                sc.next();
                i=-1;
              }

              i++;
          }

          ec.addColor(interior);


        }



        Iterator<Color> it = catalog.iterator();

        Color on;

        LinkedList<Color> empty = new LinkedList<Color>();
        LinkedList<Color> children = new LinkedList<Color>();

        while(it.hasNext())
          {

            empty = new LinkedList<Color>();

             on = it.next();

               System.out.println(on.toString());

               children = checkContents(empty, on);
               children.remove(0);

               on.addColor(children);

               on.removeDuplicates();
          }

          it = catalog.iterator();
          while(it.hasNext())
            {
              System.out.println(it.next().toString());
              System.out.println();
            }



  }
catch (IOException e) {
    e.printStackTrace();
}


}

public static Color unique(LinkedList<Color> catalog, Color check)
{
  boolean mix = true;
  Iterator<Color> cat= catalog.iterator();
  Color samp;

  while(cat.hasNext())
    {
      samp=cat.next();
      if(samp.equals(check))
        {
          check=samp;
          mix=false;
        }
    }

    if(mix)
      catalog.add(check);

    return check;

}

public static LinkedList<Color> checkContents(LinkedList<Color> ckd, Color start)
{
  Iterator <Color> ab = start.below().iterator();
  System.out.println("2");

  if(!ckd.contains(start))
  {
    ckd.add(start);
    System.out.println("added "+start.name());

      while(ab.hasNext())
        {
          ckd.addAll(checkContents(ckd, ab.next()));
        }
    }

    return ckd;

  }

  public static LinkedList<Color> removeDuplicates(LinkedList<Color> list)
  {
    LinkedList<Color> out = new LinkedList<Color>();
    LinkedList<Color> in = list;
    Iterator<Color> curr = in.iterator();
    Color check;

    while(!in.isEmpty())
      {  check = in.remove();
        out.add(check);

        while(in.remove(check));
      }

        return out;

          }

    }
