package mathlib.client.ecalg;
/**
 *  Clasa acoperitoare a rezultatelor obtinute 
 *  la rezolvarea unei ecuatii algebrice
 */
public class DataOut {
  private double x;   // aproximatia calculata a solutiei
  private int ind;    // indicatorul de raspuns al programului
  private double f;   // valoarea expresiei stangi a ecuatiei in x
  private int ni;     // numarul iteratiilor efectuate
  
  /**
   *  Returneaza aproximatia solutiei.
   */
  public double getX(){
    return x;
  }
  /**
   *  Fixeaza aproximatia solutiei.
   */
  public void setX(double x){
    this.x=x;
  }
  
  /**
   *  Returneaza valoarea membrului stang al ecuatiei calculata
   *  in aproximatia fixata a solutiei ecuatiei.
   */
  public double getF(){
    return f;
  }
  /**
   *  Fixeaza valoarea membrului stang al ecuatiei calculata
   *  in aproximatia calculata a solutiei ecuatiei.
   */
  public void setF(double f){
    this.f=f;
  }
  
  /**
   *  Returneaza indicatorul de raspuns.
   *
   *  0 - succes;
   *  1 - insucces.
   *  2 - singularitate depistata in timpul calculului.
   */
  public int getInd(){
    return ind;
  }
  /**
   *  Fixeaza indicatorul de raspuns.
   */
  public void setInd(int ind){
    this.ind=ind;
  }
  
  /**
   *  Returneaza numarul iteratiilor efectuate.
   */
  public int getNi(){
    return ni;
  }
  /**
   *  Fixeaza numarul iteratiilor efectuate.
   */
  public void setNi(int ni){
    this.ni=ni;
  }
}
