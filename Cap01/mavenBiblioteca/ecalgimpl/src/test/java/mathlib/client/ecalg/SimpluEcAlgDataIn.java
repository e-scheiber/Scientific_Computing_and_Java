import mathlib.client.ecalg.DataIn;

public class SimpluEcAlgDataIn extends DataIn{
  
  // membrul stang al ecuatiei 
  SimpluEcAlgDataIn(){
    setX(-0.5);     // aproximatia initiala
    setEps(1e-8);   // toleranta admisa
    setNmi(50);     // numar maxim admis de iteratii
  }
  
  public double fct(double x){
    return Math.exp(x*Math.log(2))-x*x;
  }
}