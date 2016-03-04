package mathlib.client.ecalg;
/**
 *  Clasa acoperitoare a datelor necesare rezolvarii
 *  unei ecuatii algebrice  
 */
public abstract class DataIn{
  private double x;   // aproximatia initiala
  private double eps; // toleranta admisa
  private int nmi;      // numar maxim admis de iteratii
  
  /**
   *  Functia corespunzatioare membrului stang al ecuatiei fct(x)=0.
   */
  public abstract double fct(double x);
  
  /**
   *  Fixeaza aproximatia solutiei.
   */ 
  public void setX(double x){
    this.x=x;
  }
  /**
   *  Fixeaza extremitatea inferioara a intervalului de integrare
   */ 
  public double getX(){
    return x;
  }
  
  /**
   *  Fixeaza toleranta.
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