package grafic2d;
import visad.*;
import visad.java2d.DisplayImplJ2D;
import java.rmi.RemoteException;
import java.awt.*;
import javax.swing.*;

public class ReprezentareFunctie2D{
  private DataIn din;
  
  public ReprezentareFunctie2D(DataIn din){
    this.din=din;
  }
         
  public void plot(){ 
    int n=din.getN();
    DisplayImpl display=null;
    
    try{
      // Definirea structurilor de date           
      RealType xType = RealType.getRealType("x");
      RealType yType = RealType.getRealType("y");
      FunctionType fctType = new FunctionType(xType, yType);
      // Precizarea datelor
      Linear1DSet xSet = new Linear1DSet(xType,din.getA(),din.getB(),n);
      float[][] xValues=xSet.getSamples(true);
      double[][] yValues = new double[1][n];
      for(int i=0;i<n;i++){
        yValues[0][i]=din.fct(xValues[0][i]);
      }      
      // Fixarea conexiunii dintre structurile de date 
      // si tablourile de valori     
      FlatField ff = new FlatField( fctType, xSet);
      ff.setSamples( yValues );
      
      // Fixarea elementelor care definesc reprezentare grafica
      ScalarMap xMap = new ScalarMap( xType, Display.XAxis );
      ScalarMap yMap = new ScalarMap( yType, Display.YAxis );
      DataReferenceImpl dri=new DataReferenceImpl("data_ref");
      dri.setData(ff);
      // Definirea containerului grafice caruia i 
      // se adauga elementele reprezentarii grafice
      display = new DisplayImplJ2D("2d");
      display.addMap( xMap );
      display.addMap( yMap );
      //display.addMap( dyMap );
      display.addReference(dri);
      // Desenarea axelor de coordonate
      GraphicsModeControl gmc=
        (GraphicsModeControl)display.getGraphicsModeControl();
      gmc.setScaleEnable(true);
    }
    catch(VisADException e){
      System.out.println("VisadException : "+e.getMessage());
      System.exit(1);
    }
    catch(RemoteException e){
      System.out.println("RMI-RemoteException : "+e.getMessage());
      System.exit(1);
    }
    // Integrarea intr-un cadrul swing 
    JFrame jframe = new JFrame("Graficul functiei");
    jframe.getContentPane().setLayout(new BorderLayout()); 
    jframe.getContentPane().add(display.getComponent(),BorderLayout.CENTER);
    jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
    jframe.setSize(400, 400);
    jframe.setVisible(true);
  }

  public static void main(String[] args){
    DataIn din=new DataIn();
    ReprezentareFunctie2D obj=new ReprezentareFunctie2D(din);
    obj.plot();
  }
}
