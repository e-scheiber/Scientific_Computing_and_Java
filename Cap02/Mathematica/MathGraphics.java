import com.wolfram.jlink.*;

public class MathGraphics extends MathJFrame{
  private MathGraphicsJPanel mathGraphicsJPanel;
  private javax.swing.JLabel mJLabel;
  private javax.swing.JTextArea mJTextArea;
  private javax.swing.JButton mJButton;
  private javax.swing.JScrollPane mJScrollPane;
   
  static KernelLink ml;
  
  public MathGraphics(){
    initComponents();  
  }
  
  private void initComponents(){
    java.awt.GridBagConstraints gridBagConstraints; 
    setTitle("Mathematica : Grafica");
    setSize(400,400);
    getContentPane().setLayout(new java.awt.GridBagLayout());
    
    mathGraphicsJPanel=new MathGraphicsJPanel(ml);
    mathGraphicsJPanel.setBackground(java.awt.Color.white);
    mathGraphicsJPanel.setPreferredSize(new java.awt.Dimension(250,200));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    getContentPane().add(mathGraphicsJPanel, gridBagConstraints);
    
    mJLabel=new javax.swing.JLabel();
    mJLabel.setPreferredSize(new java.awt.Dimension(200,18));
    mJLabel.setText("Expresie \"Mathematica\"");
    mJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    getContentPane().add(mJLabel, gridBagConstraints);
    
    mJScrollPane=new javax.swing.JScrollPane();
    mJScrollPane.setPreferredSize(new java.awt.Dimension(200,60));
    mJTextArea=new javax.swing.JTextArea();
    mJScrollPane.setViewportView(mJTextArea);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    getContentPane().add(mJScrollPane, gridBagConstraints);
     
    mJButton=new javax.swing.JButton();
    mJButton.setText("Evalueaza");
    mJButton.setPreferredSize(new java.awt.Dimension(120,18));
    mJButton.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        mJButtonMouseClicked(evt);
      }
    }); 
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    getContentPane().add(mJButton, gridBagConstraints);
    
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent evt) {
        if(ml!=null){
          ml.evaluateToInputForm("CloseFrontEnd[]", 0);
          ml.close();
        }
        dispose();
        System.exit(0);
      }
    }); 
    ml.evaluateToInputForm("Needs[\"" + KernelLink.PACKAGE_CONTEXT + "\"]", 0);
    ml.evaluateToInputForm("ConnectToFrontEnd[]", 0);  
    toFront();
    pack();
  }
  
  private void mJButtonMouseClicked(java.awt.event.MouseEvent evt){
    mathGraphicsJPanel.setImageType(MathGraphicsJPanel.GRAPHICS);
    mathGraphicsJPanel.setUsesFE(true);
    mathGraphicsJPanel.setMathCommand(mJTextArea.getText());
  }
  
  public static void main(String args[]) {
    try {
      String[] mlArgs = {"-linkmode", "launch", "-linkname", args[0]};
      ml = MathLinkFactory.createKernelLink(mlArgs);
      ml.discardAnswer();
    } 
    catch (MathLinkException e) {
      System.out.println("An error occurred connecting to the kernel.");
      if (ml != null)
        ml.close();
      return;
    }
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new MathGraphics().setVisible(true);
      }
    });
  } 
}