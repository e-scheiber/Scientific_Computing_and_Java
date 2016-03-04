/*
 * Grafic.java
 *
 * Created on June 30, 2008, 5:33 PM
 */

package plot2d;
import org.jfree.chart.*;
import org.jfree.data.xy.*;
import org.jfree.chart.renderer.xy.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.urls.*;
import java.awt.*;
import java.awt.image.*;
import org.nfunk.jep.*;
/**
 *
 * @author  SCHEIBER
 */


public class Grafic extends javax.swing.JFrame {
  int xDim=500;
  int yDim=300;
  
    /** Creates new form Grafic */
    public Grafic() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabelVar = new javax.swing.JLabel();
    jTextFieldVar = new javax.swing.JTextField();
    jLabelFct = new javax.swing.JLabel();
    jTextFieldFct = new javax.swing.JTextField();
    jLabelInf = new javax.swing.JLabel();
    jLabelSup = new javax.swing.JLabel();
    jTextFieldInf = new javax.swing.JTextField();
    jTextFieldSup = new javax.swing.JTextField();
    jTextFieldStatus = new javax.swing.JTextField();
    jButtonPlot = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Graficul functiei");

    jLabelVar.setText("Simbolul variabilei");

    jTextFieldVar.setText("x");

    jLabelFct.setText("Expresia functiei");

    jLabelInf.setText("Marginea inferioara");

    jLabelSup.setText("Marginea superioara");

    jTextFieldInf.setText("-5");

    jTextFieldSup.setText("5");

    jTextFieldStatus.setEditable(false);

    jButtonPlot.setText("Deseneaza");
    jButtonPlot.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jButtonPlotMouseClicked(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jTextFieldStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
      .addGroup(layout.createSequentialGroup()
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabelVar)
          .addComponent(jLabelInf)
          .addComponent(jButtonPlot))
        .addGap(32, 32, 32)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jTextFieldInf)
          .addComponent(jTextFieldVar, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
        .addGap(34, 34, 34)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addComponent(jLabelFct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jLabelSup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(29, 29, 29)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jTextFieldFct, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextFieldSup, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(43, 43, 43)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabelVar)
          .addComponent(jTextFieldFct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextFieldVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabelFct))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabelInf)
          .addComponent(jLabelSup)
          .addComponent(jTextFieldInf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextFieldSup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addComponent(jButtonPlot)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
        .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

private void jButtonPlotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPlotMouseClicked
// TODO add your handling code here:
  JEP parser=new JEP();
  parser.addStandardFunctions();
  parser.addStandardConstants();
  String var=jTextFieldVar.getText();
  String fct=jTextFieldFct.getText();
  String left=jTextFieldInf.getText();
  parser.parseExpression(left);
  double a=parser.getValue();
  String right=jTextFieldSup.getText();
  parser.parseExpression(right);
  double b=parser.getValue();
  parser.addVariable(var,0);
  parser.parseExpression(fct);
  XYSeries series = new XYSeries("y");
  int n=xDim*8;
  byte[]s=new byte[n+1];
  double h,x,y;
  if(b<a){
    h=a;
    a=b;
    b=h;
  }
  h=(b-a)/n;
  for(int i=0;i<=n;i++){
    x=a+i*h;
    parser.addVariable(var,x);
    y=parser.getValue();
    if((Double.isInfinite(y))||(Double.isNaN(y))){
      s[i]=1;
    }
    else{
      series.add(x, y);
      s[i]=0;
    }
  }
  XYDataset dataset = new XYSeriesCollection(series);
  JFreeChart chart=null;
    if(isCompact(s)){
      chart = ChartFactory.createXYLineChart(
               "Graficul functiei","x","y",
         dataset,org.jfree.chart.plot.PlotOrientation.VERTICAL,  
         true,false,false);
    }
    else{
      chart = createMyChart(
         "Graficul functiei","x","y",
         dataset,org.jfree.chart.plot.PlotOrientation.VERTICAL,  
         true,false,false);
    }  
    BufferedImage image=chart.createBufferedImage(xDim,yDim);  
    ShowImage si=new ShowImage(image,xDim,yDim);
    si.show();
    try {
      ChartUtilities.saveChartAsPNG(new java.io.File("Functia.png"), chart, xDim, yDim);
    }
    catch (java.io.IOException e){
      System.err.println("Error writing image to file : "+e.getMessage());
    }
}//GEN-LAST:event_jButtonPlotMouseClicked

public JFreeChart createMyChart(String title,
                                         String xAxisLabel,
                                         String yAxisLabel,
                                         XYDataset dataset,
                                         PlotOrientation orientation,
                                         boolean legend,
                                         boolean tooltips,
                                         boolean urls) {
    NumberAxis xAxis = new NumberAxis(xAxisLabel);
    xAxis.setAutoRangeIncludesZero(false);
    NumberAxis yAxis = new NumberAxis(yAxisLabel);
    XYItemRenderer renderer = 
      new StandardXYItemRenderer(StandardXYItemRenderer.DISCONTINUOUS_LINES);
    XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
    plot.setOrientation(orientation);
    if (tooltips){
      renderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
    }
    if (urls){
      renderer.setURLGenerator(new StandardXYURLGenerator());
    }
    JFreeChart chart=
      new JFreeChart(title,new Font("SansSerif",Font.BOLD,18),plot,legend);
    return chart;
  }
  
  boolean isCompact(byte[] s){
    int n=s.length;
    int noNaN=0,no=0;
    boolean first=true;
    for(int i=0;i<n;i++){
     if((s[i]==0)&& first){
       first=false;
       no++;
       }
     if((s[i]==1)&& (!first)) noNaN++;
       if((s[i]==0)&& (!first) && (noNaN>=1)) {
           no++;
           break;
       }
    }
    if(no>1)
        return false;
    else
        return true;
  }
  
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grafic().setVisible(true);
            }
        });
    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButtonPlot;
  private javax.swing.JLabel jLabelFct;
  private javax.swing.JLabel jLabelInf;
  private javax.swing.JLabel jLabelSup;
  private javax.swing.JLabel jLabelVar;
  private javax.swing.JTextField jTextFieldFct;
  private javax.swing.JTextField jTextFieldInf;
  private javax.swing.JTextField jTextFieldStatus;
  private javax.swing.JTextField jTextFieldSup;
  private javax.swing.JTextField jTextFieldVar;
  // End of variables declaration//GEN-END:variables

}
