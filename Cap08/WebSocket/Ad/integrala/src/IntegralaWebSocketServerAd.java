package websocket.cvadra;
import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;  
import javax.websocket.Session;
import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.RemoteEndpoint; 
import javax.websocket.EncodeException;
import java.io.IOException;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;
import mathlib.client.cvadra.JepDataIn;
import mathlib.client.cvadra.DataOut;
import mathlib.client.cvadra.IMetodaSimpson;
import mathlib.client.cvadra.impl.MetodaSimpsonWeb;
import java.text.DecimalFormat;

@ServerEndpoint(value="/cvadra")
public class IntegralaWebSocketServerAd{
  private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
    
  @OnMessage
  public void onMessage(String message,Session session){ 
    String[] elem=message.split(":");
    String var=elem[0];
    String expr=elem[1];
    System.out.println(var+" "+expr+" "+elem[2]+" "+elem[3]+" "+elem[4]+" "+elem[5]);
    JepDataIn din=new JepDataIn(var,expr);
    din.setA(elem[2]);
    din.setB(elem[3]);   
    din.setEps(Double.parseDouble(elem[4]));
    din.setNmi(Integer.parseInt(elem[5]));
    String tip=elem[6];
    IMetodaSimpson obj=new MetodaSimpsonWeb();
    DataOut dout=obj.metodaSimpson(din);
    DecimalFormat df=new DecimalFormat("0.0000001");
    StringBuffer rez=new StringBuffer();
    if(tip.equals("html")){
      rez.append("<table><tr><td>");
      rez.append("Indicatorul de raspuns : "+dout.getInd());
      rez.append("</td></tr><tr><td>");
      rez.append("Integrala : "+df.format(dout.getIntegrala()));
      rez.append("</td></tr><tr><td>");
      rez.append("Numarul iteratiilor efectuale : "+dout.getNi());
      rez.append("</td></tr></table>");
    }
    else{
      rez.append("Indicatorul de raspuns : "+dout.getInd());
      rez.append("\n");
      rez.append("Integrala : "+dout.getIntegrala());
      rez.append("\n");
      rez.append("Numarul iteratiilor efectuale : "+dout.getNi());
    }    
    
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
  
  @OnOpen
  public void onOpen(Session session)
      throws IOException,EncodeException{
    sessions.add(session);
  }
     
  @OnClose
  public void onClose(Session session){
    sessions.remove(session);
  }
}
