package mathlib.client.linear.impl;
import org.scilab.modules.javasci.Scilab;
import org.scilab.modules.types.ScilabType;
import org.scilab.modules.types.ScilabDouble;
import mathlib.client.linear.DataIn;
import mathlib.client.linear.DataOut;
import mathlib.client.linear.IRezolvitorScilab;

/** 
 * Implementarea rezolvarii unui sistem algebric de ecuatii
 * liniare prin apelarea functiei linsolve din Scilab
 */
public class RezolvitorScilab implements IRezolvitorScilab{ 
  /**
   * Metoda de rezolvare a sistemului algebric de ecuatii liniare.
   */
  public DataOut rezolvitorScilab(DataIn din){
    DataOut dout=new DataOut();
    double[][] matrix=din.getMatrix();
    int l=matrix.length;
    int c=matrix[0].length;
    double[][] a=new double[l][c-1];
    double[][] b=new double[l][1];
    for(int i=0;i<l;i++){
      for(int j=0;j<c-1;j++)
        a[i][j]=matrix[i][j];
      b[i][0]=matrix[i][c-1];
    }
    try{
      Scilab sci=new Scilab();
      if(sci.open()){
        ScilabDouble sci_a=new ScilabDouble(a);
        sci.put("a",sci_a);
        ScilabDouble sci_b=new ScilabDouble(b);
        sci.put("b",sci_b);
        boolean error=sci.exec("[x,k]=linsolve(a,-b)");
        System.out.println("Success flag (true/false) : "+error);
        ScilabDouble sci_x=(ScilabDouble)sci.get("x");
        if(!sci_x.isEmpty()){
          double[][] x=sci_x.getRealPart();
          double[] x1=new double[x.length];
          for(int i=0;i<x.length;i++)
            x1[i]=x[i][0];
          dout.setX(x1);
        }     
        ScilabDouble sci_k=(ScilabDouble)sci.get("k");
        if(!sci_k.isEmpty()){
          double[][] k=sci_k.getRealPart();
          dout.setK(k);
        }  
        if(sci_x.getRealPart().length==0)
          dout.setCompatibil(false);  
        else
          dout.setCompatibil(true);              
        sci.close();  
      }
      else{
        System.out.println("Could not start Scilab ");
      }
    } 
    catch(org.scilab.modules.javasci.JavasciException e) {
      System.err.println("An exception occured: " + e.getLocalizedMessage());
    }
    return dout; 
  }
}
