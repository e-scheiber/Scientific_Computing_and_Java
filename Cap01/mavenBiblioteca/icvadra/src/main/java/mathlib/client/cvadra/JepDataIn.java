package mathlib.client.cvadra;
import org.nfunk.jep.*; 
/** 
 * Extinderea clasei DataIn cu preluarea unor date
 * ca String-uri care sunt convertite in valori numerice
 * prin pachetul JEP (Java Expression Parser).
 */
public class JepDataIn extends DataIn{
  private JEP parser=null;
  private String var; 
  
  /**
   *  Fixeaza extremitatea inferioara a intervalului de integrare
   *  @param expr Expresia de calcul a extremitatii inferioare.
   */  
  public void setA(String expr){
    JEP aParser=new JEP();
    aParser.addStandardFunctions();
    aParser.addStandardConstants();
    aParser.parseExpression(expr);
    //a=aParser.getValue();
    super.setA(aParser.getValue());
  }
  
  /**
   *  Fixeaza extremitatea superiora a intervalului de integrare
   *  @param expr Expresia de calcul a extremitatii superioare.
   */ 
  public void setB(String expr){
    JEP bParser=new JEP();
    bParser.addStandardFunctions();
    bParser.addStandardConstants();
    bParser.parseExpression(expr);
    //b=bParser.getValue();
    super.setB(bParser.getValue());
  }
  
  /**
   *  Functia integrata.
   */
  public double fct(double x){
     parser.addVariable(var,x);
     return parser.getValue();
  } 
  
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
}