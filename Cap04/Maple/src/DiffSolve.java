import com.maplesoft.openmaple.*;
import com.maplesoft.externalcall.MapleException;
class DiffSolve{
  public static void main( String args[] ){
    try{
      String[] argsMaple={"java"};
      Engine engine=new Engine(argsMaple,new EngineCallBacksDefault(),null,null);
      Algebraic sol=engine.evaluate("dsolve({diff(y(x),x)+y(x)*tan(x)-1/cos(x)=0,y(0)=1},y(x));");
      //System.out.println(sol.toString());
    }
    catch (MapleException e){
      System.out.println("MapleException : "+e.getMessage());
      return;
    }
  }
}
