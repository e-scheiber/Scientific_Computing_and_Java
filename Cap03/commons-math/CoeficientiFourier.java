import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.TransformType;
import java.text.DecimalFormat; 

class Functia implements UnivariateFunction{
   public double value(double x){
     return Math.sin(x)+Math.cos(3*x); 
  }
}

public class CoeficientiFourier{
  public static void main(String[] args){
    int n=16;
    double eps=1e-15;
    UnivariateFunction function = new Functia();
    double[] fVal=new double[n];
    double[] a=new double[n];
    double[] b=new double[n]; 
    Complex[] fft=new Complex[n];
    DecimalFormat f=new DecimalFormat("0.0000E0");
    try{ 
      for(int i=0;i<n;i++)
        fVal[i]=function.value(2*i*Math.PI/n);
      FastFourierTransformer transformer=new FastFourierTransformer(DftNormalization.STANDARD);
      fft=transformer.transform(fVal,TransformType.FORWARD);
      for(int i=0;i<n;i++){
        a[i]=2*fft[i].getReal()/n;
        if(Math.abs(a[i])<eps) a[i]=0;
        b[i]=-2*fft[i].getImaginary()/n;
        if(Math.abs(b[i])<eps) b[i]=0;
      }
      System.out.println("Coeficientii Fourier : ");
      for(int i=0;i<n/2;i++)
        System.out.println("a["+i+"] = "+f.format(a[i])+
          "   b["+i+"] = "+f.format(b[i]));  
    }
    catch(Exception e){
      System.out.println("Exception : "+e.getMessage());
    }
  }
}