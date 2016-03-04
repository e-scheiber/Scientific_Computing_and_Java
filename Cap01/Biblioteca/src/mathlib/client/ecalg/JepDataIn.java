package mathlib.client.ecalg;
import org.nfunk.jep.*;
/** 
 * Extinderea clasei DataIn cu preluarea unor date
 * ca String-uri care sunt convertite in valori numerice
 * prin pachetul JEP (Java Expression Parser)
 */
public class JepDataIn extends DataIn{
  private JEP parser=null;
  private String var;

  /**
   * Constructorul clasei care instantiaza si calibreaza
   * obiectul JEP utilizat la pentru evaluarea functiei.
   * @param var Simbolul variabilei.
   * @param expr Extresia functiei. 
   */
  public JepDataIn(String var,String expr){
    this.var=var;
    parser=new JEP();
    parser.addStandardFunctions();
    parser.addStandardConstants();
    parser.addVariable(var,0);
    parser.parseExpression(expr);
  }
  
  /**
   *  Functia corespunzatoare membrului stang al ecuatiei fct(x)=0.
   */
  public double fct(double x){
     parser.addVariable(var,x);
     return parser.getValue();
  }
}
