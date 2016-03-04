package linear;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.*;
import mathlib.client.linear.*;
import mathlib.client.linear.impl.RezolvitorScilab; 
import java.text.DecimalFormat; 
import javax.servlet.annotation.WebServlet; 

@WebServlet(urlPatterns = "/linear") 

public class SistemLiniarServlet extends HttpServlet{
  public void doPost(HttpServletRequest req,HttpServletResponse res)
  throws ServletException,IOException {
    String tip="";
    ServletOutputStream out=null;
    DecimalFormat f=new DecimalFormat("0.0000E0");
    try{
      FileItemFactory factory = new DiskFileItemFactory();
      //boolean isMultipart = ServletFileUpload.isMultipartContent(req);
      ServletFileUpload   upload = new ServletFileUpload(factory);
      List items = upload.parseRequest(req);
      upload.setSizeMax(1000000);
      Iterator iter=items.iterator();
      DataIn din=new DataIn();
      while (iter.hasNext()) {
        FileItem item = (FileItem) iter.next();
        if (!item.isFormField()) {
          //String fileName = item.getName();
          //out.println(fileName);
          //long sizeInBytes = item.getSize();
          //out.println(sizeInBytes);
          InputStream in=item.getInputStream();
          InputStreamReader isr=new InputStreamReader(in);
          BufferedReader br=new BufferedReader(isr);
          din.setMatrix(br);
          br.close();
          isr.close();
          in.close();
        }
        else{
          String name = item.getFieldName();
          if(name.equals("tip")) 
            tip=item.getString();
        }
      }
      res.setContentType(tip);
      out = res.getOutputStream();
      IRezolvitorScilab obj=new RezolvitorScilab();
      DataOut dout=obj.rezolvitorScilab(din); 
      double[]x=null;
      double[][]k=null;
      int l=0,c=0;
      if(dout.isCompatibil()){
        x=dout.getX();
        k=dout.getK();
        l=x.length;
        if(k!=null) c=k[0].length;
      }
      if(tip.equals("text/html")){
        out.println("<html><body bgcolor=\"#bbccbb\" >");
        out.println("<center>");
        out.println("<h1> Solu&#355;ia sistemului algebric de ecua&#355;ii liniare</h1>");
        if(dout.isCompatibil()){      
          out.println("<table border=1 cellspacing=5>");
          out.println("<tr>");
          out.println("<th> X= </th>");
          out.println("<th align=\"center\" colspan="+(c-1)+"> Ker= </th>");  
          out.println("</tr>");
          for(int i=0;i<l;i++){
            out.println("<tr>");
            out.println("<td>");
            out.println(f.format(x[i]));  
            out.println("</td>");
            if(c>0){
              for(int j=0;j<c;j++){
                out.println("<td>");
                out.println(f.format(k[i][j]));
                out.println("</td>");
              }
            }
            out.println("</tr>");
          }
          out.println("</table>");             
        }
        else{
          out.println("Sistem incompatibil !");
        }
        out.println("</center>");  
        out.println("</html></body>");
      }
      else{
        String rez="";
        if(dout.isCompatibil()){
          for(int i=0;i<l;i++){
            rez+=x[i];
            rez+=" ";
            if(c>0){
              for(int j=0;j<c;j++){
                rez+=k[i][j];
                rez+=" ";
              }
            }
            rez+='\n';
          } 
        }
        System.out.println(rez);
        out.println(rez.trim());
      }
    }
    catch(Exception e){
      System.out.println("Exception: "+e.getMessage());
    }
    out.close();
  }
}