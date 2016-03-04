import com.maplesoft.openmaple.*;
import com.maplesoft.externalcall.MapleException;
class Integrate{
  public static void main( String args[] ){
    try{
      String[] argsMaple={"java"};
      Engine engine=new Engine(argsMaple,new EngineCallBacksDefault(),null,null);
      Algebraic sol=engine.evaluate("evalc(int(ln(1+tan(x)),x=0..Pi/4));");
    }
    catch (MapleException e){
      System.out.println("MapleException : "+e.getMessage());
      return;
    }
  }
}
