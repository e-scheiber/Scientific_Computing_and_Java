package mathlib.client.linear;
/** 
 * Interfata rezolvarii unui sistem algebric de ecuatii liniare
 * via Scilab.
 */
public interface IRezolvitorScilab{
  /**
   * Rezolvarea unui sistem algebric de ecuatii liniare 
   * via Scilab.
   */	
  public DataOut rezolvitorScilab(DataIn din);
}