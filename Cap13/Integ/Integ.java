import com.amd.aparapi.Kernel;
import com.amd.aparapi.Range;

public class Integ{     
  public static void main(String[] _args) {
    final int size=16;
    final float[] data={0.0f, 0.25f*(float)Math.PI};
    final float[] partial=new float[size];
      
    Kernel kernel = new Kernel(){   
      /*
        Definirea functiei de integrat
      */ 
      float fct(float x){
        //return 5*x*x*x*x;
        return log(1+tan(x));
      }
      
      /*
        Formula trapezelor aplicata functiei fct
        in intervalul [a,b] cu parametrul de discretizare m
      */
      float trapeze(float a,float b,int m){ 
        float s=0,h=(b-a)/m;   
        for(int i=1;i<m;i++) s+=fct(a+i*h);
        return 0.5f*h*(fct(a)+2*s+fct(b));   
      }
      
      @Override 
      public void run() {
        int gid = getGlobalId();
        float h=(data[1]-data[0])/size;
        float a=data[0]+h*gid;
        float b=a+h;     
        partial[gid]=trapeze(a,b,500);
      }
    };

    kernel.execute(Range.create(size));
    System.out.println("Execution mode=" + kernel.getExecutionMode());
    kernel.dispose();
    
    /*
      Insumarea rezultatelor partiale
    */  
    float integ=0;
    for (int i = 0; i < size; i++) {
       integ+=partial[i];
       //System.out.printf("%10.4f\n", partial[i]);
    }
    
    System.out.printf("Integrala = %10.5f\n", integ);   
  }
}
