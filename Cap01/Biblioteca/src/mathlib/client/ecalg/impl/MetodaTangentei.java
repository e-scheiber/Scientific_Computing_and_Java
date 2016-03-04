package mathlib.client.ecalg.impl;
import java.util.logging.Logger; 
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import mathlib.client.ecalg.DataIn;
import mathlib.client.ecalg.DataOut;
import mathlib.client.ecalg.IMetodaTangentei;
import java.io.IOException;

/** 
 * Implementarea metodei tangentei.
 * Varianta cu inregistrarea rezultatelor intermediare (log).
 */
public class MetodaTangentei implements IMetodaTangentei{
  static Logger logger = Logger.getLogger(MetodaTangentei.class.getName());

  public MetodaTangentei(){
    try{
      FileHandler loggingFile = new FileHandler("resultsEcalg.log");
      loggingFile.setFormatter(new SimpleFormatter());
      logger.addHandler(loggingFile);
    }
    catch(IOException e){
      System.out.println(e.getMessage());
    }  
  }
  
  /**
   * Metoda tangentei aplicata datelor fixate in obiectul din.
   */
  public DataOut metodaTangentei(DataIn din){
    double x,y=din.getX(),d,f,df,eps=din.getEps();
    int nmi=din.getNmi();
    DataOut dout=new DataOut();
    int ni=0;
    do{
      ni++;
      x=y;
      f=din.fct(x);
      df=dfct(x,din);
      y=x-f/df;
      if((y==Double.NaN)||(Math.abs(y)==Double.POSITIVE_INFINITY)){
        dout.setInd(2);
        dout.setX(y);
        dout.setF(Double.NaN);
        dout.setNi(ni);
        return dout;
      }
      d=Math.abs((y-x));
      String mesaj="iter = "+ni+" solutia = "+x+" eroarea = "+d;
      logger.info(mesaj);
    }
    //while((d>=eps*Math.abs(x)) && (ni<nmi));
    //if(d<eps*Math.abs(x))
    while((d>=eps) && (ni<nmi));
    if(d<eps)
      dout.setInd(0);
    else
      dout.setInd(1);
    dout.setX(x);
    dout.setF(din.fct(x));
    dout.setNi(ni);
    return dout;
  }
  
  /**
   * Calculul derivatei de ordinul intai.
   * @param x Punctul in care se calculeaza derivata.
   * @param din Obiect DataIn care contine definitia functiei a carei derivata
   * se calculeaza.
   */
  private double dfct(double x, DataIn din){
    int m=6;
    double h=1e-10;
    double pk=1; // 4^k
    double[][] d=new double[m][m];
    for(int i=0;i<m;i++)
      d[i][0]=0.5*(din.fct(x+h)-din.fct(x-h))/h;
    for(int j=1;j<m;j++){
      pk=4*pk;
      for(int i=j;i<m;i++){
        d[i][j]=(pk*d[i][j-1]-d[i-1][j-1])/(pk-1);
      }
    }
    return d[m-1][m-1];
  }
}
