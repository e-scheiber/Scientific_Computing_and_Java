import com.maplesoft.openmaple.*;
import com.maplesoft.externalcall.MapleException;
class Integrate{
  public static void main( String args[] ){
    try{
      String[] argsMaple={"java"};
      Engine engine=new Engine(argsMaple,new EngineCallBacksDefault(),null,null);
      
      Algebraic sol=engine.evaluate("u:=[Re(evalf(integrate(log(1+tan(x)),x=0..Pi/4)))];");
      Algebraic an=engine.evaluate("nops(u);");
      int n=(new Integer(an.toString())).intValue();
      double[] x=new double[n];
      for(int i=1;i<=n;i++){
        Algebraic ax=engine.evaluate("u["+i+"];");
        x[i-1]=(new Double(ax.toString())).doubleValue();
      }
      System.out.println("Integrala : "+x[0]);
    }
    catch (MapleException e){
      System.out.println("MapleException : "+e.getMessage());
      return;
    }
  }
}
