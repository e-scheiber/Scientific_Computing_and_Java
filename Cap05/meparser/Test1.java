import org.matheclipse.parser.client.eval.*;
public class Test1{
  public static void main(String[] args){
    try {
      double x=3,y=4;
      String s_expr="x^2+y^2";     
      IDoubleValue vx = new DoubleVariable(x);
      IDoubleValue vy = new DoubleVariable(y);
      DoubleEvaluator engine = new DoubleEvaluator();
      engine.defineVariable("x",vx);
      engine.defineVariable("y",vy);
      double rezultat = engine.evaluate(s_expr);
      System.out.println("Rezultat: "+rezultat);
    } 
    catch(Exception e) {
      System.out.println(e.getMessage());
    }

  }
}