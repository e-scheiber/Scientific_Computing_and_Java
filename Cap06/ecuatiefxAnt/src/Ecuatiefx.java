package ecuatiefx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.paint.Color;
//import javafx.scene.paint.Stop;
import javafx.stage.Stage;
//import javafx.scene.shape.Circle;
//import javafx.scene.shape.StrokeType;
//import javafx.scene.shape.Rectangle;
//import javafx.scene.effect.BoxBlur;
//import javafx.scene.paint.LinearGradient;
//import javafx.scene.paint.CycleMethod;
//import javafx.scene.effect.BlendMode;
//import javafx.animation.Timeline;
//import javafx.animation.KeyFrame;
//import javafx.animation.KeyValue;
//import javafx.util.Duration;
//import javafx.scene.Node;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

//import javafx.scene.layout.VBox;
//import javafx.geometry.Pos;
import java.text.DecimalFormat;
import mathlib.client.ecalg.*;
import mathlib.client.ecalg.impl.MetodaTangenteiWeb; 

public class Ecuatiefx extends Application {

    public static void main(String[] args) {
        Application.launch(Ecuatiefx.class, args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metoda tangentei");
        Group root = new Group();
        Scene scene = new Scene(root, 600, 250, Color.LIGHTGREEN);
        
       
        GridPane gridpane=new GridPane();
        
        
        Label labelVar=new Label("Variabila");
        GridPane.setConstraints(labelVar, 1, 1); 
        Label labelAprox=new Label("Aproximatia initiala");
        GridPane.setConstraints(labelAprox, 1, 2); 
        Label labelExpr=new Label("Expresia membrului stang");
        GridPane.setConstraints(labelExpr, 1, 3); 
        Label labelTol=new Label("Toleranta");
        GridPane.setConstraints(labelTol, 1, 4); 
        Label labelNmi=new Label("Numar maxim de iteratii");
        GridPane.setConstraints(labelNmi, 1, 5); 
        
        final TextField TextFieldVar=new TextField();
        GridPane.setConstraints(TextFieldVar, 2, 1); 
        final TextField TextFieldAprox=new TextField();
        GridPane.setConstraints(TextFieldAprox, 2, 2);
        final TextField TextFieldExpr=new TextField();
        GridPane.setConstraints(TextFieldExpr, 2, 3);
        final TextField TextFieldTol=new TextField("1.0e-8");
        GridPane.setConstraints(TextFieldTol, 2, 4);
        final TextField TextFieldNmi=new TextField("50");
        GridPane.setConstraints(TextFieldNmi, 2, 5);
        
        Label labelInd=new Label("Indicatorul de raspuns");
        GridPane.setConstraints(labelInd, 3, 1); 
        Label labelSol=new Label("Solutia");
        GridPane.setConstraints(labelSol, 3, 2); 
        Label labelVal=new Label("Valoarea in solutie");
        GridPane.setConstraints(labelVal, 3, 3); 
        Label labelIter=new Label("Numar de iteratii");
        GridPane.setConstraints(labelIter, 3, 4); 
        
        final TextField TextFieldInd=new TextField();
        TextFieldInd.setVisible(false);
        GridPane.setConstraints(TextFieldInd, 4, 1);        
        final TextField TextFieldSol=new TextField();
        TextFieldSol.setVisible(false);
        GridPane.setConstraints(TextFieldSol, 4, 2);
        final TextField TextFieldVal=new TextField();
        TextFieldVal.setVisible(false);
        GridPane.setConstraints(TextFieldVal, 4, 3);
        final TextField TextFieldIter=new TextField();
        TextFieldIter.setVisible(false);
        GridPane.setConstraints(TextFieldIter, 4, 4);
        
        Button btn=new Button("Calculeaza");
        GridPane.setConstraints(btn, 2, 6);
        btn.setOnAction((new EventHandler<ActionEvent>() {
            public void handle(ActionEvent me) {
               String var=TextFieldVar.getText();
               String expr=TextFieldExpr.getText();
   //DataIn din=new MEParserDataIn(var,expr);
               DataIn din=new JepDataIn(var,expr);
               din.setX((new Double(TextFieldAprox.getText())).doubleValue());
               din.setEps((new Double(TextFieldTol.getText())).doubleValue());
               din.setNmi((new Integer(TextFieldNmi.getText())).intValue());
               IMetodaTangentei obj=new MetodaTangenteiWeb();
               DataOut dout=obj.metodaTangentei(din);
     //DecimalFormat f=new DecimalFormat("###0.00000000");
               DecimalFormat f=new DecimalFormat("0.00000E0");
               String sol=f.format(dout.getX());
               String val=f.format(dout.getF());
   //System.out.println(sol+" "+val);
               TextFieldInd.setText((new Integer(dout.getInd())).toString());
               TextFieldIter.setText((new Integer(dout.getNi())).toString());
   //jTextFieldSol.setText((new Double(dout.getX())).toString());
               TextFieldSol.setText(sol);
   //jTextFieldVal.setText((new Double(dout.getF())).toString());
               TextFieldVal.setText(val); 
            
               TextFieldInd.setVisible(true);
               TextFieldSol.setVisible(true);
               TextFieldVal.setVisible(true);
               TextFieldIter.setVisible(true);               
            } 
        }));
        
        gridpane.setVgap(8);
        gridpane.setHgap(8);
        gridpane.getChildren().addAll(labelVar,labelAprox,labelExpr,labelTol,labelNmi);
        gridpane.getChildren().addAll(TextFieldVar,TextFieldAprox,TextFieldExpr,TextFieldTol,TextFieldNmi);
        gridpane.getChildren().addAll(labelInd,labelSol,labelVal,labelIter);
        gridpane.getChildren().addAll(TextFieldInd,TextFieldSol,TextFieldVal,TextFieldIter);
        gridpane.getChildren().addAll(btn);
        
        /*
        Label labelVar=new Label("Variabila");
        Label labelAprox=new Label("Aproximatia initiala");
        Label labelExpr=new Label("Expresia membrului stang");
        Label labelTol=new Label("Toleranta");
        Label labelNmi=new Label("Numar admis de iteratii");
        
        VBox vb1=new VBox(8);
        vb1.setAlignment(Pos.CENTER_LEFT);
        vb1.getChildren().addAll(labelVar,labelAprox,labelExpr,labelTol,labelNmi);
        */
        
        root.getChildren().add(gridpane);  
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
