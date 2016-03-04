import org.apache.commons.math3.analysis.solvers.NewtonRaphsonSolver;
import org.apache.commons.math3.analysis.UnivariateFunction;
//import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;

/*
class DFunctie implements UnivariateFunction{
  public double value(double x){
    return Math.exp(2*Math.log(2))*Math.log(2)-2*x;
  }
}  
*/

class Functia implements UnivariateDifferentiableFunction{
  /*
  public UnivariateFunction derivative(){
    return new DFunctie();
  }
  public double value(double x){
    return Math.exp(x*Math.log(2))-x*x;
  }
  */
  public DerivativeStructure value(DerivativeStructure x){
    //DerivativeStructure x=new DerivativeStructure(1,1,0,-0.5);
    DerivativeStructure t1=x.multiply(Math.log(2)).exp();
    DerivativeStructure t2=x.pow(2);
    return new DerivativeStructure(1,t1,-1,t2);
  }  
  
  public double value(double x){
    return Math.exp(x*Math.log(2))-x*x;
  }
} 

public class MetodaTangentei{
  
  public static void main(String[] args){
    UnivariateDifferentiableFunction function = new Functia();
    double absoluteAccuracy=1.0e-5;
    NewtonRaphsonSolver solver=new NewtonRaphsonSolver(absoluteAccuracy);
    int maxEval=1000;
    double min=-0.8;
    double max=-0.5;
    try{
      double c = solver.solve(maxEval,function,min,max);
      System.out.println("Solutia : "+c);
    }
    catch(Exception e){
      System.out.println("Exception : "+e.getMessage());
    }
  }
}