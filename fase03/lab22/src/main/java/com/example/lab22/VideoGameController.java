package com.example.lab22;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class VideoGameController {
    @FXML
    private GridPane gridPane = new GridPane();

    private Army a1;
    private Army a2;
    private Board map = new Board();
    private static int actualTurn = 1;
    private int nEj1;
    private int nEj2;
    private boolean gameOver = false;


    @FXML
    private VBox rootVBox;


    @FXML
    public void initialize() {
        initializeBoard();
        runGame();
    }

    public void runGame() {
        final boolean[] isAlertShown = {false};
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            if (!gameOver) {
                gameOver();
                placeSoldiers();
            } else if(!isAlertShown[0]){
                Platform.runLater(() -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Juego Terminado");
                    alert.setHeaderText(null);
                    alert.setContentText("El ganador es el Ejército " + (nEj1 == 0 ? 2 : 1));
                    ButtonType botonSi = new ButtonType("¿Jugar de Nuevo?");
                    ButtonType botonNo = new ButtonType("Salir");
                    alert.getButtonTypes().setAll(botonSi, botonNo);

                    alert.showAndWait().ifPresent(resultado -> {
                        if (resultado == botonSi) {
                            initializeBoard();
                            placeSoldiers();
                            gameOver = false;
                        }else{
                            Platform.exit();
                        }
                    });

                    // Cerrar la aplicación después de mostrar el mensaje de juego terminado
                });
                isAlertShown[0] = true;
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }
    private void initializeBoard(){
        map.initializeTable();
        a1 = new Army(1);
        a2 = new Army(2);
        map.initializeArmy(a1);
        map.initializeArmy(a2);
        nEj1 = a1.getSoldiers().size();
        nEj2 = a2.getSoldiers().size();
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
                    writeLog("El soldado " + s.getName() + " ha sido seleccionado");
                    getDirection(s);
                }else{
                    showAlert("Elige un soldado de tu propio Ejército", "Error");
                }
            }

        }
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

        writeLog("Los dos soldados batallaron, el ganador fue: " + winner.getName());

        alert.showAndWait();

        int x1 = s1.getX();
        int y1 = s1.getY();
        int x2 = s2.getX();
        int y2 = s2.getY();
        int x = winner.getX();
        int y = winner.getY();

        if(x1 == x && y1 == y){
            Soldier temp = map.getTable()[y2][x2];
            map.getTable()[y1][x1] = temp;
            map.getTable()[y2][x2] = winner;
            writeLog("El soldado " + map.getTable()[y1][x1] + " ha muerto");
            map.getTable()[y1][x1].destroy();
        }else{
            map.getTable()[y1][x1].destroy();
            writeLog("El soldado " + map.getTable()[y1][x1] + " ha muerto");
        }
    }
    private void move(Soldier s, int x, int y){
        Soldier s2 = map.getTable()[y][x];
        int oldX = s.getX();
        int oldY = s.getY();
        if(s2.getStatus()){
            if(s2.getArmyId() == s.getArmyId()){
                showAlert("No se permite el fuego aliado", "Error");
            }else{
                battle(s, s2);
                actualTurn = (actualTurn == 1) ? 2 : 1;
            }
        }else{
            s.setX(x);
            s.setY(y);
            s2.setX(oldX);
            s2.setY(oldY);

            writeLog("El soldado " + s.getName() + " se ha movido a: " + "(" + x + ", " + y + ")");

            Soldier temp = map.getTable()[y][x];
            map.getTable()[y][x] = s;
            map.getTable()[oldY][oldX] = temp;
            actualTurn = (actualTurn == 1) ? 2 : 1;

        }
    }
    public void gameOver(){
            if (nEj1 == 0 || nEj2 == 0) {
                gameOver = true;
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
    @FXML
    public void showRulesDialog(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Rules.fxml"));
            Parent rulesRoot = loader.load();

            Stage rulesStage = new Stage();
            rulesStage.initModality(Modality.APPLICATION_MODAL);
            rulesStage.setTitle("Reglas del Juego");

            Scene rulesScene = new Scene(rulesRoot, 400, 300);
            rulesStage.setScene(rulesScene);
            rulesStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final AtomicBoolean isMoveAlertShown = new AtomicBoolean(false);
    public void getDirection(Soldier s) {
        final boolean[] result = {false};
        String text = s.getName() + " " + s.getHP() + " HP";
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Confirmación");
        alerta.setHeaderText(text + " seleccionado");
        alerta.setContentText("Por favor, elige una opción.");

        ButtonType botonSi = new ButtonType("Mover Soldado");
        ButtonType botonNo = new ButtonType("Cancelar");
        alerta.getButtonTypes().setAll(botonSi, botonNo);

        alerta.showAndWait().ifPresent(resultado -> {
            if (resultado == botonSi) {
                Platform.runLater(() -> {
                    Alert moveAlert = new Alert(Alert.AlertType.INFORMATION);
                    moveAlert.setTitle("Mueve tu Soldado");
                    moveAlert.setHeaderText("Usa las teclas para mover tu soldado.");
                    moveAlert.setContentText("AWXD (vertical-horizontal), QEZC (diagonal) o S (no moverse)");

                    Scene moveScene = moveAlert.getDialogPane().getScene();
                    moveScene.setOnKeyPressed(event -> {
                        KeyCode pressedKey = event.getCode();

                        if (!isMoveAlertShown.get()) {
                            moveSoldado(pressedKey, s);
                            isMoveAlertShown.set(true);
                            moveAlert.close();
                        }
                    });

                    moveAlert.showAndWait();
                    isMoveAlertShown.set(false);
                });
            }
        });


    }
    private void moveSoldado(KeyCode key, Soldier s) {
        int x = 0, y = 0;

        switch (key) {
            case W:
                y = -1;
                break;
            case A:
                x = -1;
                break;
            case D:
                x = 1;
                break;
            case S:
                // No moverse en la posición actual
                break;
            case Q:
                x = -1;
                y = -1;
                break;
            case E:
                x = 1;
                y = -1;
                break;
            case Z:
                x = -1;
                y = 1;
                break;
            case C:
                x = 1;
                y = 1;
                break;
            case X:
                y = 1;
                break;
            default:
                break;
        }

        // Calcular la nueva posición
        int newY = s.getY() + y;
        int newX = s.getX() + x;

        // Verificar si la nueva posición es válida
        if (isValidMove(newX, newY)) {
            // Mover el soldado
            move(s, newX, newY);
            // Actualizar la posición del soldado en la matriz map.getTable()

        } else {
            showAlert("Casilla inválida (Solo puedes moverte una casilla en cada dirección)", "Error");
        }
    }

    // Método para verificar si la posición es válida
    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < 10 && y >= 0 && y < 10;
    }
    @FXML
    public void saveGame(MouseEvent event){
        // Crear un objeto FileChooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar Archivo");

        // Agregar una extensión al FileChooser (opcional)
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Archivos de Texto (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        Stage stage = (Stage) rootVBox.getScene().getWindow();

        // Mostrar el cuadro de diálogo para guardar archivo
        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            // El usuario ha seleccionado un archivo, ahora puedes escribir en él
            writeToFile(file);
        }
    }
    private synchronized void writeToFile(File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // Escribir contenido en el archivo
            writer.write("#" + a1.getId());
            writer.newLine();
            for(Soldier s: a1.getSoldiers()){
                writer.write(s.toString());
                writer.newLine();
            }
            writer.newLine();
            writer.write("#" + a2.getId());
            writer.newLine();
            for(Soldier s: a2.getSoldiers()){
                writer.write(s.toString());
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void loadGame(MouseEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Cargar Archivo");

        // Agregar una extensión al FileChooser (opcional)
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Archivos de Texto (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        Stage stage = (Stage) rootVBox.getScene().getWindow();

        // Mostrar el cuadro de diálogo para cargar archivo
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            // El usuario ha seleccionado un archivo, ahora puedes leer de él
            readFromFile(file);
        }
    }
    public void readFromFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            // Limpiar ejércitos existentes antes de cargar nuevos datos
            a1.clearSoldiers();
            a2.clearSoldiers();

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#")) {
                    // Identificar el ejército por el ID
                    int armyId = Integer.parseInt(line.substring(1));
                    Army currentArmy = (armyId == a1.getId()) ? a1 : a2;

                    // Leer las siguientes líneas correspondientes a los soldados
                    while ((line = reader.readLine()) != null && (!line.startsWith("#") && !line.trim().isEmpty())) {
                        // Crear un nuevo soldado a partir de la línea y agregarlo al ejército
                        Soldier soldier = Soldier.parseSoldier(line);
                        currentArmy.addSoldier(soldier);
                    }
                }
            }
            // Por ejemplo, volver a colocar los soldados en la interfaz gráfica
            map.initializeTable();
            nEj1 = a1.getSoldiers().size();
            nEj2 = a2.getSoldiers().size();
            map.deployArmy(a1);
            map.deployArmy(a2);

            placeSoldiers();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void rankingDialog(MouseEvent event){
        
    }
    public synchronized void writeLog(String statement){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"))) {
            writer.write(statement);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
