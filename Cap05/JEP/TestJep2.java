import org.nfunk.jep.*;

class TestJep2{
  public static void main(String args[]){
    double x=Math.PI/3;
    double y=Math.PI/4;
    String s_exp="sin(x)+sin(y)";
    JEP parser=new JEP();
    parser.addStandardFunctions();
    parser.addStandardConstants();
    parser.addVariable("x",x);
    parser.addVariable("y",y);
    parser.parseExpression(s_exp);
    double rezultat=parser.getValue();
    System.out.println("Rezultat: "+rezultat);    
  }
}






