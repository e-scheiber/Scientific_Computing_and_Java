/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Main.java
 *
 * Created on Jan 27, 2009, 3:45:46 PM
 */

package complexplot;
import java.awt.image.BufferedImage;
import java.awt.*;
/**
 *
 * @author SCHEIBER
 */
public class Main extends javax.swing.JFrame {

    /** Creates new form Main */
    public Main() {
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
    jLabelExpr = new javax.swing.JLabel();
    jLabelXm = new javax.swing.JLabel();
    jLabelYm = new javax.swing.JLabel();
    jLabelXM = new javax.swing.JLabel();
    jLabelYM = new javax.swing.JLabel();
    jTextFieldVar = new javax.swing.JTextField();
    jTextFieldExpr = new javax.swing.JTextField();
    jTextFieldXm = new javax.swing.JTextField();
    jTextFieldYm = new javax.swing.JTextField();
    jTextFieldXM = new javax.swing.JTextField();
    jTextFieldYM = new javax.swing.JTextField();
    jButtonCompute = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Reprezentarea grafica a functiei complexe");

    jLabelVar.setText("Simbolul variabilei");

    jLabelExpr.setText("Expresia functiei");

    jLabelXm.setText("xm");

    jLabelYm.setText("ym");

    jLabelXM.setText("xM");

    jLabelYM.setText("yM");

    jTextFieldVar.setText("z");

    jTextFieldExpr.setText("z");

    jTextFieldXm.setText("-2.0");

    jTextFieldYm.setText("-2.0");

    jTextFieldXM.setText("2.0");

    jTextFieldYM.setText("2.0");

    jButtonCompute.setText("Deseneaza");
    jButtonCompute.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jButtonComputeMouseClicked(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(30, 30, 30)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
            .addComponent(jLabelVar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelXm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addComponent(jLabelYM)
          .addComponent(jLabelXM)
          .addComponent(jLabelYm)
          .addComponent(jLabelExpr))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jTextFieldXM)
          .addComponent(jTextFieldYm)
          .addComponent(jTextFieldXm)
          .addComponent(jTextFieldExpr)
          .addComponent(jTextFieldVar)
          .addComponent(jTextFieldYM, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(52, 52, 52)
        .addComponent(jButtonCompute)
        .addContainerGap(94, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(27, 27, 27)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabelVar)
          .addComponent(jTextFieldVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jTextFieldExpr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabelExpr))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabelXm)
          .addComponent(jTextFieldXm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jTextFieldYm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabelYm))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jTextFieldXM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabelXM))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabelYM, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextFieldYM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButtonCompute))
        .addContainerGap(107, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void jButtonComputeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonComputeMouseClicked
      // TODO add your handling code here:
      String var=jTextFieldVar.getText();
      String expr=jTextFieldExpr.getText();
      DataIn din=new DataIn(var,expr);
      int P=400;
      int Q=400;
      double val=(new Double(jTextFieldXm.getText())).doubleValue();
      din.setXm(val);
      val=(new Double(jTextFieldYm.getText())).doubleValue();
      din.setYm(val);
      val=(new Double(jTextFieldXM.getText())).doubleValue();
      din.setXM(val);
      val=(new Double(jTextFieldYM.getText())).doubleValue();
      din.setYM(val);

      din.setP(P);
      din.setQ(Q);
      ComplexPlot cp=new ComplexPlot(din);
      /*
      try{
        File fout=new File("pic.jpg");
        ImageIO.write(cp.refPlot(),"jpg",fout);
      }
      catch(Exception e){
        System.out.println("Error "+e.getMessage());
      }
       */
      BufferedImage bf0=cp.refPlot();
      PlotPanel p0=new PlotPanel(din,(Image)bf0,din.getVar()+" -> "+din.getVar());
      BufferedImage bf=cp.fctPlot();
      PlotPanel pf=new PlotPanel(din,(Image)bf,din.getVar()+" -> "+din.getExpr());

      /*
      ShowImage si=new ShowImage((Image)bf0,dimX,dimY,din.getVar(),din.getExpr());
      si.show();
      */
      String title="Reprezentarea functiei compleze ";
      javax.swing.JFrame jframe = new javax.swing.JFrame(title);
      jframe.addNotify();
      jframe.getContentPane().setLayout(new GridLayout(1,2));
      jframe.getContentPane().add(p0);
      jframe.getContentPane().add(pf);
      //jframe.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
      jframe.setSize(2*P+120,Q+100);
      jframe.setVisible(true);
    }//GEN-LAST:event_jButtonComputeMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButtonCompute;
  private javax.swing.JLabel jLabelExpr;
  private javax.swing.JLabel jLabelVar;
  private javax.swing.JLabel jLabelXM;
  private javax.swing.JLabel jLabelXm;
  private javax.swing.JLabel jLabelYM;
  private javax.swing.JLabel jLabelYm;
  private javax.swing.JTextField jTextFieldExpr;
  private javax.swing.JTextField jTextFieldVar;
  private javax.swing.JTextField jTextFieldXM;
  private javax.swing.JTextField jTextFieldXm;
  private javax.swing.JTextField jTextFieldYM;
  private javax.swing.JTextField jTextFieldYm;
  // End of variables declaration//GEN-END:variables

}
