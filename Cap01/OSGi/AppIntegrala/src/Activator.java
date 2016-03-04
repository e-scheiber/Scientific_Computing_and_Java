import mathlib.client.cvadra.*;
import mathlib.client.cvadra.impl.*; 
import org.osgi.framework.*;

public class Activator implements BundleActivator{
  public void start(BundleContext context){
    DataIn din=new SimpluCvadraDataIn();
    IMetodaSimpson obj=new MetodaSimpson();
    DataOut dout=obj.metodaSimpson(din);
    System.out.println("\nIndicatorul de raspuns : "+dout.getInd());
    System.out.println("Integrala : "+dout.getIntegrala());
    System.out.println("Numarul iteratiilor efectuate : "+dout.getNi());
  }

  public void stop(BundleContext context) {}
}
