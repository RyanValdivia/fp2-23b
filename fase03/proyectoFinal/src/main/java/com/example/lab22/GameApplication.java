package com.example.lab22;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApplication extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StartMenu.fxml"));
        Parent root = loader.load();

        // Crear una nueva escena y configurarla
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Menú Principal"); // Puedes cambiar el título según tu necesidad

        // Mostrar la ventana de inicio
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}



