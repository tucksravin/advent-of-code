import java.util.*;
import java.io.*;

//template: put date and number here
public class Ship{
  private int x;
  private int y;

  //0 = N, 1 = E, 2 = S, 3 = W
  private int f;

  public Ship()
  {
    x = 0;
    y = 0;
    f = 1;
  }

  public void order(String dir, int q)
  {
    if(dir.equals("N"))
      {
        y=y+q;

      }

    if(dir.equals("S"))
      {
        y=y-q;

      }

    if(dir.equals("E"))
      {
        x=x+q;

      }

    if(dir.equals("W"))
      {
        x=x-q;
      }

    if(dir.equals("F"))
      {
        if(f==0)
          y=y+q;

        if(f==2)
          y=y-q;

        if(f==1)
          x=x+q;

        if(f==3)
          x=x-q;

      }

    if(dir.equals("R"))
      {
        f = (f + q/90)%4;
      }

      if(dir.equals("L"))
        {
          f = ((f - q/90)%4+4)%4;
        }

      }

      public int x()
        {
          return x;
        }

      public int y()
        {
          return y;
        }

        public int f()
          {
            return f;
          }
  }
