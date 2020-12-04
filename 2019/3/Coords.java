import java.util.*;
import java.io.*;

public class Coords{
  private int xcoord;
  private int ycoord;

  public Coords(int xc, int yc){
    xcoord = xc;
    ycoord = yc;
  }

  public Coords()
  {
    xcoord=0;
    ycoord=0;
  }

  public int x()
  {
    return xcoord;
  }

  public int y(){
    return ycoord;
  }

  public boolean equals(Coords comp)
  {
    if(comp.x()==xcoord&&comp.y()==ycoord)
      return true;
    else
      return false;
  }

  public String toString()
  {
    return xcoord + " , " + ycoord;
  }
}
