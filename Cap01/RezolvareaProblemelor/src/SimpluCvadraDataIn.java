import mathlib.client.cvadra.DataIn;
public class SimpluCvadraDataIn extends DataIn{      
  SimpluCvadraDataIn(){
    setA(0);               // extremitatea stanga 
    setB(0.25*Math.PI);    // extremitatea dreapta
    setEps(1e-12);         // toleranta admisa
    setNmi(50);            // numar maxim admis de iteratii
  }
  
  // functia de integrat
  public double fct(double x){
    return Math.log(1+Math.tan(x));
  }
  
  
}