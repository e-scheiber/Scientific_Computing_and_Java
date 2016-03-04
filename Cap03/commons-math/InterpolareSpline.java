import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator;
import org.apache.commons.math3.analysis.UnivariateFunction;

public class InterpolareSpline{
  public static void main(String[] args){
    double x[]={-2,-1,0,1,2};
    double y[]={2,1,0,1,2};
    try{
      UnivariateInterpolator interpolator = new SplineInterpolator();
      UnivariateFunction function = interpolator.interpolate(x,y);
      double t=0.5;
      double z=function.value(t);
      System.out.println("Valoarea interpolata in "+t+" este "+z);
    }    
    catch(Exception e){
      System.out.println("Exception : "+e.getMessage());
    }
  }
}