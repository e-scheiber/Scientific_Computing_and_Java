import org.junit.*;
import static org.junit.Assert.*;
import mathlib.client.ecalg.*;
import mathlib.client.ecalg.impl.*;

public class TestEcAlg{
  // rezultatul cunoscut al ecuatiei
  private double rezultat=-0.7666647;
  private DataIn din;
  private DataOut dout;
  
  @Before
  public void initializare(){
    din=new SimpluEcAlgDataIn();
    IMetodaTangentei obj=new MetodaTangentei();
    dout=obj.metodaTangentei(din);
  }
  
  @Test 
  public void test(){  
    /* 
    DataIn din=new SimpluEcAlgDataIn();
    IMetodaTangentei obj=new MetodaTangentei();
    DataOut dout=obj.metodaTangentei(din);
    System.out.println("\nIndicatorul de raspuns : "+dout.getInd());
    System.out.println("Solutia ecuatiei : "+dout.getX());
    System.out.println("Valoarea functiei in solutie : "+dout.getF());
    System.out.println("Numarul iteratiilor efectuate : "+dout.getNi());
    */
    assertEquals(rezultat,dout.getX(),din.getEps());
  }
  
  @After
  public void afisare(){
    System.out.println("\nIndicatorul de raspuns : "+dout.getInd());
    //System.out.println("Solutia ecuatiei : "+dout.getX());
    System.out.printf("Solutia ecuatiei : %16.8f\n",dout.getX());
    //System.out.println("Valoarea functiei in solutie : "+dout.getF());
    System.out.printf("Valoarea functiei in solutie : %16.8e\n",dout.getF());
    System.out.println("Numarul iteratiilor efectuate : "+dout.getNi());
  }  
  
  public static void main(String[] args){
    org.junit.runner.JUnitCore.main("TestEcAlg");
  }
}