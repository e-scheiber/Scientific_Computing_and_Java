package resources;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import mathlib.client.cvadra.*;
import mathlib.client.cvadra.impl.MetodaSimpsonWeb;

@Path("integ")
public class IntegResource {
  private DataOut dout;
  private double s=Double.NaN;
  
  public IntegResource() {}

  @GET
  public Response doGet(
    @QueryParam("svar") String svar,
    @QueryParam("expr") String expr,
    @QueryParam("a") String a,
    @QueryParam("b") String b,
    @QueryParam("nmi") String nmi,
    @QueryParam("eps") String eps,
    @QueryParam("tip") String tip){
    JepDataIn din=new JepDataIn(svar,expr);
    din.setA(a);
    din.setB(b);
    din.setEps(Double.parseDouble(eps));
    din.setNmi(Integer.parseInt(nmi));
    IMetodaSimpson obj=new MetodaSimpsonWeb();
    dout=obj.metodaSimpson(din);
    
    int ntip=0;
    if(tip.equals("text/html")) ntip=1;
    Response r=null;
    switch(ntip){
      case 0: 
        r=Response.ok(getPlainRep(),"text/plain").build(); 
        break;
      case 1:
        r=Response.ok(getHtmlRep(),"text/html").build();
        break;
    } 
    return r;
  } 
  
  public String getPlainRep() {
    String rezultat="";
    rezultat=rezultat+"Indicatorul de raspuns : "+ (new Integer(dout.getInd())).toString()+"\n";
    rezultat=rezultat+"Integrala : "+ (new Double(dout.getIntegrala())).toString()+"\n";
    rezultat=rezultat+"Numar de iteratii efectuate : "+ (new Integer(dout.getNi())).toString();
    return rezultat;
  } 
  
  public String getHtmlRep() {
    String rezultat="<html><head></head><body bgcolor=\"#bbeebb\"><center><h1>Rezultatul furnizat de serviciul RESTfull";
    rezultat=rezultat+"<table border=\"1\">";
    rezultat=rezultat+"<tr>";
    rezultat=rezultat+"<td> Indicatorul de raspuns </td>";
    rezultat=rezultat+"<td>"+(new Integer(dout.getInd())).toString()+"</td>";
    rezultat=rezultat+"</tr>";
    rezultat=rezultat+"<tr>";
    rezultat=rezultat+"<td> Integrala </td>";
    rezultat=rezultat+"<td>"+(new Double(dout.getIntegrala())).toString()+"</td>";
    rezultat=rezultat+"</tr>";
    rezultat=rezultat+"<tr>";
    rezultat=rezultat+"<td> Numarul iteratiilor efectuate </td>";
    rezultat=rezultat+"<td>"+(new Integer(dout.getNi())).toString()+"</td>";
    rezultat=rezultat+"</tr>";
    rezultat=rezultat+"</table></h1></center></body></html>";
    return rezultat;
  } 
}

