import java.util.*;
import java.io.*;

//template: put date and number here
public class crosses{
  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("input.txt"))) {

        Scanner lineOne = new Scanner(input.nextLine());
        Scanner lineTwo = new Scanner(input.nextLine());

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


        while(crosses.hasNext())
        {
          System.out.println(crosses.next().toString());
        }

        crosses = meetings.iterator();

        Coords current = crosses.next();


        int a = Math.abs(current.x()) + Math.abs(current.y());
        int smallest = a;

        while(crosses.hasNext()){
          current = crosses.next();
           a = Math.abs(current.x())+ Math.abs(current.y());
           if(a<smallest)
             {smallest=a;
             System.out.println("new small "+ smallest);}
        }

        System.out.println(smallest);

        System.out.println("done");


  }
catch (IOException e) {
    e.printStackTrace();
}
}

}
