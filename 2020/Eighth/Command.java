import java.util.*;
import java.io.*;

public class Command{
  private boolean run;
  private String op;
  private int val;


  public Command(String operation, int value)
  {
    op = operation;
    val = value;
    run = false;
  }

  public String getOp()
  {
    return op;
  }

  public int getVal()
  {
    return val;
  }

  public boolean hasRun()
  {
    return run;
  }

  public boolean run(){
    if(run == true)
      return false;
    else
      run = true;

    return run;
  }

  public void reset(){
    run = false;
  }

  public boolean change(){

    if(op.equals("nop"))
    {
        op = "jmp";
        return true;
    }

    if(op.equals("jmp"))
    {
        op = "nop";
        return true;
    }

    else
    {
        return false;
    }


  }





  public String toString()
  {
    return op + " " + val;

  }
}
