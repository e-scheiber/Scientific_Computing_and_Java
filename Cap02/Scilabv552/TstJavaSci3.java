import org.scilab.modules.javasci.Scilab;
import org.scilab.modules.types.ScilabType;
import org.scilab.modules.types.ScilabDouble;

public class  TstJavaSci3{
  public static void main(String[] args){
    try{
      Scilab sci=new Scilab();
      if(sci.open()){
        String fct="\'log(1+tan(x))\'";
        String var="\'x\'";
        String lowerBound="0";
        String upperBound="%pi/4";
        String scicomm="u=integrate("+fct+","+var+","+lowerBound+","+upperBound+")";
        boolean error=sci.exec(scicomm);
        System.out.println("Operatia s-a terminat cu succes (true/false) : "+error);
        ScilabDouble sci_u=(ScilabDouble)sci.get("u");
        double[][] u=sci_u.getRealPart();
        System.out.println("Integrala : "+u[0][0]);
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
