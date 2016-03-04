import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;
import org.apache.commons.math3.analysis.UnivariateFunction;

class Functia implements UnivariateFunction{
   public double value(double x){
    return Math.log(1+Math.tan(x)); 
  }
}

public class MetodaSimpson{
  public static void main(String[] args){
    UnivariateFunction function = new Functia();
    int maxEval=1000;
    double lower=0;
    double upper=Math.PI/4;
    double relativeAccuracy=1e-6;
    double absoluteAccuracy=1e-6;
    int minimalIterationCount=10;
    int maximalIterationCount=64;
    try{
      //UnivariateRealIntegrator integrator = new SimpsonIntegrator(function);
      SimpsonIntegrator integrator = new SimpsonIntegrator(relativeAccuracy,absoluteAccuracy,
         minimalIterationCount,maximalIterationCount);
      double integrala=integrator.integrate(maxEval,function,lower,upper);
      System.out.println("Integrala : "+integrala);
    }
    catch(Exception e){
      System.out.println("Exception : "+e.getMessage());
    }
  }
}