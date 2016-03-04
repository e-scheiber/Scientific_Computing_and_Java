import com.maplesoft.openmaple.*;
import com.maplesoft.externalcall.MapleException;
class Solve{
  public static void main( String args[] ){
    try{
      String[] argsMaple={"java"};
      Engine engine=new Engine(argsMaple,new EngineCallBacksDefault(),null,null);
      //Algebraic a=engine.evaluate("solve(2^x-x^2,x,x=-infinity..0);");
      Algebraic sol=engine.evaluate("u:=[evalf(solve(2^x-x^2,x))];");
      Algebraic an=engine.evaluate("nops(u);");
      int n=(new Integer(an.toString())).intValue();
      double[] x=new double[n];
      for(int i=1;i<=n;i++){
        Algebraic ax=engine.evaluate("u["+i+"];");
        x[i-1]=(new Double(ax.toString())).doubleValue();
      }
      System.out.println("Solutiile obtinute");
      for(int i=0;i<n;i++)
        System.out.println("x["+(i+1)+"] = "+x[i]);
    }
    catch (MapleException e){
      System.out.println("MapleException : "+e.getMessage());
      return;
    }
  }
}
