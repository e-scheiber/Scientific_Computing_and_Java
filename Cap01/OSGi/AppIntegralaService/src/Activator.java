import mathlib.client.cvadra.*;
import org.osgi.framework.*;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator{
  ServiceTracker metodaSimpsonServiceTracker;
  public void start(BundleContext context){
    metodaSimpsonServiceTracker=new ServiceTracker(context,
       IMetodaSimpson.class.getName(),null);
    metodaSimpsonServiceTracker.open();
    DataIn din=new SimpluCvadraDataIn();
    IMetodaSimpson obj=(IMetodaSimpson)metodaSimpsonServiceTracker.getService();
    DataOut dout=obj.metodaSimpson(din);
    System.out.println("\nIndicatorul de raspuns : "+dout.getInd());
    //System.out.println("Integrala : "+dout.getIntegrala());
    System.out.printf("Integrala : %16.8f\n",dout.getIntegrala());
    System.out.println("Numarul iteratiilor efectuate : "+dout.getNi());
   /*     
    try{
      ServiceReference[] refs=context.getServiceReferences(Cvadra.class.getName(),null);
      if(refs!=null){
        DataIn din=new SimpluCvadraDataIn();
        Cvadra obj=new MetodaSimpson();
        DataOut dout=obj.metodaSimpson(din);
        System.out.println("\nIndicatorul de raspuns : "+dout.getInd());
        System.out.println("Integrala : "+dout.getIntegrala());
        System.out.println("Numarul iteratiilor efectuate : "+dout.getNi());
      }
    }
    catch(Exception e){
      System.out.println("App Exception : "+e.getMessage());
    }
    */
  }

  public void stop(BundleContext context){
    metodaSimpsonServiceTracker.close();
  }
}
