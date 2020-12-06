import java.util.*;
import java.io.*;

//template: put date and number here
public class crossesForTime{
  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("input.txt"))) {

        String o = input.nextLine();
        String t = input.nextLine();

        Scanner lineOne = new Scanner(o);
        Scanner lineTwo = new Scanner(t);

        LinkedList<Coords> wireOne = new LinkedList<Coords>();
        LinkedList<Coords> wireTwo = new LinkedList<Coords>();

        lineOne.useDelimiter(",");
        lineTwo.useDelimiter(",");

        int xc = 0;
        int yc = 0;
        int dist = 0;
        String comm;

        while(lineOne.hasNext())
        {
          comm = lineOne.next();

          dist = Integer.parseInt(comm.substring(1));

          if(comm.substring(0,1).equals("L"))
            {

                xc=xc-dist;
                wireOne.add(new Coords(xc,yc));

            }

            if(comm.substring(0,1).equals("R"))
              {
                  xc=xc+dist;
                  wireOne.add(new Coords(xc,yc));
              }

            if(comm.substring(0,1).equals("U"))
              {
                  yc=yc+dist;
                  wireOne.add(new Coords(xc,yc));
              }

            if(comm.substring(0,1).equals("D"))
              {
                  yc=yc-dist;
                  wireOne.add(new Coords(xc,yc));
                }
              }


        xc = 0;
        yc = 0;


        while(lineTwo.hasNext())
        {
          comm = lineTwo.next();

          dist = Integer.parseInt(comm.substring(1));

          if(comm.substring(0,1).equals("L"))
            {

                xc=xc-dist;
                wireTwo.add(new Coords(xc,yc));

            }

            if(comm.substring(0,1).equals("R"))
              {
                  xc=xc+dist;
                  wireTwo.add(new Coords(xc,yc));
              }

            if(comm.substring(0,1).equals("U"))
              {
                  yc=yc+dist;
                  wireTwo.add(new Coords(xc,yc));

              }

            if(comm.substring(0,1).equals("D"))
              {

                  yc=yc-dist;
                  wireTwo.add(new Coords(xc,yc));

              }
        }

        Iterator<Coords> witOne = wireOne.iterator();
        Iterator<Coords> witTwo = wireTwo.iterator();

        LinkedList<Coords> meetings = new LinkedList<Coords>();

        Coords originOld = new Coords();
        Coords originNow = witOne.next();
        Coords compOld = new Coords();
        Coords compNow = witTwo.next();

        while(witOne.hasNext()){
          originOld = originNow;
          originNow = witOne.next();

          witTwo = wireTwo.iterator();
          compNow = witTwo.next();

          if(originOld.x()==originNow.x())
          {
            xc = originOld.x();

            while(witTwo.hasNext()){
                compOld = compNow;
                compNow = witTwo.next();
                yc = compNow.y();

                if(((xc>compOld.x()&&xc<compNow.x())||(xc<compOld.x()&&xc>compNow.x()))&&(((yc<originOld.y())&&(yc>originNow.y()))||((yc>originOld.y())&&(yc<originNow.y())))){
                //  System.out.println("  Match!");
                  meetings.add(new Coords(xc,yc));
            }
          }
          }
          else
          {
            yc = originOld.y();

            while(witTwo.hasNext()){
                compOld = compNow;
                compNow = witTwo.next();
                xc = compNow.x();

                if(((xc>originOld.x()&&xc<originNow.x())||(xc<originOld.x()&&xc>originNow.x()))&&(((yc<compOld.y())&&(yc>compNow.y()))||((yc>compOld.y())&&(yc<compNow.y())))){
                //  System.out.println("  Match!");
                  meetings.add(new Coords(xc,yc));
            }
          }
          }


      }

        Iterator<Coords> crosses = meetings.iterator();


        //while(crosses.hasNext())
        //{
          //System.out.println(crosses.next().toString());
        //}



        //build full description of each then find i: count distance


        lineOne = new Scanner(o);
        lineTwo = new Scanner(t);
        lineOne.useDelimiter(",");
        lineTwo.useDelimiter(",");
        xc=0;
        yc=0;

        LinkedList<Coords> fullWireOne = new LinkedList<Coords>();
        LinkedList<Coords> fullWireTwo = new LinkedList<Coords>();

        while(lineOne.hasNext())
        {
          comm = lineOne.next();

          dist = Integer.parseInt(comm.substring(1));

          if(comm.substring(0,1).equals("L"))
            {
              while(dist>0){

                xc=xc-1;
                fullWireOne.add(new Coords(xc,yc));
                dist--;
                }

            }

            if(comm.substring(0,1).equals("R"))
              {
                while(dist>0){

                  xc=xc+1;
                  fullWireOne.add(new Coords(xc,yc));
                  dist--;
                }
                }


            if(comm.substring(0,1).equals("U"))
              {
                  while(dist>0){
                  yc=yc+1;
                  fullWireOne.add(new Coords(xc,yc));
                  dist--;;
                }
              }

            if(comm.substring(0,1).equals("D"))
              {
                while(dist>0){
                  yc=yc-1;
                  fullWireOne.add(new Coords(xc,yc));
                  dist--;
                }
                }
              }

        xc = 0;
        yc = 0;


        while(lineTwo.hasNext())
        {
          comm = lineTwo.next();

          dist = Integer.parseInt(comm.substring(1));

          if(comm.substring(0,1).equals("L"))
            {
              while(dist>0){

                xc=xc-1;
                fullWireTwo.add(new Coords(xc,yc));
                dist--;
                }

            }

            if(comm.substring(0,1).equals("R"))
              {
                while(dist>0){

                  xc=xc+1;
                  fullWireTwo.add(new Coords(xc,yc));
                  dist--;
                }
                }


            if(comm.substring(0,1).equals("U"))
              {
                  while(dist>0){
                  yc=yc+1;
                  fullWireTwo.add(new Coords(xc,yc));
                  dist--;;
                }
              }

            if(comm.substring(0,1).equals("D"))
              {
                while(dist>0){
                  yc=yc-1;
                  fullWireTwo.add(new Coords(xc,yc));
                  dist--;
                }
                }
              }

              crosses = meetings.iterator();

              Coords cross = crosses.next();
              int currSpeed;
              int fastestSpeed=-1;


              while(crosses.hasNext()){

                currSpeed = checkList(cross, fullWireOne) + checkList(cross, fullWireTwo);

                //System.out.println(cross.toString());
                if(currSpeed<fastestSpeed||fastestSpeed==-1)
                {
                  fastestSpeed = currSpeed;
                  System.out.println("new record: "+fastestSpeed);
                }

                cross = crosses.next();

              }





        }


catch (IOException e) {
    e.printStackTrace();
}
}

public static boolean between(int x, int a, int b){
  if((x<=a&&x>=b)||(x<=b&&x>=a))
    return true;
  else
    return false;
}

public static int checkList(Coords a, LinkedList<Coords> b)
{
  Iterator<Coords> it = b.iterator();

  int i = 0;

  while(it.hasNext())
  {
    i++;
    if(it.next().equals(a))
      return i;
  }

  //System.out.println(i);

  return -1;
}

}
