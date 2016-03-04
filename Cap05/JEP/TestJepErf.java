import org.nfunk.jep.*;

class TestJepErf{
  public static void main(String args[]){
    double x=10;
    String s_exp="erf(x)";
    JEP parser=new JEP();
    parser.addStandardFunctions();
    parser.addStandardConstants();
    parser.addFunction("erf", new JepErf()); 
    parser.addVariable("x",x);
    parser.parseExpression(s_exp);
    double rezultat=parser.getValue();
    System.out.println("Rezultat: "+rezultat);    
  }
}