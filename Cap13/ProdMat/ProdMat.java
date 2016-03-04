import com.amd.aparapi.Kernel;
import com.amd.aparapi.Range;

public class ProdMat{
  public static void main(String[] args) {
    final int m=3;
    final int n=4;
    final int p=5;
    final int[] a=initA(m,n);
    final int[] b=initB(n,p);
    final int[] c=new int[m*p];
    
    Kernel kernel = new Kernel(){
       @Override public void run() {
          int gidx = getGlobalId(0); 
          int gidy = getGlobalId(1);          
          int s=0;
          for(int k=0;k<n;k++)
            s+=a[gidx*n+k]*b[k*p+gidy];         
          c[gidx*p+gidy]=s;
       }
    };
    
    long inceput=System.currentTimeMillis();
    kernel.execute(Range.create2D(m,p));
    long sfarsit=System.currentTimeMillis();
    
    System.out.println("Execution mode=" + kernel.getExecutionMode());
    kernel.dispose();
    System.out.println("Durata : "+(sfarsit-inceput));
    
    System.out.println("Matricea produs : ");
    for (int i = 0; i < m; i++) {
      for(int j=0;j<p;j++)
        System.out.printf("%6d %1s", c[i*p+j]," ");
      System.out.printf("\n"); 
    }       
  }
  
  /*
     Transformarea unei matrice in vector
     prin juxtapunerea liniilor
  */
  private static int[] iMat2vect(int[][] mat){
    int rows=mat.length;
    int cols=mat[0].length;
    int[] v=new int[rows*cols];
    for(int i=0;i<rows;i++){
      for(int j=0;j<cols;j++){
        v[i*cols+j]=mat[i][j];
      }
    }
    return v;
  }
  
  /*
     Initializarea primei matrice A
  */
  private static int[] initA(int m,int n){
    int[][] mat=new int[m][n];
    int fact=1;
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
         mat[i][j]=fact*(j+1);
      }
      fact*=10;
    } 
    System.out.println("Matricea A :");
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++) System.out.print(mat[i][j]+" ");
      System.out.println();
    }   
    return iMat2vect(mat);     
  }

  /*
     Initializarea celei de a doua matrice B
  */
  private static int[] initB(int m,int n){
    int[][] mat=new int[m][n];
    int fact=1;
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
         mat[i][j]=(i+1)*(j+1);
      }
    } 
    System.out.println("Matricea B :");
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++) System.out.print(mat[i][j]+" ");
      System.out.println();
    }   
    return iMat2vect(mat); 
  }
}
