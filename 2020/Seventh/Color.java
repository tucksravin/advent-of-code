import java.util.*;
import java.io.*;

//template: put date and number here
public class Color{

  private String c;
  private boolean gold;
  private LinkedList<Color> hold;

  public Color(String col)
  {
    c = col;
    gold=false;
    hold = new LinkedList<Color>();
  }

  public void setG()
  {
    gold = true;
  }

  public boolean holdsG()
  {
    return gold;
  }

  public String name()
  {
    return c;
  }

  public boolean contains(String q)
  {
    return hold.contains(q);
  }

  public void addColor(Color a){
    if(!hold.contains(a.name()))
      hold.add(a);
  }

  public void addColor(LinkedList<Color> a){
    Iterator<Color> it = a.iterator();

    while(it.hasNext())
      this.addColor(it.next());
  }

  public LinkedList<Color> below()
  {
    return hold;
  }


  public void removeDuplicates()
  {
    LinkedList<Color> out = new LinkedList<Color>();
    LinkedList<Color> in = hold;
    Iterator<Color> curr = in.iterator();
    Color check;

    while(!in.isEmpty())
      {  check = in.remove();
        out.add(check);

        while(in.remove(check));
      }

        hold = out;

          }





  public boolean equals(Color comp){

    return c.equals(comp.name());
  }

  public String toString()
  {
    String o = c + " can contain: ";
    Iterator<Color> it = hold.iterator();
    while(it.hasNext())
      {
        o = o + it.next().name() +", ";
      }

    o = o.substring(0, o.length()-2);

    return o;
  }

}
