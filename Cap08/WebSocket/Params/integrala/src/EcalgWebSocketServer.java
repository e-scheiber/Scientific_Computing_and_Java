package websocket.ecalg;
import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;  
import javax.websocket.Session;
import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.RemoteEndpoint; 
import javax.websocket.EncodeException;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;
import mathlib.client.ecalg.JepDataIn;
import mathlib.client.ecalg.DataOut;
import mathlib.client.ecalg.IMetodaTangentei;
import mathlib.client.ecalg.impl.MetodaTangenteiWeb;
import java.text.DecimalFormat;

@ServerEndpoint(value="/ecalg/{msg}")
public class EcalgWebSocketServer{
  private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
    
  @OnMessage
  public void onMessage(String message,Session session){}
  
  @OnOpen
  public void onOpen(Session session, @PathParam("msg") String msg)
      throws IOException,EncodeException{
    sessions.add(session);
    String[] elem=msg.split(":");
    String var=elem[0];
    String expr=elem[1];
    //System.out.println(var+" "+expr+" "+x+" "+eps+" "+nmi);
    JepDataIn din=new JepDataIn(var,expr);
    din.setX(Double.parseDouble(elem[2]));
    din.setEps(Double.parseDouble(elem[3]));
    din.setNmi(Integer.parseInt(elem[4]));
    IMetodaTangentei obj=new MetodaTangenteiWeb();
    DataOut dout=obj.metodaTangentei(din);
    DecimalFormat df=new DecimalFormat("0.0000001");
    StringBuffer rez=new StringBuffer();
    rez.append("<table><tr><td>");
    rez.append("Indicatorul de raspuns : "+dout.getInd());
    rez.append("</td></tr><tr><td>");
    rez.append("Solutia : "+df.format(dout.getX()));
    rez.append("</td></tr><tr><td>");
    rez.append("Valoarea in solutie : "+df.format(dout.getF()));
    rez.append("</td></tr><tr><td>");
    rez.append("Numarul iteratiilor efectuale : "+dout.getNi());
    rez.append("</td></tr></table>");
    
    /*
    for (Session peer : sessions) {
      if(peer.equals(session)){
        peer.getBasicRemote().sendText(new Long(r).toString());
      }
    }
    */
    sessions.stream()
      .filter(s->s.equals(session))
      .forEach(s->{
        RemoteEndpoint.Basic endpoint=s.getBasicRemote();
        try{
          endpoint.sendText(rez.toString());
        }
        catch(IOException e){};
    });      
  }
     
  @OnClose
  public void onClose(Session session){
    sessions.remove(session);
  }
}
