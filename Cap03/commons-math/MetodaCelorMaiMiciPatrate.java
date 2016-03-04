//import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.optimization.general.LevenbergMarquardtOptimizer;
import org.apache.commons.math3.optimization.fitting.PolynomialFitter;

public class MetodaCelorMaiMiciPatrate{
  
  public static void main(String[] args){
    int degree=2;
    PolynomialFitter fitter = new PolynomialFitter(degree, new LevenbergMarquardtOptimizer());
    fitter.addObservedPoint(-2.0,2.0);
    fitter.addObservedPoint(-1.0,1.0);
    fitter.addObservedPoint(0.0,0.0);
    fitter.addObservedPoint(1.0,1.0);
    fitter.addObservedPoint(2.0,2.0);
    try{
      double[] coef = fitter.fit();
      for(int i=0;i<coef.length;i++)
        System.out.println(coef[i]+" * X^"+i);
    }
    catch(Exception e){
      System.out.println("Exception : "+e.getMessage());
    }
  }
}