import java.io.IOException;
import java.net.URI;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;
import javax.websocket.Session;
import java.util.Scanner;

import javax.websocket.Endpoint; 
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;

public class WebSocketClient extends Endpoint{
  private static boolean sfarsit=false;
  private static String server = "ws://localhost:8080/EcalgWebSocketAd/ecalg";
  static long mom0;
  
  public static void main(String[] args){
    Scanner scanner=new Scanner(System.in);
    System.out.println("Introduceti:");
    System.out.println("Variabila independenta ");
    String svar=scanner.next();
    System.out.println("Membrul stang al ecuatiei ");
    String expr=scanner.next();
    System.out.println("Aproximatia initiala ");
    double x=scanner.nextDouble();
    System.out.println("Toleranta ");
    double eps=scanner.nextDouble();
    System.out.println("Numar maxim admis de iteratii ");
    int nmi=scanner.nextInt();
    String msg=svar+":"+expr+":"+x+":"+eps+":"+nmi+":text";
    
    WebSocketContainer container = ContainerProvider.getWebSocketContainer();
    try {  
      Session session=container.connectToServer(WebSocketClient.class, null, URI.create(server));
      mom0=System.currentTimeMillis();
      session.getBasicRemote().sendText(msg); 
      while(! sfarsit){System.out.print("");};
      // De ce nu functioneaza ?
      // 1.
      // while(!sfarsit){;};
      // 2.
      // long i=0;while(!sfarsit){i++;};
      session.close();
    } 
    catch(Exception ex){
       System.out.println("LocalEndPoint Exception : "+ex.getMessage());
    } 
  }
  
  public void onOpen(Session session, EndpointConfig config) {
    session.addMessageHandler(new MessageHandler.Whole<String>() {
       public void onMessage(String text){
         long d=System.currentTimeMillis()-mom0;
         System.out.println("Durata : "+d);
         System.out.println("Rezultate : ");
         System.out.println(text);
         sfarsit=true;
       }  
    });
  }
  
}
