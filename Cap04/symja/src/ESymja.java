import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.interfaces.IExpr;

public class ESymja{
	public static void main(String[] args) {
    //Config.PARSER_USE_LOWERCASE_SYMBOLS = true;
		try {			
			ExprEvaluator util = new ExprEvaluator(false, 100);
      IExpr result=util.evaluate("Factor[(x+y)^7-x^7-y^7]");
      System.out.println(result.toString());
      
      result = util.evaluate("D[Sin[2 x] Cos[x],x]");
			System.out.println(result.toString());
      
      result = util.evaluate("D[ArcTan[x],{x,2}]");
			System.out.println(result.toString());
      
      result = util.evaluate("Integrate[1/(1+x^4),x]");
			System.out.println(result.toString());
      
      result = util.evaluate("Integrate[1/(1+x^2),{x,0,Infinity}]");
			System.out.println(result.toString());
		} 
    catch (Exception e) {
			e.printStackTrace();
		}
	}
}