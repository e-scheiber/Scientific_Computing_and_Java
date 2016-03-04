import com.wolfram.jlink.*;
public class Solve{
  public static void main(String[] args){
    KernelLink ml=null;
    try{
      String[] mlArgs = {"-linkmode", "launch", "-linkname", args[0]};
      ml = MathLinkFactory.createKernelLink(mlArgs);
    }
    catch(MathLinkException e){
      System.out.println("Fatal opening link error : "+e.getMessage());
      System.exit(1);
    }
    try{
      ml.discardAnswer(); //f. important
      String result=ml.evaluateToOutputForm("Solve[x^2-2^x==0,x]",0);
      System.out.println("x^2-2^x==0");
      System.out.println(result);
    }  
    catch(Exception e){
      System.out.println("MathLinkException : "+e.getMessage());
    }
    finally{
      ml.close();
    }
  }
}
