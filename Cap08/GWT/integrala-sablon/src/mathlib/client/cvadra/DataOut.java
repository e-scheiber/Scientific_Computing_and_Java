package mathlib.client.cvadra;
/**
 *  Clasa acoperitoare a rezultatelor obtinute 
 *  la calculul unei integrale
 */
public class DataOut{
  private double integrala; // integrala
  private int ind;          // indicatorul de raspuns al programului
  private int ni;           // numarul iteratiilor efectuate
  
  /**
   *  Returneaza valoarea integralei.
   */
  public double getIntegrala(){
    return integrala;
  }
  /**
   *  Fixeaza valoarea integralei.
   */
  public void setIntegrala(double integrala){
    this.integrala=integrala;
  }
  
  /**
   *  Returneaza indicatorul de raspuns.
   *
   *  0 - succes;
   *  1 - insucces.
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