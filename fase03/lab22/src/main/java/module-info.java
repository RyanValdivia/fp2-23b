module com.example.lab22 {
    requires javafx.controls;
    requires javafx.fxml;


    opens Lab22 to javafx.fxml;
    exports Lab22;
}