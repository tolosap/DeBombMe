package Modulos;

import Helpers.Contexto;
import Helpers.Utilities;
import Interfaz.Main;
import java.io.*;
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
import javax.swing.JOptionPane;

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

    private static Thread hilo = null;
    private int segundosC; //en milesimas

    public Contador(int segundos) {
        segundosC = segundos;
    }

    public static void stop() {
        hilo = null;
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
            if (Contexto.fallos == 0 && segundosC > 0) {
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
            if (Contexto.fallos == 1 && segundosC > 0) {
                Platform.runLater(() -> {
                    llenaContador();
                    valueSec = segundosC;
                    segundosC--;
                });
                try {
                    Thread.sleep(550);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (Contexto.fallos == 2 && segundosC > 0) {
                Platform.runLater(() -> {
                    llenaContador();
                    valueSec = segundosC;
                    segundosC--;
                });
                try {
                    Thread.sleep(450);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (Contexto.fallos == 3 || segundosC == 0) {
                TemporizadorConBoton.stop();
                Simon.circle.setFill(Color.RED);
                TemporizadorConBoton.circle.setFill(Color.RED);
                CountdownButton.circle.setFill(Color.RED);
                Password.circle.setFill(Color.RED);
                Simbolos.circle.setFill(Color.RED);
                try {
                    JOptionPane.showMessageDialog(null, "¡Has perdido!");
                    Thread.sleep(1250);
                    Platform.runLater(() -> {
                        Main.primStage.setScene(Main.niveles());
                    });
                    hilo = null;
                } catch (InterruptedException ex) {
                    Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (Password.circle.getFill() == Color.GREEN && CountdownButton.circle.getFill() == Color.GREEN && Simbolos.circle.getFill() == Color.GREEN && Simon.circle.getFill() == Color.GREEN) {
                TemporizadorConBoton.stop();
                try {
                    JOptionPane.showMessageDialog(null, "¡Has ganado!");
                    Thread.sleep(1250);
                    Platform.runLater(() -> {
                        Main.primStage.setScene(Main.niveles());
                    });
                    hilo = null;
                } catch (InterruptedException ex) {
                    Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    ///////////////////zona pane
    private int valueSec = 0;
    private Label tiempo = new Label("00:00");
    public static int contadorSeconds = 0;

    public static Circle strike1 = new Circle(8);
    public static Circle strike2 = new Circle(8);
    public static Circle strike3 = new Circle(8);

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
                ClassLoader classLoader = getClass().getClassLoader();
                File f = new File(classLoader.getResource("Helpers/Manual2.txt").getFile());
                String filename = f.getAbsolutePath();
                TextArea area = new TextArea();
                try {
                    FileReader reader = new FileReader(filename);
                    BufferedReader br = new BufferedReader(reader);
                    String line;
                    while ((line = br.readLine()) != null) {
                        area.appendText(line + "\n");
                    }
                } catch (FileNotFoundException ex) {
                    System.err.println(ex);
                } catch (IOException ex) {
                    Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
                }
                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(area);

                Scene secondScene = new Scene(secondaryLayout, 400, 400);

                Stage newWindow = new Stage();
                newWindow.setTitle("Instrucciones");
                newWindow.setScene(secondScene);

                newWindow.show();
                area.setScrollTop(0);
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
