package mathlib.client.cvadra;
/**
 *  Clasa acoperitoare a datelor necesare calcului
 *  unei integrale  
 */
public abstract class DataIn{
  
  private double a;       // extremitatea stanga 
  private double b;       // extremitatea dreapta
  private double eps;     // toleranta admisa
  private int nmi;        // numar maxim admis de iteratii
  
  /**
   *  Functia integrata.
   */
  public abstract double fct(double x);
  
  /**
   *  Returneaza extremitatea inferioara a intervalului de integrare.
   */
  public double getA(){
    return a;
  }
  /**
   *  Fixeaza extremitatea inferioara a intervalului de integrare.
   */  
  public void setA(double a){
    this.a=a;
  }
  
  /**
   *  Returneaza extremitatea superioara a intervalului de integrare.
   */
  public double getB(){
    return b;
  }
  /**
   *  Fixeaza extremitatea superiora a intervalului de integrare.
   */  
  public void setB(double b){
    this.b=b;
  }
  
  /**
   *  Fixeza toleranta.
   */
  public void setEps(double eps){
    this.eps=eps;
  }
  /**
   *  Returneaza toleranta.
   */
  public double getEps(){
    return eps;
  }
  
  /**
   *  Fixeaza numarul maxim admis de iteratii.
   */ 
  public void setNmi(int nmi){
    this.nmi=nmi;
  }
  /**
   *  Returneaza numarul maxim admis de iteratii.
   */ 
  public int getNmi(){
    return nmi;
  }
}