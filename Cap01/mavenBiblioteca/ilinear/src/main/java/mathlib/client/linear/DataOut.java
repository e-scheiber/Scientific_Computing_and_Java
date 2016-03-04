package mathlib.client.linear;
/**
 *  Clasa acoperitoare a rezultatelor obtinute 
 *  la rezolvarea unui sistem algebric de ecuatii liniare
 */ 
public class DataOut {
  private double[] x=null;   // solutie particulara
  private double[][] k=null; // baza a spatiului liniar al 
                             // solutiilor sistemului omogen
  private boolean compatibil;  // natura sistemului
  
  /**
   *  Returneaza o solutie particulara a sistemului.
   */ 
  public double[] getX(){
    return x;
  }
  /**
   *  Fixeaza o solutie particulara a sistemului.
   */ 
  public void setX(double[] x){
    this.x=x;
  }
  
  /**
   *  Returneaza o baza normalizata a solutiilor 
   *  sistemului omogen.
   */ 
  public double[][] getK(){
    return k;
  }
  /**
   *  Fixeaza o baza normalizata a solutiilor 
   *  sistemului omogen.
   */ 
  public void setK(double[][] k){
    this.k=k;
  }
  
  /**
   *  Returneaza natura sistemului. 
   */ 
  public boolean isCompatibil(){
    return compatibil;
  }
  /**
   *  Fixeaza natura sistemului.
   */ 
  public void setCompatibil(boolean compatibil){
    this.compatibil=compatibil;
  }
}
