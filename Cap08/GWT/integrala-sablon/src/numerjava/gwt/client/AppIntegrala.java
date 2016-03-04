package numerjava.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.Window;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import mathlib.client.cvadra.*;
import mathlib.client.cvadra.impl.MetodaSimpsonWeb;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class AppIntegrala implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    Label titleLabel=new Label("Calculul unei integrale");
    titleLabel.addStyleName("label-title");
    Label varLabel=new Label("Simbolul variabilei");
    Label exprLabel=new Label("Functia");
    Label infLabel=new Label("Limita inferiara");
    Label supLabel=new Label("Limita superioara");
    Label epsLabel=new Label("Toleranta");
    Label nmiLabel=new Label("Numar maxim admis de iteratii");
    TextBox varTextBox=new TextBox();
    varTextBox.setVisibleLength(20);
    TextBox exprTextBox=new TextBox();
    exprTextBox.setVisibleLength(20);
    TextBox infTextBox=new TextBox();
    infTextBox.setVisibleLength(20);
    TextBox supTextBox=new TextBox();
    supTextBox.setVisibleLength(20);
    TextBox epsTextBox=new TextBox();
    epsTextBox.setVisibleLength(20);
    epsTextBox.setText("1e-5");
    TextBox nmiTextBox=new TextBox();
    nmiTextBox.setText("50");
    nmiTextBox.setVisibleLength(20);
    
    VerticalPanel dataPanel=new VerticalPanel();
    dataPanel.add(varLabel);    dataPanel.add(varTextBox);
    dataPanel.add(exprLabel);   dataPanel.add(exprTextBox);
    dataPanel.add(infLabel);    dataPanel.add(infTextBox);
    dataPanel.add(supLabel);    dataPanel.add(supTextBox);
    dataPanel.add(epsLabel);    dataPanel.add(epsTextBox);
    dataPanel.add(nmiLabel);    dataPanel.add(nmiTextBox);
    dataPanel.setBorderWidth(2);
    
    Label indLabel=new Label("Indicatorul de raspuns");
    Label integLabel=new Label("Integrala");
    Label niLabel=new Label("Numarul de iteratii efectuat");
    
    VerticalPanel resultsPanel=new VerticalPanel();
    resultsPanel.add(indLabel);
    //resultsPanel.add(indTextBox);
    resultsPanel.add(integLabel);
    //resultsPanel.add(integTextBox);
    resultsPanel.add(niLabel);
    //resultsPanel.add(niTextBox);
    resultsPanel.setBorderWidth(2);
    
    HorizontalPanel hp=new HorizontalPanel();
    hp.setSpacing(10);
    hp.add(dataPanel);
    hp.add(resultsPanel);
    
    //SimplePanel mainPanel=new SimplePanel();
    //mainPanel.add(hp);
    
    Button button=new Button("Integreaza");
    button.addStyleName("button");
    MyClickHandler handler=new MyClickHandler(varTextBox,
      exprTextBox,infTextBox,supTextBox,epsTextBox,nmiTextBox,
      indLabel,integLabel,niLabel);
    button.addClickHandler(handler);
    
    RootPanel.get("titleLabel").add(titleLabel);
    //RootPanel.get("mainPanel").add(mainPanel);
    RootPanel.get("mainPanel").add(hp);
    RootPanel.get("button").add(button);
  }
}
class MyClickHandler implements ClickHandler{
  TextBox varTextBox;
  TextBox exprTextBox;
  TextBox infTextBox;
  TextBox supTextBox;
  TextBox epsTextBox;
  TextBox nmiTextBox;
  Label indLabel;
  Label integLabel;
  Label niLabel;
  
  MyClickHandler(TextBox varTextBox,TextBox exprTextBox,TextBox infTextBox,
    TextBox supTextBox,TextBox epsTextBox,TextBox nmiTextBox,
    Label indLabel,Label integLabel,Label niLabel){
    this.varTextBox=varTextBox;  
    this.exprTextBox=exprTextBox;
    this.infTextBox=infTextBox;
    this.supTextBox=supTextBox;
    this.epsTextBox=epsTextBox;
    this.nmiTextBox=nmiTextBox;
    this.indLabel=indLabel;
    this.integLabel=integLabel;
    this.niLabel=niLabel;
  }
  
  public boolean isCompleted(TextBox tb,String name){
    String txt=tb.getText();
    if(txt.equals("")){
      Window.alert("Camp necompletat : "+name);
      indLabel.setText("?");
      integLabel.setText("?");
      niLabel.setText("?");
      return false;
    }
    return true;
  }
  
  public void onClick(ClickEvent event){
    if(!isCompleted(varTextBox,"Simbolul variabilei")) return;
    if(!isCompleted(exprTextBox,"Functia")) return;
    if(!isCompleted(infTextBox,"Limita inferioara")) return;
    if(!isCompleted(supTextBox,"Limita superioara")) return;
    if(!isCompleted(epsTextBox,"Toleranta")) return;
    if(!isCompleted(nmiTextBox,"Numar maxim admin de iteratii")) return;
    MEParserDataIn din=new MEParserDataIn(varTextBox.getText(),exprTextBox.getText());
    din.setA(infTextBox.getText());
    din.setB(supTextBox.getText());
    String eps=epsTextBox.getText();
    String nmi=nmiTextBox.getText();
    din.setEps(Double.parseDouble(eps));
    din.setNmi(Integer.parseInt(nmi));
    IMetodaSimpson obj=new MetodaSimpsonWeb();
    DataOut dout=obj.metodaSimpson(din);
    indLabel.setText("Indicatorul de raspuns : "+dout.getInd());
    integLabel.setText("Integrala : "+
      NumberFormat.getFormat("###0.000000").format(dout.getIntegrala()));
    niLabel.setText("Numarul iteratiilor efectuate : "+dout.getNi()); 
  }
}  

