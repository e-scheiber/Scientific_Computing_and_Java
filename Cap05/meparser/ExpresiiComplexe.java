import org.matheclipse.parser.client.eval.*;
import org.matheclipse.parser.client.math.*;
public class ExpresiiComplexe{
  
  public static void main(String[] args){
    try {
      Complex z=new Complex(1,3);
      System.out.print("z=");
      System.out.println(ComplexEvaluator.toString(z));
      
      System.out.println("Conjugatul");
      Complex w=z.conjugate();
      System.out.println(ComplexEvaluator.toString(w));
      
      System.out.println("Suma");
      System.out.println(ComplexEvaluator.toString(z.add(w)));
      
      System.out.println("Produsul");
      System.out.println(ComplexEvaluator.toString(z.multiply(w)));
      
      System.out.println("Catul");
      System.out.println(ComplexEvaluator.toString(z.divide(w)));
      
      System.out.println("Modulul");
      System.out.println(z.abs());
      
      System.out.println("\nFunctii complexe");
      System.out.println("sin(z)");
      System.out.println(ComplexEvaluator.toString(z.sin()));
      
      System.out.println("cos(z)");
      System.out.println(ComplexEvaluator.toString(z.cos()));    
        
      System.out.println("tan(z)");
      System.out.println(ComplexEvaluator.toString(z.tan()));
      
      System.out.println("sinh(z)");
      Complex u=z.sinh();
      System.out.println(ComplexEvaluator.toString(u));
      
      System.out.println("cosh(z)");
      Complex v=z.cosh();
      System.out.println(ComplexEvaluator.toString(v)); 
           
      System.out.println("tanh(z)");
      System.out.println(ComplexEvaluator.toString(z.tanh()));
      
      System.out.println("\nEvaluarea expresiilor complexe");
      System.out.println("cosh^2(z)-sinh^2(z)");
      ComplexVariable cu = new ComplexVariable(u);
      ComplexVariable cv = new ComplexVariable(v);
      ComplexEvaluator engine = new ComplexEvaluator();
      String expr="v^2-u^2";
      engine.defineVariable("u",cu);
      engine.defineVariable("v",cv);
      Complex r=engine.evaluate(expr);
      System.out.println(ComplexEvaluator.toString(r));
    }
    catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
}