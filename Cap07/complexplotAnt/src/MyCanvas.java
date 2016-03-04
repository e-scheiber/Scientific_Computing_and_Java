package complexplot;
import java.awt.*;

class MyCanvas extends Canvas{
  Image image=null;

  MyCanvas(Image image){
    this.image=image;
  }

  public void paint(Graphics g){
    g.drawImage(image,0,0,this);
  }
}