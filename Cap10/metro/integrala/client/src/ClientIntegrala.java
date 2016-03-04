package integrala.client;
//import integrala.server.*;
import java.util.Scanner;

public class ClientIntegrala {
  public static void main(String[] args) {
    MetodaSimpsonWSService service=new MetodaSimpsonWSService();
    MetodaSimpsonWS port=service.getMetodaSimpsonWSPort();
    Scanner scanner=new Scanner(System.in);
    System.out.println("Extremitatea stanga");
    String a=scanner.next();
    System.out.println("Extremitatea dreapta");
    String b=scanner.next();
    System.out.println("Simbolul variabilei");
    String svar=scanner.next();
    System.out.println("Expresia de integrat");
    String expr=scanner.next();
    System.out.println("Toleranta");
    String eps=scanner.next();
    System.out.println("Numar maxim admis de iteratii");
    String nmi=scanner.next();
    DataOut dout=port.integreaza(a,b,svar,expr,eps,nmi);
    System.out.println("Indicatorul de raspuns : "+dout.getInd());
    System.out.println("Integrala : "+dout.getIntegrala());
    System.out.println("Numar de iteratii efectuate : "+dout.getNi());          
  }
}
