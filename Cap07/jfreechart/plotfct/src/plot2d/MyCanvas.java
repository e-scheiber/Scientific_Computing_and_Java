/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package plot2d;

/**
 *
 * @author SCHEIBER
 */
import java.awt.*;

public class MyCanvas extends Canvas{
  Image image=null;

  MyCanvas(Image image){
    this.image=image;
  }
  @Override
  public void paint(Graphics g){
    g.drawImage(image,0,0,this);
  }
}
