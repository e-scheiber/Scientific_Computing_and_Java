import org.scilab.modules.javasci.Scilab;
import org.scilab.modules.types.ScilabType;
import org.scilab.modules.types.ScilabDouble;

public class  TstJavaSci1{
  public static void main(String[] args){
    try{
      Scilab sci=new Scilab();
      if(sci.open()){
       
        sci.exec(new String[]{"u=1","v=u+1","disp(v)"});
        
        sci.close();
      }
      else{
        System.out.println("Could not start Scilab ");
      }
    } 
    catch(org.scilab.modules.javasci.JavasciException e) {
      System.err.println("An exception occured: " + e.getLocalizedMessage());
    }
  }
}
