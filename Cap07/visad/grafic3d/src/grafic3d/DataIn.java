package grafic3d;
public class DataIn{
  private double xMin=-5;
  private double xMax=5;
  private double yMin=-5;
  private double yMax=5;
  private int nx=30;
  private int ny=30;
  
  public double fct(double x,double y){
    return x*x-y*y;
  }
  
  public void setXMin(double xMin){
    this.xMin=xMin;
  }
  public double getXMin(){
    return xMin;
  }
  
  public void setXMax(double xMax){
    this.xMax=xMax;
  }
  public double getXMax(){
    return xMax;
  }
  
  public void setYMin(double yMin){
    this.yMin=yMin;
  }
  public double getYMin(){
    return yMin;
  }
  
  public void setYMax(double yMax){
    this.yMax=yMax;
  }
  public double getYMax(){
    return yMax;
  }

  public void setNx(int nx){
    this.nx=nx;
  }
  public int getNx(){
    return nx;
  }  
  
  public void setNy(int ny){
    this.ny=ny;
  }
  public int getNy(){
    return ny;
  }
}