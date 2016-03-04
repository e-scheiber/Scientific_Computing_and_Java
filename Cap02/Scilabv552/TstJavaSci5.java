import org.scilab.modules.javasci.Scilab;
import org.scilab.modules.types.ScilabType;
import org.scilab.modules.types.ScilabDouble;

public class  TstJavaSci5{
  public static void main(String[] args)  {
    try{
      Scilab sci=new Scilab();
      if(sci.open()){
        double[][] a={{1,1,1,1},{2,-1,2,-1},{1,2,-1,2},{2,1,4,1},{3,2,-2,2}};
        ScilabDouble sci_a=new ScilabDouble(a);
        sci.put("a",sci_a);
        double[][] b={{2},{1},{-1},{7},{-5}};
        ScilabDouble sci_b=new ScilabDouble(b);
        sci.put("b",sci_b);
        boolean error=sci.exec("[x,k]=linsolve(a,-b)");
        System.out.println("Operatia s-a terminat cu succes (true/false) : "+error);
        ScilabDouble sci_x=(ScilabDouble)sci.get("x");
        if(!sci_x.isEmpty()){
          double[][] x=sci_x.getRealPart();
          System.out.println("x:");
          for(int i=0;i<x.length;i++){
             for(int j=0;j<x[0].length;j++)
                System.out.print(x[i][j]+" ");
             System.out.println();
          }
        }          
        ScilabDouble sci_k=(ScilabDouble)sci.get("k");
        if(!sci_k.isEmpty()){
          double[][] k=sci_k.getRealPart();
          System.out.println("k:");
          for(int i=0;i<k.length;i++){
             for(int j=0;j<k[0].length;j++)
                System.out.print(k[i][j]+" ");
             System.out.println();
          }
        }         
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
