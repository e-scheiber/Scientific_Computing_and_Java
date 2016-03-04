import org.nfunk.jep.*;

class TestJep1{
  public static void main(String args[]){
    double x=3,y=4;
    String s_exp="x^2+y^2";
    JEP parser=new JEP();
    parser.addVariable("x",x);
    parser.addVariable("y",y);
    parser.parseExpression(s_exp);
    double rezultat=parser.getValue();
    System.out.println("Rezultat: "+rezultat);
  }
}






