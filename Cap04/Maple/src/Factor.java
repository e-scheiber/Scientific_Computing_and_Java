import com.maplesoft.openmaple.*;
import com.maplesoft.externalcall.MapleException;
class Factor{
  public static void main( String args[] ){
    try{
      String[] argsMaple={"java"};
      Engine engine=new Engine(argsMaple,new EngineCallBacksDefault(),null,null);
      Algebraic sol=engine.evaluate("factor((x+y)^7-x^7-y^7);");
    }
    catch (MapleException e){
      System.out.println("MapleException : "+e.getMessage());
      return;
    }
  }
}
