package grafic2d;
public class DataIn{
  private double a=-5;
  private double b=5;
  private int n=100;
  
  public double fct(double x){
    return x-Math.sqrt(x*x-1);
  }
  
  public double dfct(double x){
    return 1-x/Math.sqrt(x*x-1);
  }
  
  public void setA(double a){
    this.a=a;
  }
  public double getA(){
    return a;
  }
  
  public void setB(double b){
    this.b=b;
  }
  public double getB(){
    return b;
  }

  public void setN(int n){
    this.n=n;
  }
  public int getN(){
    return n;
  }  
}