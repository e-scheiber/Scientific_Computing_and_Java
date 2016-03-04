import Jama.Matrix;
import java.text.NumberFormat;

public class SistemLiniar{
  public static void main(String args[]){
    double[][] a={{1,2,3,4},{2,3,4,1},{3,4,1,2},{4,1,2,3}};
    double[] b={11,12,13,14};
    int n=a.length; 
    
    Matrix A=new Matrix(a);
    Matrix B=new Matrix(b,n);
    Matrix X=A.solve(B);  
    System.out.println("Solutia");
    X.print(NumberFormat.getNumberInstance(),10);
  }
}