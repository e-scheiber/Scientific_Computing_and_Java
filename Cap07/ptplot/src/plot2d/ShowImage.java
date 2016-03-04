package plot2d;

import java.awt.*;
import javax.swing.*;

public class ShowImage{
  MyCanvas mc=null;
  int xDim=0;
  int yDim=0;
  
  ShowImage(Image image,int xDim,int yDim){
    this.xDim=xDim;
    this.yDim=yDim;
    mc=new MyCanvas(image);
  }
  
  public void show(){
  // Interfata swing
  JFrame jframe = new JFrame("Graficul furnizat de \"PtPlot\"");
  jframe.addNotify();
  jframe.getContentPane().setLayout(new BorderLayout()); 
  jframe.getContentPane().add(mc,BorderLayout.CENTER);
  jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  jframe.setSize(xDim,yDim);
  jframe.setVisible(true);
  }
      
}
