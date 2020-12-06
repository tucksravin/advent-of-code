import java.util.*;
import java.io.*;

//template: put date and number here
public class BPReader{
  public static void main(String args[]){
      try (Scanner input = new Scanner(new File("input.txt"))) {

        String bp;
        int row;
        int seat;
        LinkedList<Integer> all = new LinkedList<Integer>();

        int currId;
        int highestId=0;

        while(input.hasNextLine())
        {
          bp = input.nextLine();
          seat=0;
          row=0;

          if(bp.substring(0,1).equals("B"))
            row=row+64;

          if(bp.substring(1,2).equals("B"))
            row=row+32;

          if(bp.substring(2,3).equals("B"))
            row=row+16;

          if(bp.substring(3,4).equals("B"))
            row=row+8;

          if(bp.substring(4,5).equals("B"))
            row=row+4;

          if(bp.substring(5,6).equals("B"))
            row=row+2;

          if(bp.substring(6,7).equals("B"))
            row=row+1;

          if(bp.substring(7,8).equals("R"))
            seat=seat+4;

          if(bp.substring(8,9).equals("R"))
            seat=seat+2;

          if(bp.substring(9,10).equals("R"))
            seat=seat+1;

            //System.out.println(row);
            //System.out.println(seat);
            currId=row*8+seat;
            all.add(currId);


          if(currId>highestId)
            highestId = currId;

        }
          int mySeatId=0;

        for(int i = highestId ; all.contains(i) ; i-- )
          {
            mySeatId=i-1;
          }

        System.out.println(mySeatId);


        //System.out.println(highestId);
  }
catch (IOException e) {
    e.printStackTrace();
}
}
}
