import java.util.*;
import java.io.*;


//template: put date and number here
public class Nest{
  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("input.txt"))) {

        LinkedList<Color> catalog = new LinkedList<Color>();
        LinkedList<AbstractMap.SimpleEntry<Color, Integer>> interior = new LinkedList<AbstractMap.SimpleEntry<Color,Integer>>();



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

          interior = new LinkedList<AbstractMap.SimpleEntry<Color,Integer>>();
          AbstractMap.SimpleEntry<Color,Integer> ent;


          ics = rule.substring(rule.indexOf("contain")+7);

          Scanner sc = new Scanner(ics);

          int i = 0;
          int num=-1;
          String token;

          while(sc.hasNext())
          {

            //int
            if(i==0)
            {

            token = sc.next();
            if(token.equals("no"))
              {
                  sc.next();
                  sc.next();
                  i=-1;
              }
            else
              {
                num = Integer.parseInt(token);
              }

            }

            if(i==1)
              {

                ic = new Color(sc.next()+" "+sc.next());

                ic = unique(catalog, ic);

                interior.add(new AbstractMap.SimpleEntry<Color,Integer>(ic, num));
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

          while(it.hasNext())
            {
              Color n = it.next();
              if(n.name().equals("shiny gold"))
              {
                System.out.print("Gold bag contains ");
                System.out.print(howManyBags(n,1)-1);
                System.out.println(" bags.");


              }

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




  public static void removeDuplicates(LinkedList<Color> list)
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

        list= out;

    }

    public static int howManyBags(Color init, int multiplier)
    {
      if(!init.below().isEmpty()){

        System.out.println();
        System.out.println(init.name());
        System.out.println(multiplier);

      int c = 1;
      AbstractMap.SimpleEntry<Color,Integer> curr;
      Iterator <AbstractMap.SimpleEntry<Color,Integer>> it = init.below().iterator();
      while(it.hasNext())
        {
          curr = it.next();
          c=c+howManyBags(curr.getKey(), curr.getValue());
        }

      return multiplier*c;
    }
    else
      return multiplier;

    }


    }
