package plot2d;
import java.awt.Image;
import java.awt.Canvas;
import java.awt.Graphics;

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
