import java.util.*;
import java.io.*;

//template: put date and number here
public class Color{

  private String c;
  private LinkedList<AbstractMap.SimpleEntry<Color, Integer>> hold;

  public Color(String col)
  {
    c = col;
    hold = new LinkedList<AbstractMap.SimpleEntry<Color,Integer>>();
  }





  public String name()
  {
    return c;
  }

  public boolean contains(String q)
  {
    return hold.contains(q);
  }

  public void addColor(AbstractMap.SimpleEntry<Color, Integer> a){
    if(!hold.contains(a.getKey().name()))
      hold.add(a);


  }

  public void addColor(LinkedList<AbstractMap.SimpleEntry<Color, Integer>> a){
    Iterator<AbstractMap.SimpleEntry<Color, Integer>> it = a.iterator();

    while(it.hasNext())
      this.addColor(it.next());
  }

  public LinkedList<AbstractMap.SimpleEntry<Color, Integer>> below()
  {
    return hold;
  }


  public boolean equals(Color comp){

    return c.equals(comp.name());
  }

  public String toString()
  {
    String o = c + " can contain: ";
    Iterator<AbstractMap.SimpleEntry<Color,Integer>> it = hold.iterator();
    AbstractMap.SimpleEntry<Color,Integer> h;

    while(it.hasNext())
      {
        h = it.next();
        o = o + " " + h.getValue()+ " " + h.getKey().name() +", ";
      }

    o = o.substring(0, o.length()-2);

    return o;
  }

}
