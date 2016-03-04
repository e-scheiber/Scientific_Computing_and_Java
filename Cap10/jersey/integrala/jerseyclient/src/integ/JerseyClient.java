package integ;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.Scanner;

public class JerseyClient {
  public static void main(String args[]) {
    Client client = ClientBuilder.newClient();
    String rootURL="http://localhost:8080/integrala/resources/integ";
    WebTarget webTarget = client.target(rootURL);
    //Invocation.Builder invocationBuilder=webTarget.request();
    //invocationBuilder.get(String.class);
    
    Scanner scanner=new Scanner(System.in);
    System.out.println("Extremitatea stanga");
    String a=scanner.next();
    System.out.println("Extremitatea dreapta");
    String b=scanner.next();
    System.out.println("Simbolul variabilei");
    String svar=scanner.next();
    System.out.println("Expresia de integrat");
    String expr=scanner.next();
    System.out.println("Toleranta");
    String eps=scanner.next();
    System.out.println("Numar maxim admis de iteratii");
    String nmi=scanner.next();    
    String response=webTarget.
      queryParam("svar",svar).
      queryParam("expr",expr).
      queryParam("a",a).
      queryParam("b",b).
      queryParam("nmi",nmi).
      queryParam("eps",eps).
      queryParam("tip","text/plain").
      request().get(String.class);
    System.out.println(response);
  }
}
