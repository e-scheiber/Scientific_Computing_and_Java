/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plot2d;
import java.awt.*;
import javax.swing.JFrame;

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
    JFrame jframe = new JFrame("Graficul furnizat de \"jfreechart\"");
    jframe.addNotify();
    jframe.getContentPane().setLayout(new BorderLayout()); 
    jframe.getContentPane().add(mc,BorderLayout.CENTER);
    //jframe.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    jframe.setSize(xDim,yDim);
    jframe.setVisible(true);
  }
}