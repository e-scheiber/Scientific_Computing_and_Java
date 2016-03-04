import mathlib.client.cvadra.*;
import mathlib.client.ecalg.*;
import mathlib.client.cvadra.impl.*;
import mathlib.client.ecalg.impl.*;
import org.osgi.framework.*;

public class Activator implements BundleActivator{
  ServiceRegistration metodaSimpsonService;
  ServiceRegistration metodaTangenteiService;
  public void start(BundleContext context){
    metodaSimpsonService=
      context.registerService(IMetodaSimpson.class.getName(),new MetodaSimpson(),null);
    System.out.println("Registering MetodaSimpson service.");
       metodaTangenteiService=
      context.registerService(IMetodaTangentei.class.getName(),new MetodaTangentei(),null);
    System.out.println("Registering MetodaTangentei service.");
  }

  public void stop(BundleContext context) {
    metodaSimpsonService.unregister();
    metodaTangenteiService.unregister();
  }
}
