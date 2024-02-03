package com.example.lab22;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class StartController {
    @FXML
    private Button newGameButton;

    @FXML
    private Button loadGameButton;

    @FXML
    public void initialize() {
        // Configura acciones para los botones
        newGameButton.setOnAction(event -> startNewGame());
        loadGameButton.setOnAction(event -> loadGame());
    }

    private void startNewGame() {
        // Cierra la ventana actual
        Stage stage = (Stage) newGameButton.getScene().getWindow();
        stage.close();

        // Abre la ventana principal del juego
        openGameWindow();
    }

    private void loadGame() {
        // Cierra la ventana actual
        Stage stage = (Stage) loadGameButton.getScene().getWindow();
        stage.close();

        // Mostrar el cuadro de diálogo para cargar archivo en el hilo de la interfaz de usuario
        Platform.runLater(() -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Cargar Partida");
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Archivos de Texto (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(stage);

            if (file != null) {
                // Abre la ventana principal del juego y pasa el archivo seleccionado
                openGameWindow(file);
            }
        });
    }

    private void openGameWindow(File file) {
        try {
            // Cargar el FXML y el controlador de la ventana principal
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VideoJuego.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la ventana principal
            VideoGameController gameController = loader.getController();

            // Pasar el archivo al controlador de la ventana principal
            gameController.readFromFile(file);

            Scene scene = new Scene(root, 670, 670);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("VideoJuego");

            // Mostrar la ventana principal
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void openGameWindow() {
        try {
            // Cargar el FXML y el controlador de la ventana principal
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VideoJuego.fxml"));
            Parent root = loader.load();

            // Crear una nueva escena y configurarla
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("VideoJuego"); // Puedes cambiar el título según tu necesidad

            // Mostrar la ventana principal
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
