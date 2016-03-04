package mathlib.client.cvadra.impl;
import mathlib.client.cvadra.*;
/** 
 * Implementarea metodei Simpson.
 * Varianta fara inregistrarea rezultatelor intermediare.
 */
public class MetodaSimpsonWeb implements IMetodaSimpson{
  private double s=Double.NaN;

  public MetodaSimpsonWeb(){}
  
  /*
    * Formula Simpson de aplicare practica cu 
    * parametru de discretizare fixat
    * La prima apelare s=Double.NaN ! 
  */   
  private double simpson(int m,DataIn din){
    double a=din.getA(),b=din.getB();
    double h=0.5*(b-a)/m;
    double sp=0,si=0;
    if(Double.isNaN(s)){
      for(int i=1;i<m;i++)
        sp+=din.fct(a+2*i*h);
    }
    else
      sp=s;
    for(int i=0;i<m;i++)
      si+=din.fct(a+(2*i+1)*h);
    s=sp+si;
    return h*(din.fct(a)+din.fct(b)+2*sp+4*si)/3;  
  }
  
  /** 
   * Schema adaptiva pentru metoda lui Simpson.
   * Algoritm iterativ cu regula de oprire.
   */
  public DataOut metodaSimpson(DataIn din){
    double intv,intn,d,eps=din.getEps();
    int nmi=din.getNmi();
    int m=2;       // Parametrul de discretizare
    intn=simpson(m,din);
    DataOut dout=new DataOut();
    int ni=0;
    do{
      ni++;
      intv=intn;
      m=2*m;
      intn=simpson(m,din);
      d=Math.abs(intn-intv);
    }
    while((d>eps*Math.abs(intv)) && (ni<nmi));
    if(d<=eps*Math.abs(intv))
      dout.setInd(0);
    else
      dout.setInd(1);
    dout.setIntegrala(intn);
    dout.setNi(ni);
    return dout;
  }
}
