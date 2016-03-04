/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package complexplot;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import org.nfunk.jep.type.Complex;

/**
 *
 * @author SCHEIBER
 */
public class ComplexPlot {
  DataIn din=null;
  int P;
  int Q;

  ComplexPlot(DataIn din){
    this.din=din;
    P=din.getP();
    Q=din.getQ();
  }

  double sgn(double x){
    return x>0 ? 1 : (x<0 ? -1 : 0);
  }

  BufferedImage refPlot(){
    double xm=din.getXm();
    double ym=din.getYm();
    double xM=din.getXM();
    double yM=din.getYM();
    double mx=(xM-xm)/P;
    double my=(yM-ym)/Q;
    BufferedImage bi=new BufferedImage(P,Q,BufferedImage.TYPE_3BYTE_BGR);
    Graphics gh=bi.getGraphics();
    Complex w;
    double u,v,s,R,R2,xx,yy;
    float b,g,r;
    for(int p=0;p<P;p++){
      for(int q=0;q<Q;q++){
        //System.out.println(p+" "+q+" "+var+" "+expr);
        u=xm+mx*p;
        v=yM-my*q;
        //w=din.fct(x,y);
        //u=w.re();
        //v=w.im();
        R=Math.sqrt(u*u+v*v);
        R2=R*R+1;
        s=sgn(R-1)*(0.5-R/R2);
        xx=u/R2/Math.sqrt(6);
        yy=v/R2/Math.sqrt(2);
        r=(float)(0.5+s+2*xx);
        g=(float)(0.5+s-xx+yy);
        b=(float)(0.5+s-xx-yy);
        // System.out.println("p="+p+" q="+q+" r="+r+" g="+g+" b="+b);
        gh.setColor(new Color(r,g,b));
        gh.fillRect(p,q,1,1);
      }
    }
    gh.setColor(Color.BLACK);
    gh.drawLine(0,Q/2,P,Q/2);
    gh.drawLine(P/2,0,P/2,Q);
    gh.drawLine(0,0,P,Q);
    gh.drawLine(0,Q,P,0);
    gh.setColor(Color.GREEN);
    gh.drawOval(P/4,Q/4,P/2,Q/2);
    gh.drawOval(3*P/8,3*Q/8,P/4,Q/4);
    gh.drawOval(P/8,Q/8,3*P/4,3*Q/4);
    return bi;
  }
  
  BufferedImage fctPlot(){
    double xm=din.getXm();
    double ym=din.getYm();
    double xM=din.getXM();
    double yM=din.getYM();
    double mx=(xM-xm)/P;
    double my=(yM-ym)/Q;
    BufferedImage bi=new BufferedImage(P,Q,BufferedImage.TYPE_3BYTE_BGR);
    Graphics gh=bi.getGraphics();
    Complex w;
    double x=0,y=0,u,v,s,R,R2,xx,yy;
    float b,g,r;
    for(int p=0;p<P;p++){
      for(int q=0;q<Q;q++){
        //System.out.println(p+" "+q+" "+var+" "+expr);
        x=xm+mx*p;
        y=yM-my*q;
        w=din.fct(x,y);
        u=w.re();
        v=w.im();
        R=Math.sqrt(u*u+v*v);
        R2=R*R+1;
        s=sgn(R-1)*(0.5-R/R2);
        xx=u/R2/Math.sqrt(6);
        yy=v/R2/Math.sqrt(2);
        r=(float)(0.5+s+2*xx);
        g=(float)(0.5+s-xx+yy);
        b=(float)(0.5+s-xx-yy);
        // System.out.println("p="+p+" q="+q+" r="+r+" g="+g+" b="+b);
        gh.setColor(new Color(r,g,b));
        gh.fillRect(p,q,1,1);
      }
    }
    int vx,vy;
    int[] d={P,P,(int)(P*Math.sqrt(2)),(int)(P*Math.sqrt(2)),1000,1000,1000};
    for(int k=0;k<d.length;k++){
      for(int p=0;p<d[k];p++){
        switch(k){
          case 0: x=xm+mx*p;
                  y=yM-my*Q/2;
                  break;
          case 1: x=xm+mx*P/2;
                  y=yM-my*p;
                  break;
          case 2: x=xm+mx*p;
                  y=yM-my*(P-p);
                  break;
          case 3: x=xm+mx*p;
                  y=yM-my*p;
                  break;
          case 4: u=P/2+P/4*Math.cos(2*Math.PI*p/d[4]);
                  v=Q/2+P/4*Math.sin(2*Math.PI*p/d[4]);
                  x=xm+mx*u;
                  y=yM-my*v;
                  break;
          case 5: u=P/2+P/8*Math.cos(2*Math.PI*p/d[4]);
                  v=Q/2+P/8*Math.sin(2*Math.PI*p/d[4]);
                  x=xm+mx*u;
                  y=yM-my*v;
                  break;
          case 6: u=P/2+3*P/8*Math.cos(2*Math.PI*p/d[4]);
                  v=Q/2+3*P/8*Math.sin(2*Math.PI*p/d[4]);
                  x=xm+mx*u;
                  y=yM-my*v;
                  break;
        }
        if(k<4)
          gh.setColor(Color.BLACK);
        else
          gh.setColor(Color.GREEN);
        w=din.fct(x,y);
        if(!w.isNaN()){
          u=w.re();
          v=w.im();
          vx=(int)((u-xm)/mx);
          vy=(int)((yM-v)/my);
          //if(k==5)System.out.println(p+" "+x+" "+y+" "+u+" "+v+" "+vx+" "+vy);
          if((0<=vx)&&(vx<=P)&&(0<=vy)&&(vy<=Q)){
            gh.fillRect(vx,vy,1,1);
          }
        }
      }
    }
    return bi;
  }  
}
