module com.example.lab22 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.lab22 to javafx.fxml;
    exports com.example.lab22;
}