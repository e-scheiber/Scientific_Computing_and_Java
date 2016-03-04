import mathlib.client.ecalg.*;
import org.osgi.framework.*;

public class Activator implements BundleActivator{
  ServiceReference metodaSimpsonServiceReference;
  public void start(BundleContext context){
    try{
      metodaSimpsonServiceReference=
        context.getServiceReference(IMetodaTangentei.class.getName());
      if(metodaSimpsonServiceReference!=null){
        DataIn din=new SimpluEcAlgDataIn();
        IMetodaTangentei obj=
          (IMetodaTangentei)context.getService(metodaSimpsonServiceReference);
        DataOut dout=obj.metodaTangentei(din);
        System.out.println("\nIndicatorul de raspuns : "+dout.getInd());
        //System.out.println("Solutia ecuatiei : "+dout.getX());
        System.out.printf("Solutia ecuatiei : %16.8f\n",dout.getX());
        //System.out.println("Valoarea functiei in solutie : "+dout.getF());
        System.out.printf("Valoarea functiei in solutie : %16.8e\n",dout.getF());
        System.out.println("Numarul iteratiilor efectuate : "+dout.getNi());
      }
    }
    catch(Exception e){
      System.out.println("App Exception : "+e.getMessage());
    }
  }

  public void stop(BundleContext context){
    if(metodaSimpsonServiceReference!=null){
      context.ungetService(metodaSimpsonServiceReference);
    }
  }
}
