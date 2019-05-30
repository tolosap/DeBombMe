package Modulos;

import Helpers.Contexto;
import Helpers.Utilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pablo
 */
public class Contador implements Runnable {

    private Thread hilo = null;
    private int segundosC; //en milesimas

    public Contador(int segundos) {
        segundosC = segundos;
    }

    public void start() {
        if (hilo == null) {
            Contexto.fallos = 0;
            hilo = new Thread(this); // creo el hilo
            hilo.start(); // lanzo hilo
        }
    }

    @Override
    public void run() {
        Thread hiloActual = Thread.currentThread();
        while (hiloActual == hilo) {
            if (Contexto.fallos == 0) {
                Platform.runLater(() -> {
                    valueSec = segundosC;
                    llenaContador();
                    segundosC--;
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (Contexto.fallos == 1) {
                Platform.runLater(() -> {
                    llenaContador();
                    valueSec = segundosC;
                    segundosC--;
                });
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (Contexto.fallos == 2) {
                Platform.runLater(() -> {
                    llenaContador();
                    valueSec = segundosC;
                    segundosC--;
                });
                try {
                    Thread.sleep(250);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (Contexto.fallos == 3) {

            }
        }
    }

    ///////////////////zona pane
    private int valueSec = 0;
    private Label tiempo = new Label("00:00");
    public static int contadorSeconds = 0;

    public Circle strike1 = new Circle(8);
    public Circle strike2 = new Circle(8);
    public Circle strike3 = new Circle(8);

    public static long getSegundos() {
        return contadorSeconds;
    }

    public void llenaContador() {
        int minutes = (valueSec % 3600) / 60;
        contadorSeconds = valueSec % 60;
        if (contadorSeconds == 0) {
            tiempo.setText("0" + minutes + ":" + contadorSeconds + "0");
        } else {
            if (String.valueOf(contadorSeconds).length() == 1) {
                tiempo.setText("0" + minutes + ":0" + contadorSeconds);
            } else {
                tiempo.setText("0" + minutes + ":" + contadorSeconds);
            }
        }
    }

    public BorderPane testStage() {
        BorderPane border = new BorderPane();
        border.setPadding(new Insets(10, 25, 25, 25));
        border.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-color: black;");
        border.setMinSize(Utilities.ANCHURA_CELDA, Utilities.ALTURA_CELDA);

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        tiempo.setFont(new Font("Arial", 42));
        pane.add(tiempo, 0, 0);

        strike1.setFill(Color.BLACK);
        strike2.setFill(Color.BLACK);
        strike3.setFill(Color.BLACK);

        HBox hb = new HBox();
        hb.setSpacing(5);
        hb.setAlignment(Pos.CENTER_RIGHT);
        hb.setPadding(new Insets(0, 0, 5, 0));
        hb.getChildren().addAll(strike1, strike2, strike3);

        HBox hb2 = new HBox();
        Button instr = new Button("Instrucciones");
        instr.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                TextArea area = new TextArea();
                try {
                    Scanner s = new Scanner(new File("/Helpers/Manual.txt")).useDelimiter("\\s+");
                    while (s.hasNext()) {
                        if (s.hasNextInt()) { // check if next token is an int
                            area.appendText(s.nextInt() + " "); // display the found integer
                        } else {
                            area.appendText(s.next() + " "); // else read the next token
                        }
                    }
                } catch (FileNotFoundException ex) {
                    System.err.println(ex);
                }

                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(area);

                Scene secondScene = new Scene(secondaryLayout, 300, 400);

                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Instrucciones");
                newWindow.setScene(secondScene);

                newWindow.show();
            }
        });
        hb2.setAlignment(Pos.CENTER);
        hb2.setPadding(new Insets(0, 0, 5, 0));
        hb2.getChildren().add(instr);

        border.setTop(hb);
        border.setCenter(pane);
        border.setBottom(hb2);
        return border;
    }

}
