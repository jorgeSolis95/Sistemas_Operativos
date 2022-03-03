module com.example.tarea1sistemasoperativos {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tarea1sistemasoperativos to javafx.fxml;
    exports com.example.tarea1sistemasoperativos;
}