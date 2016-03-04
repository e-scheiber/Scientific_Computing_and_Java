import Jama.Matrix;
import Jama.EigenvalueDecomposition;
import java.text.NumberFormat;

public class ValoriPropri{
  public static void main(String args[]){
    double[][] a={{1,2,3,4},{2,3,4,1},{3,4,1,2},{4,1,2,3}};
    int n=a.length;   
    Matrix A=new Matrix(a);
    EigenvalueDecomposition ed=new EigenvalueDecomposition(A);
    double[] re=ed.getRealEigenvalues();
    double[] im=ed.getImagEigenvalues();
    for(int i=0;i<re.length;i++)
      System.out.printf("%12.8f +I* %12.8f\n",re[i],im[i]);
      //System.out.println(re[i]+" I* "+im[i]);
  }
}