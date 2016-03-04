import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;

public class Activator implements BundleActivator{

  public void start(BundleContext context) throws Exception{
    ServiceReference sRef = context.getServiceReference(HttpService.class.getName());
    if (sRef != null){
      HttpService service = (HttpService) context.getService(sRef);
      service.registerServlet("/integ", new integrala.MetodaSimpsonServlet(), null, null);
      service.registerResources("/appinteg", "/index.html", null); 
    }
  }
  
   public void stop(BundleContext context) throws Exception{}
}