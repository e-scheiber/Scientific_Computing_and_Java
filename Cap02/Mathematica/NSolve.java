import com.wolfram.jlink.*;
public class NSolve{
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
      ml.evaluate("NSolve[2^x-x^2==0,x]");
      ml.waitForAnswer();
      Expr result=ml.getExpr();
      System.out.println(result.toString());
      
      //String result=ml.evaluateToOutputForm("NSolve[2^x-x^2==0,x]",0);
      //System.out.println(result);
    }  
    catch(Exception e){
      System.out.println("MathLinkException : "+e.getMessage());
    }
    finally{
      ml.close();
    }
  }
}
