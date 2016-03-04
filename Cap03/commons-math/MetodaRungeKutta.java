import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
//import org.apache.commons.math.ode.nonstiff.DormandPrince54Integrator;
import org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaIntegrator;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.sampling.FixedStepHandler;
import org.apache.commons.math3.ode.sampling.StepNormalizer;

class Problema implements FirstOrderDifferentialEquations{
  public void computeDerivatives(double t, double[]y, double[]yDot){
    yDot[0]=y[0];
  }
  
  public int getDimension(){
    return 1;
  }
}

public class MetodaRungeKutta{
  static double[][] z=new double[101][2];
  
  public static void main(String[] args){
    Problema ode=new Problema();
    double pas=0.01;
    int n=101;
    //FirstOrderIntegrator integrator = new DormandPrince54Integrator(1.0e-8, 100.0, 1.0e-10, 1.0e-10);
    ClassicalRungeKuttaIntegrator integrator=new ClassicalRungeKuttaIntegrator(pas);
    double t0=0;
    double[] y0={1};
    double t=n*pas;
    double[] y=new double[y0.length];
 
    FixedStepHandler stepHandler0 = new FixedStepHandler(){
       int k=-1;
       public void handleStep(double t,double[] y,double[] yDot,boolean isLast){
           k++;
           z[k][0]=t;
           z[k][1]=y[0];
         }
       public void init(double t0,double[] y0,double t){} 
    };
    StepNormalizer stepHandler=new StepNormalizer(pas,stepHandler0);
    integrator.addStepHandler(stepHandler);   
    try{
      integrator.integrate(ode,t0,y0,t,y);
      for(int i=0;i<n;i++){
         System.out.println(z[i][0]+" "+z[i][1]);
      }
    }
    catch(Exception e){
      System.out.println("Exception : "+e.getMessage());
    }  
  }
}
    