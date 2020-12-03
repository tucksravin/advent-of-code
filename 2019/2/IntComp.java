import java.util.*;
import java.io.*;

//runs intcode
public class IntComp{

  private ArrayList<Integer> rec;

      public IntComp(ArrayList<Integer> receive){
        rec = receive;
      }

      public int run(int pos){

      boolean run = true;
      while(run){
          if(rec.get(pos)==1){
            rec.set(rec.get(pos+3),rec.get(rec.get(pos+1))+rec.get(rec.get(pos+2)));;
            pos=pos+4;
          }
          else if(rec.get(pos)==2){
            rec.set(rec.get(pos+3),rec.get(rec.get(pos+1))*rec.get(rec.get(pos+2)));
            pos=pos+4;
          }
          else if(rec.get(pos)==99){
            return rec.get(0);
          }

          else{
            System.out.println("error, did not receive opcode");
            run = false;
          }
      }
      return -1;
  }
}
