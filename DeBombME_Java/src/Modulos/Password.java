/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos;

import Helpers.Utilities;
import Interfaces.Modulo;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Pablo
 */
public class Password implements Modulo, Runnable {

    private Thread hilo = null;

    private boolean desarmado = false;
    private String solucion = "";

    private static String cadena1 = "abcdefghijklmnopqrstuvwxyz";
    private static String cadena2 = "abcdefghijklmnopqrstuvwxyz";
    private static String cadena3 = "abcdefghijklmnopqrstuvwxyz";
    private static String cadena4 = "abcdefghijklmnopqrstuvwxyz";
    private static String cadena5 = "abcdefghijklmnopqrstuvwxyz";

    public Password(String palabra) {
        this.solucion = palabra;
    }

    public Password() {

    }

    @Override
    public boolean getDesarmado() {
        return desarmado;
    }

    @Override
    public void setDesarmado(boolean var) {
        this.desarmado = var;
    }

    public void start() {
        if (hilo == null) {
            hilo = new Thread(this); // creo el hilo
            hilo.start(); // lanzo hilo
        }
    }

    @Override
    public void run() {
        Thread hiloActual = Thread.currentThread();
        List<String> lista = new ArrayList<String>();
        lista.add(cadena1);
        lista.add(cadena2);
        lista.add(cadena3);
        lista.add(cadena4);
        lista.add(cadena5);
        char[] passchar = solucion.toCharArray();
        int listaIter = 0;
        for (char c : passchar) {
            lista.get(listaIter).replace("a", "");
            System.out.println(lista);
            listaIter++;
        }
        while (hiloActual == hilo) {

        }
    }

    ///////////////panel
    private Button lb1 = new Button("A");
    private Button lb2 = new Button("R");
    private Button lb3 = new Button("P");
    private Button lb4 = new Button("J");
    private Button lb5 = new Button("P");

    public Circle circle = new Circle(8);

    public BorderPane testScene() {

        BorderPane border = new BorderPane();
        border.setPadding(new Insets(10, 25, 25, 25));
        border.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-color: black;");
        border.setMinSize(Utilities.ANCHURA_CELDA, Utilities.ALTURA_CELDA);

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5);
        pane.setVgap(3);

        Image imgUp = null;
        Image imgDown = null;
        try {
            imgUp = new Image(Password.class.getResourceAsStream("/img/up-arrow.png"));
            imgDown = new Image(Password.class.getResourceAsStream("/img/down-arrow.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ImageView arrowUp1 = new ImageView(imgUp);
        ImageView arrowUp2 = new ImageView(imgUp);
        ImageView arrowUp3 = new ImageView(imgUp);
        ImageView arrowUp4 = new ImageView(imgUp);
        ImageView arrowUp5 = new ImageView(imgUp);

        ImageView arrowDown1 = new ImageView(imgDown);
        ImageView arrowDown2 = new ImageView(imgDown);
        ImageView arrowDown3 = new ImageView(imgDown);
        ImageView arrowDown4 = new ImageView(imgDown);
        ImageView arrowDown5 = new ImageView(imgDown);

        lb1.setMaxSize(25, 20);
        lb2.setMaxSize(25, 20);
        lb3.setMaxSize(25, 20);
        lb4.setMaxSize(25, 20);
        lb5.setMaxSize(25, 20);

        pane.add(arrowUp1, 0, 0);
        pane.add(arrowUp2, 1, 0);
        pane.add(arrowUp3, 2, 0);
        pane.add(arrowUp4, 3, 0);
        pane.add(arrowUp5, 4, 0);
        pane.add(lb1, 0, 1);
        pane.add(lb2, 1, 1);
        pane.add(lb3, 2, 1);
        pane.add(lb4, 3, 1);
        pane.add(lb5, 4, 1);
        pane.add(arrowDown1, 0, 2);
        pane.add(arrowDown2, 1, 2);
        pane.add(arrowDown3, 2, 2);
        pane.add(arrowDown4, 3, 2);
        pane.add(arrowDown5, 4, 2);

        circle.setFill(Color.BLACK);
        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER_RIGHT);
        hb.setPadding(new Insets(0, 0, 5, 0));
        hb.getChildren().add(circle);

        border.setTop(hb);
        border.setCenter(pane);

        return border;
    }

}
