import com.amd.aparapi.Kernel;
import com.amd.aparapi.Range;

public class JacobiAsync{
  public static void main(String[] _args) {
    final float[] a=initA();
    final float[] b=initB();
    final int n=b.length;
    // Afisarea datelor sistemului
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++) System.out.print(a[i*n+j]+" ");
      System.out.println(" <-> "+b[i]);
    } 
    
    final float[] x=new float[n];
    final float[] y=new float[n];
    final float[] errors=new float[n];
    float tol=1e-5f,nrm=0.0f;
    int nmi=50;
      
    Kernel kernel = new Kernel(){   
      @Override public void run() {
        int gid = getGlobalId();
        for(int i=0;i<n;i++)x[i]=y[i];
        float s=0;
        for(int i=0;i<n;i++){
          if(i!=gid) s+=a[gid*n+i]*x[i];
        }  
        y[gid]=(b[gid]-s)/a[gid*n+gid];
        errors[gid]=Math.abs(y[gid]-x[gid]);
      }
    };

    // Aproximatia initiala
    for(int i=0;i<n;i++) y[i]=0.0f;
    long inceput=System.currentTimeMillis();
    kernel.execute(Range.create(n),nmi);
    long sfarsit=System.currentTimeMillis();  
    System.out.println("Execution mode=" + kernel.getExecutionMode());
    kernel.dispose();    
    System.out.println("Durata : "+(sfarsit-inceput));
    
    System.out.println("Solutia :");
    for (int i = 0; i < n; i++) {
       System.out.printf("%10.4f\n", y[i]);
    }  
    for(int i=0;i<n;i++)nrm=Math.max(nrm,errors[i]);
    int ind=0;
    if(nrm>=tol) ind=1;
    System.out.println("Indicatorul de raspuns : "+ind);
  }
  
  /*
  private static float mymax(float[] v){
    float m=v[0];
    for(int i=0;i<v.length;i++) m=Math.max(m,v[i]);
    return m;
  }   
  */
  
  
  /*
     Transformarea unei matrice in vector
     prin juxtapunerea liniilor
  */
  private static float[] fMat2vect(float[][] mat){
    int rows=mat.length;
    int cols=mat[0].length;
    float[] v=new float[rows*cols];
    for(int i=0;i<rows;i++){
      for(int j=0;j<cols;j++){
        v[i*cols+j]=mat[i][j];
      }
    }
    return v;
  }
  
  /*
     Initializarea matricei A
  */
  private static float[] initA(){
    float[][] mat={{9,-1,3,1,3},{2,-8,0,1,3},{-2,2,7,1,1},{4,-1,-1,9,2},{-1,-3,0,2,6}};   
    int n=mat.length;
    return fMat2vect(mat);     
  }
  
  /*
     Initializarea vectorului b
  */
  private static float[] initB(){
    float[] mat={-5,-15,16,20,1};
    return mat;
  }
}
