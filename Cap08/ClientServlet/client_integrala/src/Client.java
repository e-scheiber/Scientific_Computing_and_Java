package integrala;
import java.util.Scanner;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

public class Client{
  static String url = "http://localhost:8080/appinteg/integ";
  
  public static void main(String[] args) {   
    Scanner scanner=new Scanner(System.in);
    System.out.println("Introduceti:");
    System.out.println("Variabila ");
    String svar=scanner.next();
    System.out.println("Expresia de integrat ");
    String expr=scanner.next();
    System.out.println("Limita inferioara ");
    double a=scanner.nextDouble();
    System.out.println("Limita superioara ");
    double b=scanner.nextDouble();
    System.out.println("Toleranta ");
    double eps=scanner.nextDouble();
    System.out.println("Numar maxim admis de iteratii ");
    int nmi=scanner.nextInt();
    try{
      String result=Request.Post(url)
        .bodyForm(Form.form()
          .add("svar",svar)
          .add("expr",expr)
          .add("a",new Double(a).toString())
          .add("b",new Double(b).toString())
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
