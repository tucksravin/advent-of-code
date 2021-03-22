import java.util.*;
import java.io.*;

//template: put date and number here
public class SeatMap{

  private ArrayList<ArrayList<Integer>> map;

  public SeatMap(){
    map = new ArrayList<ArrayList<Integer>>();
  }

  public SeatMap(ArrayList<ArrayList<Integer>> m)
    {
      map = m;
    }

  public void setSeat(boolean newRow, String letter)
  {
    int set=2;

    if(letter.equals("L"))
      set=-1;

    if(letter.equals("."))
      set=0;

    if(letter.equals("#"))
      set=1;


    if(newRow)
      {
        map.add(new ArrayList<Integer>());
      }

      map.get(map.size()-1).add(set);

  }

  public ArrayList<ArrayList<Integer>> musicalChairs()
  {
    ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();

    for(int i = 0; i<map.size() ; i++)
    {
      out.add(new ArrayList<Integer>());

      for(int j = 0 ; j<map.get(i).size(); j++)
      {
        if(map.get(i).get(j)==-1)
          out.get(i).add(fill(i,j));


        else if(map.get(i).get(j)==0)
          out.get(i).add(0);


        else if(map.get(i).get(j)==1)
          out.get(i).add(leave(i,j));

      }

    }

    return out;


  }

  public int fill(int row, int col)
  {
    ArrayList<Integer> seats = check(row, col);
    boolean space = true;

    for(int i = 0 ; i<seats.size() ; i++)
    {
      if(seats.get(i)==1)
        space = false;
    }

    if(space)
      return 1;

    return -1;
  }

  public int leave(int row, int col)
  {
    ArrayList<Integer> seats = check(row, col);
    int neighbors = 0;

    for(int i = 0 ; i<seats.size() ; i++)
    {
      if(seats.get(i)==1)
        neighbors++;
    }

    if(neighbors<5)
      return 1;

    return -1;
  }



  public int countPassengers()
  {
    int count = 0;

    for(int i = 0; i<map.size() ; i++)
    {
      for(int j = 0 ; j<map.get(i).size(); j++)
      {
        if(map.get(i).get(j)==1)
          count++;
      }

    }

    return count;


  }

  public boolean equals(SeatMap comp)
  {
    if(map.equals(comp.getMap()))
      return true;

    return false;
  }

public ArrayList<ArrayList<Integer>> getMap()
{
  return map;
}


  public String toString()
{
  String out = "";

  for(int i = 0; i<map.size() ; i++)
  {
    for(int j = 0 ; j<map.get(i).size(); j++)
    {
      if(map.get(i).get(j)==-1)
        out = out + "L";

      if(map.get(i).get(j)==0)
        out = out + ".";

      if(map.get(i).get(j)==1)
        out = out + "#";

      if(map.get(i).get(j)==2)
        out = out + "?";
    }
    out=out+"\n";
  }

  return out;
}

public ArrayList<Integer> check(int row, int col)
{
  ArrayList<Integer> seats = new ArrayList<Integer>();

      //NW

      int j = col-1;

      for(int i = row-1 ; i>-1&&j>-1 ; i--)
        {
              if(map.get(i).get(j)!=0)
                {
                  //System.out.println("NW: "+i+","+j+" is a "+map.get(i).get(j));
                  seats.add(map.get(i).get(j));
                  i=-1;
                  j=-1;
                }
            j--;
        }

        //NE

        j = col+1;

        for(int i = row-1 ; i>-1&&j<map.get(0).size() ; i--)
          {

                if(map.get(i).get(j)!=0)
                  {
                    //System.out.println("NE: "+i+","+j+" is a "+map.get(i).get(j));
                    seats.add(map.get(i).get(j));
                    i=-1;
                    j=map.get(0).size();
                  }

                  j++;

          }

          //SW
          j = col-1;

          for(int i = row+1 ; i<map.size()&&j>-1 ; i++)
            {

                  if(map.get(i).get(j)!=0)
                    {
                      //System.out.println("SW: "+i+","+j+" is a "+map.get(i).get(j));
                      seats.add(map.get(i).get(j));
                      i=map.size();
                      j=-1;
                    }
                j--;
            }

            //SE
            j = col+1 ;

            for(int i = row+1 ; i<map.size()&&j<map.get(0).size() ; i++)
              {
                    if(map.get(i).get(j)!=0)
                      {
                        //System.out.println("SE: "+i+","+j+" is a "+map.get(i).get(j));
                        seats.add(map.get(i).get(j));
                        i=map.size();
                        j=map.get(0).size();
                      }
                  j++;
              }

              //N
              for(int i = row-1 ; i>-1 ; i--)
                {

                  if(map.get(i).get(col)!=0)
                    {
                      //System.out.println("N: "+i+","+col+" is a "+map.get(i).get(col));
                      seats.add(map.get(i).get(col));
                        i=-1;
                    }
                  }

              //S
                for(int i = row+1 ; i<map.size() ; i++)
                  {
                    if(map.get(i).get(col)!=0)
                      {
                        //System.out.println("S: "+i+","+col+" is a "+map.get(i).get(col));
                        seats.add(map.get(i).get(col));
                        i=map.size();
                      }
                  }

              //E
                for( j = col-1 ; j>-1 ; j--)
                  {
                    if(map.get(row).get(j)!=0)
                      {
                        //System.out.println("E: "+row+","+j+" is a "+map.get(row).get(j));
                        seats.add(map.get(row).get(j));
                        j=-1;
                      }
                  }

              //W
                for( j = col+1 ; j<map.get(0).size() ; j++)
                  {
                    if(map.get(row).get(j)!=0)
                      {
                        //System.out.println("W: "+row+","+j+" is a "+map.get(row).get(j));
                        seats.add(map.get(row).get(j));
                        j=map.get(0).size();
                      }
                  }





      return seats;

}

}
