package integrala;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.annotation.WebServlet; 
import mathlib.client.cvadra.*;
import mathlib.client.cvadra.impl.*;

//@WebServlet(urlPatterns = "/integ") 

public class MetodaSimpsonServlet extends HttpServlet{
  
  public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException{
    String a=req.getParameter("a");
    String b=req.getParameter("b");
    String var=req.getParameter("svar");
    String expr=req.getParameter("expr");
    String eps=req.getParameter("eps");
    String nmi=req.getParameter("nmi");
    String tip=req.getParameter("tip");
    System.out.println(var+" "+expr+" "+a+" "+b+" "+eps+" "+nmi+" "+tip);
    JepDataIn din=new JepDataIn(var,expr);
    din.setA(a);
    din.setB(b);
    din.setEps(Double.parseDouble(eps));
    din.setNmi(Integer.parseInt(nmi));
    IMetodaSimpson obj=new MetodaSimpsonWeb();
    DataOut dout=obj.metodaSimpson(din);
    res.setContentType(tip);
    PrintWriter out=res.getWriter();
    if(tip.equals("text/html")){
      out.println("<html>");
      out.println("<head><title>  </title></head>");
      out.println("<body bgcolor=\"#bbccbb\">");
      out.println("<center>"); 
      out.println("<h1>Calculul integralei prin metoda Simpson </h1>");
      out.println("<p>");
      out.println( "Indicatorul de raspuns : "+ dout.getInd());
      out.println("</p>");
      out.println("<p>");
      out.format( "Integrala : %1$12.6f",dout.getIntegrala());
      out.println("</p>");
      out.println("<p>");
      out.println( "Numarul iteratiilor efectuate : "+ dout.getNi());
      out.println("</p>");
      out.println("<br/>");
      out.println("</center>");
      out.println("</body>");
      out.println("</html>");
    }
    else{
      out.println("Indicatorul de raspuns : "+dout.getInd()); 
      out.println("Integrala : "+dout.getIntegrala());
      out.println("Numarul iteratiilor efectuate : "+dout.getNi());
    }
    out.close();
  }

  public void doPost(HttpServletRequest req,HttpServletResponse res)
     throws ServletException,IOException{
   doGet(req,res);
  }
}

