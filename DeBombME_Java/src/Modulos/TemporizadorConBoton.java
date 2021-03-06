/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos;

import Helpers.Contexto;
import Helpers.Utilities;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

/**
 *
 * @author Pablo
 */
public class TemporizadorConBoton implements Runnable {

    private int tiempo = 0;
    private int tiempoTotal = 0;
    private Label lbl = new Label();

    public static Thread hilo = null;

    public TemporizadorConBoton(int value) {
        this.tiempo = value;
        this.tiempoTotal = value;
    }

    public void start() {
        if (hilo == null) {
            hilo = new Thread(this); // creo el hilo
            hilo.start(); // lanzo hilo
        }
    }
    
    public static void stop(){
        hilo = null;
    }

    @Override
    public void run() {
        Thread hiloActual = Thread.currentThread();
        while (hiloActual == hilo) {
            if (Contexto.fallos < 2) {
                Platform.runLater(() -> {
                    if (tiempo != 0) {
                        llenaContador();
                        tiempo--;
                    } else {
                        llenaContador();
                        Contexto.setFallos();
                        Contexto.pintaFallos();
                        tiempo = tiempoTotal;
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (Contexto.fallos == 2) {
                Platform.runLater(() -> {
                    if (tiempo != 0) {
                        llenaContador();
                        tiempo--;
                    } else {
                        llenaContador();
                        Contexto.setFallos();
                        Contexto.pintaFallos();
                        tiempo = tiempoTotal;
                    }
                });
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    public void llenaContador() {
        int minutes = (tiempo % 3600) / 60;
        int seconds = tiempo % 60;
        if (String.valueOf(seconds).length() == 1) {
            lbl.setText("0" + minutes + ":0" + seconds);
        } else {
            lbl.setText("0" + minutes + ":" + seconds);
        }
    }

    public static Circle circle = new Circle(8);

    public BorderPane testScene() {
        BorderPane border = new BorderPane();
        border.setPadding(new Insets(10, 25, 25, 25));
        border.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-color: black;");
        border.setMinSize(Utilities.ANCHURA_CELDA, Utilities.ALTURA_CELDA);

        GridPane grid = new GridPane();
        grid.setVgap(7);
        grid.setAlignment(Pos.CENTER);

        Button btn = new Button("Reset");
        btn.setOnAction(e -> {
            tiempo = tiempoTotal;
            llenaContador();
        });
        btn.setMinSize(100, 35);

        lbl.setFont(new Font("Arial", 36));

        grid.add(lbl, 0, 0);
        grid.add(btn, 0, 1);

        circle.setFill(Color.BLACK);
        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER_RIGHT);
        hb.setPadding(new Insets(0, 0, 5, 0));
        hb.getChildren().add(circle);

        border.setTop(hb);
        border.setCenter(grid);

        return border;
    }
}
