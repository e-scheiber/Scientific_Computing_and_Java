import org.apache.commons.math3.analysis.solvers.LaguerreSolver;
import org.apache.commons.math3.complex.Complex;

public class MetodaLaguerre{
  public static void main(String[] args){
    /*
    double[] coeff={1,2,3,2,1};
    PolynomialFunction polinom=new PolynomialFunction(coeff);
    LaguerreSolver solver = new LaguerreSolver(polinom);
    double initial=0;
    try{
      Complex[] roots = solver.solveAll(coeff,initial);  
      System.out.println("Radacinile : ");
      for(int i=0;i<coeff.length-1;i++)
        System.out.println(roots[i].getReal()+" +I "+roots[i].getImaginary());
    }
    catch(Exception e){
      System.out.println("Exception : "+e.getMessage());
    }
    */
    //double[] coeff={2,-1,-3,1,1};
    double[] coeff={1,2,3,2,1};
    double absoluteAccuracy=1.0e-5;
    LaguerreSolver solver = new LaguerreSolver(absoluteAccuracy);
    int maxEval=200;
    double min=0;
    double max=10;
    double startValue=0.0;
    Complex[] sol=solver.solveAllComplex(coeff,startValue);
    for(int i=0;i<sol.length;i++)
      System.out.println(sol[i].toString());   
  }
}