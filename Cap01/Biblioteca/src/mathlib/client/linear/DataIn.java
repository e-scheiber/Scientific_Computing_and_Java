package mathlib.client.linear;
import java.util.Vector;
import java.io.BufferedReader;
/**
 *  Clasa acoperitoare a datelor necesare rezolvarii
 *  unui sistem algebric de ecuatii liniare  
 */
public class DataIn{
  private double[][] matrix=null;   // matricea extinsa a sistemului
  
  /**
   * Fixeaza matricea extinsa a sistemului algebric.
   * @param matrix matricea extinsa a sistemului.
   */ 
  public void setMatrix(double[][] matrix){
    this.matrix=matrix;
  }
  /**
   * Fixeaza matricea extinsa a sistemului algebric.
   * @param br flux care furnizeaza matricea extinsa a sistemului;
   * datele sunt transmise pe linii.
   */ 
  public void setMatrix(BufferedReader br) throws Exception{
    Vector<Double> v=new Vector<Double>(10);
    try{
      String line; //,s;
      int m=0,n,mn;
      do{
        line=br.readLine();
        if(line!=null){
          //System.out.println(line);
          m++;
          String[] result=line.split(" ");
          n=result.length;
          for(String s :result)
            v.addElement(new Double(s));
        }
      }
      while(line!=null);
      if(v.size()>0){
        mn=v.size();
        n=mn/m;
        matrix=new double[m][n];
        for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
            matrix[i][j]=((Double)v.elementAt(i*n+j)).doubleValue();
            //System.out.print(matrix[i][j]+" ");
          }
          System.out.println();
        }
      }
    }
    catch(Exception e){
      throw new Exception(e.getMessage());
    }
  }
  /**
   *  Returneaza matricea sistemului.
   */
  public double[][] getMatrix(){
    return matrix;
  }
}