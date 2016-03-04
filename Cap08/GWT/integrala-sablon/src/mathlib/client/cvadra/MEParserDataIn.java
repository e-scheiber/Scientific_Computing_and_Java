package mathlib.client.cvadra;
import org.matheclipse.parser.client.eval.*; 
/** 
 * Extinderea clasei DataIn cu preluarea unor date
 * ca String-uri care sunt convertite in valori numerice
 * prin pachetul MathEclipse Parser.
 */
public class MEParserDataIn extends DataIn{
  private DoubleEvaluator parser=null;
  private IDoubleValue v=null;
  private String expr; 
  
  /**
   *  Fixeaza extremitatea inferioara a intervalului de integrare.
   */ 
  public void setA(String expr){
    DoubleEvaluator aParser=new DoubleEvaluator();
    super.setA(aParser.evaluate(expr));
  }
  
  /**
   *  Fixeaza extremitatea superiora a intervalului de integrare.
   */
  public void setB(String expr){
    DoubleEvaluator bParser=new DoubleEvaluator();
    super.setB(bParser.evaluate(expr));
  }
  
  /**
   *  Functia integrata.
   */
  public double fct(double x){
     v.setValue(x);
     return parser.evaluate(expr);
  } 
  
  /**
   * Constructorul clasei care instantiaza si calibreaza
   * obiectul MathEclipse Parser utilizat la pentru evaluarea functiei.
   * @param var Simbolul variabilei.
   * @param expr Extresia functiei. 
   */
  public MEParserDataIn(String var,String expr){
    this.expr=expr;
    parser=new DoubleEvaluator();
    v=new DoubleVariable(0.0);
    parser.defineVariable(var,v);
  } 
}