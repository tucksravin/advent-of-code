import java.util.*;
import java.io.*;

//template: put date and number here
public class WaypointShip{
  private int x;
  private int y;

  private int wx;
  private int wy;





  public WaypointShip()
  {
    x = 0;
    y = 0;
    wx = 10;
    wy = 1;
  }

  public void order(String dir, int q)
  {
    if(dir.equals("N"))
        wy=wy+q;



    if(dir.equals("S"))
        wy=wy-q;



    if(dir.equals("E"))
        wx=wx+q;



    if(dir.equals("W"))
        wx=wx-q;



    if(dir.equals("F"))
      {
        x=x+wx*q;
        y=y+wy*q;

      }

      int f;
      int o;

    if(dir.equals("R"))
      {
        f = (q/90)%4;
        while(f!=0)
        {
          o = wx;
          wx=wy;
          wy=-o;
          f--;
        }
      }

      if(dir.equals("L"))
        {
          f = q/90%4;

          while(f!=0)
          {
            o = wx;
            wx=-wy;
            wy=o;
            f--;
          }
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


        public int wx()
          {
            return wx;
          }

        public int wy()
          {
            return wy;
          }

  }
