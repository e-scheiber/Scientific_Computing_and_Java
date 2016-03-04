import org.junit.*;
import static org.junit.Assert.*;
import mathlib.client.cvadra.*;
import mathlib.client.cvadra.impl.*; 

public class TestIntegrala{
  // rezultatul cunoscut al integralei
  private double rezultat=0.125*Math.PI*Math.log(2);
  private DataIn din;
  private DataOut dout;
  
  @Before
  public void initializare(){
    din=new SimpluCvadraDataIn();
    IMetodaSimpson obj=new MetodaSimpson();
    dout=obj.metodaSimpson(din);
  }
  
  @Test 
  public void test(){  
    /*  
    DataIn din=new SimpluCvadraDataIn();
    IMetodaSimpson obj=new MetodaSimpson();
    DataOut dout=obj.metodaSimpson(din);
    System.out.println("\nIndicatorul de raspuns : "+dout.getInd());
    System.out.println("Integrala : "+dout.getIntegrala());
    System.out.println("Numarul iteratiilor efectuate : "+dout.getNi());
    */
    assertEquals(rezultat,dout.getIntegrala(),din.getEps());
  }
  
  @After
  public void afisare(){
    System.out.println("\nIndicatorul de raspuns : "+dout.getInd());
    System.out.println("Integrala : "+dout.getIntegrala());
    System.out.println("Numarul iteratiilor efectuate : "+dout.getNi());
  }  
  
  public static void main(String[] args){
    org.junit.runner.JUnitCore.main("TestIntegrala");
  }
}