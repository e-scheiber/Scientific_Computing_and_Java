import com.wolfram.jlink.*;
public class DiffSolve{
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
      String result=ml.evaluateToOutputForm("DSolve[{y'[x]+y[x] Tan[x]==1/Cos[x],y[0]==1},y[x],x]",0);
      System.out.println("y'[x]+y[x] Tan[x]==1/Cos[x],y[0]==1");
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
