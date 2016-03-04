import mathlib.client.ecalg.*;
import mathlib.client.ecalg.impl.*; 
import org.osgi.framework.*;

public class Activator implements BundleActivator{
  public void start(BundleContext context){ 
    DataIn din=new SimpluEcAlgDataIn();
    IMetodaTangentei obj=new MetodaTangentei();
    DataOut dout=obj.metodaTangentei(din);
    System.out.println("\nIndicatorul de raspuns : "+dout.getInd());
    System.out.println("Solutia ecuatiei : "+dout.getX());
    System.out.println("Valoarea functiei in solutie : "+dout.getF());
    System.out.println("Numarul iteratiilor efectuate : "+dout.getNi());
  }

  public void stop(BundleContext context) {}
}
