import org.scilab.modules.javasci.Scilab;
import org.scilab.modules.types.ScilabType;
import org.scilab.modules.types.ScilabDouble;

public class  TstJavaSci2{
  public static void main(String[] args){
    try{
      Scilab sci=new Scilab();
      if(sci.open()){
        String[] s={"deff(\'y=fct(x)\',\'y=2.^x-x.*x\')","[x,y,info]=fsolve(-0.5,fct)"};
        sci.exec(s);
        ScilabDouble sci_x=(ScilabDouble)sci.get("x");
        ScilabDouble sci_y=(ScilabDouble)sci.get("y");
        ScilabDouble sci_info=(ScilabDouble)sci.get("info");
       
        double[][] x=sci_x.getRealPart();
        System.out.println("Solutia : "+x[0][0]);
        double[][] y=sci_y.getRealPart();
        System.out.println("Valoarea functiei in solutie : "+y[0][0]);
        double[][] info=sci_info.getRealPart();
        System.out.println("Indicatorul de raspuns : "+info[0][0]);
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
