package mathlib.client.ecalg;
import org.matheclipse.parser.client.eval.*; 
/** 
 * Extinderea clasei DataIn cu preluarea unor date
 * ca String-uri care sunt convertite in valori numerice
 * prin pachetul MathEclipse Parser
 */
public class MEParserDataIn extends DataIn{
  private DoubleEvaluator parser=null;
  private IDoubleValue v=null;
  private String expr; 
  
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
  
  /**
   *  Functia corespunzatoare membrului stang al ecuatiei fct(x)=0.
   */
  public double fct(double x){
     v.setValue(x);
     return parser.evaluate(expr);
  } 
}