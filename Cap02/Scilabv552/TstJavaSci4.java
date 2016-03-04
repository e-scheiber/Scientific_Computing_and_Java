import org.scilab.modules.javasci.Scilab;
import org.scilab.modules.types.ScilabType;
import org.scilab.modules.types.ScilabDouble;

public class  TstJavaSci4{
  public static void main(String[] args)  {
    try{
      Scilab sci=new Scilab();
      if(sci.open()){
        double[][] re={{1},{1}};
        double[][] im={{2,},{-1}};
        ScilabDouble sci_z=new ScilabDouble(re,im);
        sci.put("z",sci_z); 
        sci.exec("w=z(1)*z(2)");
        ScilabDouble sci_w=(ScilabDouble)sci.get("w");
        double[][] w_re=sci_w.getRealPart();
        double[][] w_im=sci_w.getImaginaryPart();
        System.out.println(w_re[0][0]+" I* "+w_im[0][0]);
        
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
