import Jama.Matrix;
import Jama.LUDecomposition;
import java.text.NumberFormat;

public class LUfact{
  public static void main(String args[]){
    double [][] a={{1,2,-1,3,2},{2,4,-2,5,1},{-1,-2,1,-3,-4},{3,6,2,10,7},{1,2,4,0,4}};
    int n=a.length; 
    
    Matrix l,u,p,v;
    int [] piv;
    Matrix m=new Matrix(a);
    //m.print(NumberFormat.getNumberInstance(),2);
    LUDecomposition lu=m.lu();
    l=lu.getL();
    u=lu.getU();
    piv=lu.getPivot();
    //DecimalFormat f=new DecimalFormat("0.0000E0"); 
    System.out.println("Matricea L");
    l.print(NumberFormat.getNumberInstance(),10);
    System.out.println("Matricea U");
    u.print(NumberFormat.getNumberInstance(),10);
    System.out.println("Matricea P");
    p=new Matrix(n,n);
    for(int i=0;i<n;i++)
      p.set(i,piv[i],1);
    p.print(NumberFormat.getNumberInstance(),10);
    
    System.out.println("Verificare : P A - L U = 0 (?)");
    v=new Matrix(n,n);
    v=p.times(m).minus(l.times(u));
    v.print(NumberFormat.getNumberInstance(),10);
  }
}