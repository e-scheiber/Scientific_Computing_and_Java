import org.junit.*;
import static org.junit.Assert.*;
import mathlib.client.linear.DataIn;
import mathlib.client.linear.DataOut;
import mathlib.client.linear.IRezolvitorScilab;
import mathlib.client.linear.impl.RezolvitorScilab;

public class  TestRezolvitorScilab{
  private DataOut dout;
  private double[] x0={-1.0,0.5,2.0,0.5};
  private double[][] k0={{0},{Math.sqrt(2)/2},{0},{-Math.sqrt(2)/2}};
  private double eps=1e-8;
  
  @Before
  public void initializare(){     
    double[][] a={{1,1,1,1},{2,-1,2,-1},{1,2,-1,2},{2,1,4,1},{3,2,-2,2}};
    double[] b={2,1,-1,7,-5};
    int m=b.length;
    int n=a[0].length;
    double[][] matrix=new double[m][n+1];
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){      
        matrix[i][j]=a[i][j];
      }
      matrix[i][n]=b[i];
    }
    DataIn din=new DataIn();
    din.setMatrix(matrix);
    IRezolvitorScilab obj=new RezolvitorScilab();
    dout=obj.rezolvitorScilab(din);
  }

  @Test
  public void test(){  
    assertTrue(dout.isCompatibil());
    double[]x= dout.getX();
    double[][]k=dout.getK();
    assertArrayEquals(x0,x,eps);
    if(k!=null){
      for(int i=0;i<k.length;i++){
        assertArrayEquals(k0[i],k[i],eps);
      }  
    }  
    //assertNull(k);
  }
  
  @After
  public void afisare(){
    System.out.println("Afisarea rezultatelor");
    System.out.println("Sistem compatibil : "+dout.isCompatibil());
    if(dout.isCompatibil()){
      double[]x= dout.getX();
      double[][]k=dout.getK();
      System.out.println("X=");
      for(int i=0;i<x.length;i++)
        System.out.println(x[i]);
      System.out.println("K=");
      if(k!=null){
        for(int i=0;i<k.length;i++){
          for(int j=0;j<k[0].length;j++)
            System.out.print(k[i][j]+" ");  
          System.out.println();
        }
      }
    } 
  }
  public static void main(String[] args){
    org.junit.runner.JUnitCore.main("TestRezolvitorScilab");
  }
}
