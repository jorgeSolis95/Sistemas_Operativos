package com.example.views;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.Queue;

public class Simulacion extends Stage implements EventHandler {
    private HBox hBox;
    private VBox vBox;
    private GridPane gdp1;
    private Scene escena;
    int tamaCircleRed=4;
    int tamaCircleblue=8;
    private Rectangle rectangle1,rectangle2;
    private Circle[] circleRed=new Circle[tamaCircleRed];
    private Circle[] circleBlue=new Circle[tamaCircleblue];
    private Button btnSimular,btnCubre;

    public Simulacion(){
        CrearUI();
        this.setTitle("Simulacion de entrada");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        gdp1=new GridPane();
        rectangle1=new Rectangle();
        rectangle2=new Rectangle();
        btnSimular=new Button("Sin cubrebocas");
        btnCubre=new Button("Con cubrebocas");
        CrearPlantilla();
        btnCubre.setOnAction(event -> {
            for(int i=(circleBlue.length-1);i>0;i--){
                circleBlue[i]=new Circle();
                circleBlue[i].setFill(Color.WHITE);
                circleBlue[i].setRadius(15);
                gdp1.add(circleBlue[i],0,i);
                tamaCircleblue=tamaCircleblue;
                tamaCircleblue--;
                for (int j=0;j<tamaCircleblue;j++){
                    circleBlue[j]=new Circle();
                    circleBlue[j].setFill(Color.BLUE);
                    circleBlue[j].setRadius(15);
                    gdp1.add(circleBlue[j],0,j);
                    //System.out.println(tamaCircleRed);
                }
                mostrarAlertInfoBlue(null);
                //CrearPlantilla();
            }
        });
        btnSimular.setOnAction(event -> {
           /* Queue queue = new LinkedList<Circle>();
            for (int i=0;i<circleRed.length;i++){
                queue.add(circleRed[i]);
            }
            System.out.print (((LinkedList<?>) queue).removeFirst() + ".");
            while (! queue.isEmpty()) {
                for (int j=circleRed.length;j>0;j--){
                    gdp1.add((Node) ((LinkedList<?>) queue).removeFirst(),1,0);
                    if(circleRed[j].equals(8)){
                        circleRed[j].setRadius(0);
                    }
                }

            }*/
            for(int i=(circleRed.length-1);i>0;i--){
                circleRed[i]=new Circle();
                circleRed[i].setFill(Color.WHITE);
                circleRed[i].setRadius(15);
                gdp1.add(circleRed[i],1,i);
                tamaCircleRed=tamaCircleRed;
                tamaCircleRed--;
                for (int j=0;j<tamaCircleRed;j++){
                    circleRed[j]=new Circle();
                    circleRed[j].setFill(Color.RED);
                    circleRed[j].setRadius(15);
                    gdp1.add(circleRed[j],1,j);
                    //System.out.println(tamaCircleRed);
                }
                mostrarAlertInfo(null);
                //CrearPlantilla();
            }
        });
        hBox=new HBox();
        hBox.getChildren().addAll(btnCubre,btnSimular);
        vBox=new VBox();
        vBox.getChildren().addAll(hBox,gdp1);
        escena=new Scene(vBox,250,430);
    }

    private void mostrarAlertInfoBlue(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Info");
        alert.setContentText("Usuario con cubrebocas acaba de pasar");
        alert.showAndWait();
    }

    @FXML
    private void mostrarAlertInfo(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Info");
        alert.setContentText("Usuario sin cubrebocas acaba de pasar");
        alert.showAndWait();
    }


    private void CrearPlantilla() {
        rectangle1.setFill(Color.AQUA);
        rectangle1.setWidth(100);
        rectangle1.setHeight(100);
        rectangle2.setFill(Color.AQUA);
        rectangle2.setWidth(100);
        rectangle2.setHeight(100);


        gdp1.add(rectangle1,1,0);
        gdp1.add(rectangle2,0,0);
        CirculoRojo();
        for (int i=1;i<8;i++){
            circleBlue[i]=new Circle();
            circleBlue[i].setFill(Color.BLUE);
            circleBlue[i].setRadius(15);
            gdp1.add(circleBlue[i],0,i);
        }


    }

    private void CirculoRojo() {
        for (int j=1;j<circleRed.length;j++){
            circleRed[j]=new Circle();
            circleRed[j].setFill(Color.RED);
            circleRed[j].setRadius(15);
            gdp1.add(circleRed[j],1,j);
        }
    }


    @Override
    public void handle(Event event) {

    }
}
