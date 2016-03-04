package grafic3d;
import visad.*;
import visad.java3d.DisplayImplJ3D;
import java.rmi.RemoteException;
import java.awt.*;
import javax.swing.*;

public class ReprezentareFunctie3D{
  private DataIn din;
  
  public ReprezentareFunctie3D(DataIn din){
    this.din=din;
  }
  
  public void plot3D(){
    int nx=din.getNx();
    int ny=din.getNy();
    DisplayImpl display=null;

    try{
      // Definirea structurii de date           
      RealType xType = RealType.getRealType("x");
      RealType yType = RealType.getRealType("y");
      RealType zType = RealType.getRealType("z");
      RealTupleType xyType = new RealTupleType(xType,yType);
      FunctionType fctType = new FunctionType(xyType, zType);
      
      // Precizarea datelor
      Linear2DSet xySet = new Linear2DSet(xyType,din.getXMin(),din.getXMax(),nx,
        din.getYMin(),din.getYMax(),ny);
      float[][] xyValues=xySet.getSamples(true);
      double[][] zValues = new double[1][nx*ny];
      for(int i=0;i<nx*ny;i++){
        zValues[0][i]=din.fct(xyValues[0][i],xyValues[1][i]); 
      }
      
      // Fixarea conexiunii dintre structurile de date 
      // si tablourile de valori     
      FlatField ff = new FlatField( fctType, xySet);
      ff.setSamples( zValues);
      
      // Fixarea elementelor care definesc reprezentare grafica
      ScalarMap xMap = new ScalarMap(xType, Display.XAxis );
      ScalarMap yMap = new ScalarMap(yType, Display.YAxis );
      ScalarMap zMap = new ScalarMap(zType, Display.ZAxis );
      ScalarMap zColMap = new ScalarMap(zType, Display.RGB);
      DataReferenceImpl dri=new DataReferenceImpl("data_ref");
      dri.setData(ff);
      
      // Definirea containerului grafice caruia i 
      // se adauga elementele reprezentarii grafice
      display = new DisplayImplJ3D("3d");
      display.addMap( xMap );
      display.addMap( yMap );
      display.addMap( zMap );
      display.addMap( zColMap );
      display.addReference(dri);
      
      // Elemente suplimentare de control
      GraphicsModeControl gmc=(GraphicsModeControl)display.getGraphicsModeControl();
      gmc.setScaleEnable(true);
      gmc.setTextureEnable(false);
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
    JFrame jframe = new JFrame("Graficul 3D a unei functii in 2 variabile");
    jframe.getContentPane().setLayout(new BorderLayout()); 
    jframe.getContentPane().add(display.getComponent(),BorderLayout.CENTER);
    jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
    jframe.setSize(600, 600);
    jframe.setVisible(true);
  }
  public static void main(String[] args){
    DataIn din=new DataIn();
    ReprezentareFunctie3D obj=new ReprezentareFunctie3D(din);
    obj.plot3D();
  }
}

