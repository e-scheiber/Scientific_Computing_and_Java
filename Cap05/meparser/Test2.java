import org.matheclipse.parser.client.eval.*;
public class Test2{
  public static void main(String[] args){
    try {
      /*
      double x=Math.PI/3;
      double y=Math.PI/4;
      String s_expr="Sin[x]+Sin[y]"; 
      */
      String s_expr="Sin[Pi/3]+Sin[Pi/4]";
      //IDoubleValue vx = new DoubleVariable(x);
      //IDoubleValue vy = new DoubleVariable(y);
      DoubleEvaluator engine = new DoubleEvaluator();
      //engine.defineVariable("x",vx);
      //engine.defineVariable("y",vy);
      double rezultat = engine.evaluate(s_expr);
      System.out.println("Rezultat: "+rezultat);
      /*
      vx.setValue(1);
      s_expr="Exp[x]";
      rezultat = engine.evaluate(s_expr);
      System.out.println("Rezultat: "+rezultat);
      s_expr="Log[x]";
      rezultat = engine.evaluate(s_expr);
      System.out.println("Rezultat: "+rezultat);
      s_expr="ArcSin[x]";
      rezultat = engine.evaluate(s_expr);
      System.out.println("Rezultat: "+rezultat);
      s_expr="Tan[x]";
      rezultat = engine.evaluate(s_expr);
      System.out.println("Rezultat: "+rezultat);
      vx.setValue(Math.E);
      s_expr="Log[x]";
      rezultat = engine.evaluate(s_expr);
      System.out.println("Rezultat: "+rezultat);
      */
    } 
    catch(Exception e) {
      System.out.println(e.getMessage());
    }

  }
}