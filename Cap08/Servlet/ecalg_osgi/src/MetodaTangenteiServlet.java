package ecalg;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet; 
import mathlib.client.ecalg.*;
import mathlib.client.ecalg.impl.*;

@WebServlet(urlPatterns = "/ecalg") 

public class MetodaTangenteiServlet extends HttpServlet{
  
  public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException{
    String fileSep = System.getProperty("file.separator");
    String x=req.getParameter("x");
    String var=req.getParameter("svar");
    String expr=req.getParameter("expr");
    String eps=req.getParameter("eps");
    String nmi=req.getParameter("nmi");
    String tip=req.getParameter("tip");
    System.out.println(var+" "+expr+" "+x+" "+eps+" "+nmi+" "+tip);
    JepDataIn din=new JepDataIn(var,expr);
    din.setX(Double.parseDouble(x));
    din.setEps(Double.parseDouble(eps));
    din.setNmi(Integer.parseInt(nmi));
    IMetodaTangentei obj=new MetodaTangenteiWeb();
    DataOut dout=obj.metodaTangentei(din);
    res.setContentType(tip);
    //ServletOutputStream out=res.getOutputStream(); 
    PrintWriter out=res.getWriter();
    if(tip.equals("text/html")){
      out.println("<html>");
      out.println("<head><title>  </title></head>");
      out.println("<body bgcolor=\"#bbccbb\">");
      out.println("<center>"); 
      out.println("<h1>Rezolvarea ecuatiei prin metoda Tangentei </h1>");
      out.println("<p>");
      out.println( "Indicatorul de raspuns : "+ dout.getInd());
      out.println("</p>");
      out.println("<p>");
      //out.println( "Solutia : "+ dout.getX());
      out.format( "Solutia : %1$12.6f",dout.getX());
      out.println("<p>");
      out.format( "Valoarea in solutie : %1$12.6f",dout.getF());
      out.println("</p>");
      out.println("<p>");
      out.println( "Numarul iteratiilor efectuate : "+ dout.getNi());
      out.println("</p>");
      out.println("<br/>");
      /*
      out.println("<a href=\"http://"+
        req.getServerName()+":"+
        req.getLocalPort()+fileSep+
        "appecalg"+fileSep+"resultsEcalg.log\">Vizualizati fisierul log</a>");
      */
      out.println("</center>");
      out.println("</body>");
      out.println("</html>");
    }
    else{
      /*
      res.setContentType("Application/Octet-stream");
      ObjectOutputStream oos=new ObjectOutputStream(out);
      oos.writeObject(dout);
      oos.close();
      */
      out.println("Indicatorul de raspuns : "+dout.getInd()); 
      out.println("Solutia : "+dout.getX());
      out.println("Numarul iteratiilor efectuate : "+dout.getNi());
      out.println("Valoarea in solutie : "+dout.getF());
    }
    out.close();
  }

  public void doPost(HttpServletRequest req,HttpServletResponse res)
     throws ServletException,IOException{
   doGet(req,res);
  }
}

