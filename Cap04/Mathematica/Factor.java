import com.wolfram.jlink.*;
public class Factor{
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
      String result=ml.evaluateToOutputForm("Factor[(x+y)^7-x^7-y^7]",0);
      System.out.println("Factor[(x+y)^7-x^7-y^7]");
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
