package com.example.views;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Simulacion extends Stage implements EventHandler {
    private VBox vBox;
    private GridPane gdp1;
    private Scene escena;
    private Rectangle rectangle;
    public Simulacion(){
        CrearUI();
        this.setTitle("Simulacion de entrada");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        gdp1=new GridPane();
        rectangle=new Rectangle();
        CrearPlantilla();
        vBox=new VBox();
        vBox.getChildren().addAll(gdp1);
        escena=new Scene(vBox,350,530);
    }

    private void CrearPlantilla() {
        rectangle.setFill(Color.AQUA);
        rectangle.setWidth(350);
        rectangle.setHeight(100);
        gdp1.getChildren().add(rectangle);

    }

    @Override
    public void handle(Event event) {

    }
}
