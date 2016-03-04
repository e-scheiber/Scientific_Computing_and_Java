package ecalg;
import java.util.Scanner;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

public class Client{
  static String url = "http://localhost:8080/appecalg/ecalg";
  
  public static void main(String[] args) {   
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
    try{
      String result=Request.Post(url)
        .bodyForm(Form.form()
          .add("svar",svar)
          .add("expr",expr)
          .add("x",new Double(x).toString())
          .add("eps",new Double(eps).toString())
          .add("nmi",new Integer(nmi).toString())
          .add("tip","text/plain")
          .build())
        .execute().returnContent().asString();
      System.out.println(result);
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }  
}
