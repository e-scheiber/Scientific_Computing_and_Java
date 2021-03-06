/*
 * SistemLiniar.java
 *
 * Created on May 27, 2008, 5:27 PM
 */

package linear;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import mathlib.client.linear.DataIn;
import mathlib.client.linear.DataOut;
import mathlib.client.linear.IRezolvitorScilab;
import mathlib.client.linear.impl.RezolvitorScilab;
import java.text.DecimalFormat;

/**
 *
 * @author  SCHEIBER
 */
public class SistemLiniar extends javax.swing.JFrame {
 
    /** Creates new form SistemLiniar */
    public SistemLiniar() {
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

    jPanel1 = new javax.swing.JPanel();
    jButtonUpload = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTextAreaSol = new javax.swing.JTextArea();
    jLabelSol = new javax.swing.JLabel();
    jTextFieldStatus = new javax.swing.JTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Rezolvarea sistemului algebric de ecuatii liniare");

    jButtonUpload.setText("Incarca fisierul sistemului");
    jButtonUpload.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jButtonUploadMouseClicked(evt);
      }
    });

    jTextAreaSol.setColumns(20);
    jTextAreaSol.setEditable(false);
    jTextAreaSol.setRows(5);
    jScrollPane1.setViewportView(jTextAreaSol);

    jLabelSol.setText("Solutia");

    jTextFieldStatus.setEditable(false);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jTextFieldStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(31, 31, 31)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabelSol)
            .addGap(45, 45, 45)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
          .addComponent(jButtonUpload, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
        .addGap(59, 59, 59))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(34, 34, 34)
        .addComponent(jButtonUpload)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jLabelSol, javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

    pack();
  }// </editor-fold>//GEN-END:initComponents

private void jButtonUploadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUploadMouseClicked
// TODO add your handling code here:
  jTextFieldStatus.setText("");
  JFileChooser fc=new JFileChooser();
  fc.setDialogTitle("Alegeti fisierul sistemului");
  fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
  DecimalFormat f=new DecimalFormat("0.0000E0");
  jTextAreaSol.setText("");
  try{
    if (evt.getSource() == jButtonUpload){
      int returnVal = fc.showOpenDialog(this);
      if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fc.getSelectedFile();
        FileInputStream fis=new FileInputStream(file);
        InputStreamReader isr=new InputStreamReader(fis);
        BufferedReader br=new BufferedReader(isr);
        DataIn din=new DataIn();
        din.setMatrix(br);
        br.close();
        isr.close();
        fis.close();    
        IRezolvitorScilab obj=new RezolvitorScilab();
        DataOut dout=obj.rezolvitorScilab(din);
        String rez="";
        if(dout.isCompatibil()){
          double[] x=dout.getX();
          double[][] k=dout.getK();
          rez="X=\n";
          int l=x.length;       
          for(int i=0;i<l;i++){
            rez+=f.format(x[i]);
            rez+="\n";
          }
          rez+="Ker=\n";
          if(k!=null){
            int c=k[0].length;
            for(int i=0;i<l;i++){
              for(int j=0;j<c;j++){
                rez+=f.format(k[i][j]);
                rez+="     ";
              }
              rez+="\n";
            }
          }
          else{
            rez+="[ ]";
          }
        }
        else{
          rez="Sistem incompatibil !";
        }
        jTextAreaSol.setText(rez);
      }
      else{
        throw new Exception("Actiune anulata de client.");
      }
    }
  }
  catch(Exception ex){
    jTextFieldStatus.setText(ex.getMessage());
  }
}//GEN-LAST:event_jButtonUploadMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SistemLiniar().setVisible(true);
            }
        });
    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButtonUpload;
  private javax.swing.JLabel jLabelSol;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextArea jTextAreaSol;
  private javax.swing.JTextField jTextFieldStatus;
  // End of variables declaration//GEN-END:variables

}
