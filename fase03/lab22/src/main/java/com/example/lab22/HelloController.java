package com.example.lab22;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class HelloController {
    @FXML
    private GridPane gridPane = new GridPane();

    private Army a1 = new Army(1);
    private Army a2 = new Army(2);
    private Board map = new Board();
    private static int actualTurn = 1;
    private int nEj1 = a1.getSoldiers().size();
    private int nEj2 = a2.getSoldiers().size();
    private boolean gameOver = false;
    private CountDownLatch buttonClickLatch = new CountDownLatch(1);

    @FXML
    private VBox rootVBox;


    @FXML
    public void initialize() {
        initializeBoard();
        runGame();
    }

    public void runGame() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            if (!gameOver) {
                gameOver();
                placeSoldiers();

            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }
    private void initializeBoard(){
        map.initializeTable();
        map.initializeArmy(a1);
        map.initializeArmy(a2);
    }

    private void placeSoldiers() {

        int rowCount = 1;
        int colCount = 1;

        for (javafx.scene.Node node : gridPane.getChildren()) {
            Soldier s = map.getTable()[rowCount - 1][colCount - 1];
            String color = s.getColor();
            String n = s.getAlias();
            if (node instanceof Button) {
                Button button = (Button) node;
                String buttonName = n;
                button.setText(buttonName);
                button.setStyle("-fx-background-color: " + color);
                colCount++;

                if (colCount > 10) {
                    colCount = 1;
                    rowCount++;
                }
            }
        }
    }
    public void onButtonClick(MouseEvent event){
        if (event.getSource() instanceof Button) {
            Button clickedButton = (Button) event.getSource();
            int columnIndex = GridPane.getColumnIndex(clickedButton);
            int rowIndex = GridPane.getRowIndex(clickedButton);
            Soldier s = map.getTable()[rowIndex][columnIndex];
            if(s.getStatus()){
                if(s.getArmyId() == actualTurn){
                    String res = showInputAlert(s);
                    if(res == null){
                        return;
                    }

                    int x = Integer.parseInt(res.split(", ")[0]);
                    int y = Integer.parseInt(res.split(", ")[1]);
                    Soldier s2 = map.getTable()[y][x];

                    if((Math.abs(columnIndex - x) > 1) || (Math.abs(rowIndex - y) > 1)){
                        showAlert("Casilla inválida (Solo puedes moverte una casilla en cada dirección)", "Error");
                    }else{
                        if(s2.getStatus()){
                            if(s2.getArmyId() == s.getArmyId()){
                                showAlert("No se permite el fuego aliado", "Error");
                            }else {
                                battle(s, s2);
                            }
                        }else{
                            move(s, s2);
                        }
                    }
                }else{
                    showAlert("Elige un soldado de tu propio Ejército", "Error");
                }
            }

        }
    }

    private String showInputAlert(Soldier s){
        String text = s.getName() + " " + s.getHP() + " HP";
        TextInputDialog dialog = new TextInputDialog(null);
        dialog.setTitle("Input Dialog");
        dialog.setHeaderText(text + " ha sido seleccionado");
        dialog.setContentText("Coordenadas de destino (x, y): ");
        Optional<String> result = dialog.showAndWait();
        return result.orElse(null);
    }
    private static void showAlert(String contentText, String title) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
    private void battle(Soldier s1, Soldier s2){
        Soldier winner = Soldier.winner(s1, s2);

        if(winner.getArmyId() == 1){
            nEj2--;
        }else{
            nEj1--;
        }


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Batalla");
        alert.setHeaderText(null);
        alert.setContentText("Los dos soldados batallaron, el ganador fue: " + winner.getName());

        alert.showAndWait();

        s2.copy(winner);
        s1.destroy();

    }
    public static void move(Soldier s1, Soldier s2){
        s2.copy(s1);
        s1.destroy();
    }
    public void gameOver(){
            if (nEj1 == 0 || nEj2 == 0) {
                gameOver = true;
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Juego Terminado");
                alert.setHeaderText(null);
                alert.setContentText("El ganador es el Ejército " + (nEj1 == 0 ? 2 : 1));
                alert.showAndWait();
                // Cerrar la aplicación después de mostrar el mensaje de juego terminado
                Platform.exit();
            }
    }
    public void changeTurn(MouseEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Confirmación");
        alerta.setHeaderText("¿Quieres terminar tu turno?");
        alerta.setContentText("Por favor, elige una opción.");

        // Personalizar los botones de la alerta
        ButtonType botonSi = new ButtonType("Sí");
        ButtonType botonNo = new ButtonType("No");
        alerta.getButtonTypes().setAll(botonSi, botonNo);

        // Mostrar la alerta y esperar a que el usuario elija una opción
        alerta.showAndWait().ifPresent(resultado -> {
            if (resultado == botonSi) {
                actualTurn = (actualTurn == 1) ? 2 : 1;
            }
        });

    }

    // Método para cerrar la ventana
    @FXML
    private void handleCloseButton(MouseEvent event) {
        Stage stage = (Stage) rootVBox.getScene().getWindow();
        stage.close();
    }

    // Método para minimizar la ventana
    @FXML
    private void handleMinimizeButton(MouseEvent event) {
        Stage stage = (Stage) rootVBox.getScene().getWindow();
        stage.setIconified(true);
    }

    // Método para expandir/ restaurar la ventana (puedes personalizar según tus necesidades)
    @FXML
    private void handleExpandButton(MouseEvent event) {
        Stage stage = (Stage) rootVBox.getScene().getWindow();
        if (stage.isMaximized()) {
            stage.setMaximized(false);
        } else {
            stage.setMaximized(true);
        }
    }

}