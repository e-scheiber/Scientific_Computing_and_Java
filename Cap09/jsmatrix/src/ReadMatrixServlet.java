package matrix;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet; 

@WebServlet(urlPatterns = "/matrix") 

public final class ReadMatrixServlet extends HttpServlet {
  
  public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException{
    PrintWriter out=res.getWriter(); 
    
    String rows=req.getParameter("m");
    int m=Integer.parseInt(rows);
    String cols=req.getParameter("n");
    int n=Integer.parseInt(cols);
    String mat=req.getParameter("mat");
    double[][] t=new double[m][n];
    String[] s=mat.split(",");
    for(int i=0;i<m;i++)
      for(int j=0;j<n;j++)
         t[i][j]=Double.parseDouble(s[i*n+j]);
    /*
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++)
        System.out.print(t[i][j]+" ");
      System.out.println();
    } 
    */ 
    res.setContentType("text/xml");
      res.setHeader("Cache-Control","no-cache");
      out.print("<?xml version=\"1.0\" ?>");
      out.print("<rezultat>");
      for(int i=0;i<m;i++){
        out.print("<row>");
          for(int j=0;j<n;j++){
            out.print("<col>");
              out.print(new Double(t[i][j]).toString());
            out.print("</col>");
          }
        out.print("</row>");
      }  
      out.print("</rezultat>");
    out.close();
  }

  public void doPost(HttpServletRequest req,HttpServletResponse res)
     throws ServletException,IOException{
    doGet(req,res);
  }
}
