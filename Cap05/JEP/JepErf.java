import java.util.*;
import org.nfunk.jep.*;
import org.nfunk.jep.function.*;
import org.apache.commons.math3.special.*;

class JepErf extends PostfixMathCommand {
  public JepErf() {
    numberOfParameters = 1;
  }
  
  public void run(Stack inStack) throws ParseException{
    checkStack(inStack);
    Object param = inStack.pop();
    if (param instanceof Double){
      try{
        double r=0,x=((Double)param).doubleValue();
        if(Math.abs(x)<26)
          r = Erf.erf(x);
        else{
          if(x>0)
            r=1;
          else
            r=-1;
        }
        inStack.push(new Double(r));
      }
      catch(Exception e){
        throw new ParseException(e.getMessage());
      }
    }
    else{
      throw new ParseException("Invalid parameter type");
    }
  }
}