/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package complexplot;
import org.nfunk.jep.type.Complex;
import org.nfunk.jep.*;

/**
 *
 * @author SCHEIBER
 */

public class DataIn {
  private double xm,ym,xM,yM;  
  private String var;
  private String expr;
  private int P=500;
  private int Q=500;

  JEP parser=null;
  
  public void setXm(double xm){
    this.xm=xm;
  }
  public void setYm(double ym){
    this.ym=ym;
  }
  public void setXM(double xM){
    this.xM=xM;
  }
  public void setYM(double yM){
    this.yM=yM;
  }
  /*
  public void setVar(String var){
    this.var=var;
  }
  public void setExpr(String expr){
    this.expr=expr;
  }
   */
  public double getXm(){
    return xm;
  }
  public double getYm(){
    return ym;
  }
  public double getXM(){
    return xM;
  }
  public double getYM(){
    return yM;
  }
  
  public String getVar(){
    return var;
  }
  public String getExpr(){
    return expr;
  }

  public void setP(int P){
    this.P=P;
  }

  public int getP(){
    return P;
  }

  public void setQ(int Q){
    this.Q=Q;
  }

  public int getQ(){
    return Q;
  }

  DataIn(String var,String expr){
    this.var=var;
    this.expr=expr;
    parser=new JEP();
    parser.addStandardFunctions();
    parser.addStandardConstants();
    parser.addComplex();
    parser.addVariable(var,0,0);
    parser.parseExpression(expr);
  }
  
  public Complex fct(double x,double y){
     parser.addVariable(var,x,y);
     return parser.getComplexValue();
  }
}
