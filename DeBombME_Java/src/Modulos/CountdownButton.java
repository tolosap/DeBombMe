/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos;

import Helpers.Contexto;
import Helpers.Utilities;
import Interfaces.Modulo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import pojos.ModBoton;

/**
 *
 * @author Pablo
 */
public class CountdownButton implements Modulo {

    //hilo
    private Thread hilo = null;
    //modulo var
    private boolean desarmado = false;
    //data
    private Color color = null;
    private String texto = "";
    private int valor = 0;
    //interacciones
    private int soluci = 0;

    public CountdownButton(ModBoton modulo) {
        this.color = Color.web(modulo.getColor());
        this.texto = modulo.getTexto().toUpperCase();
        this.valor = modulo.getValor();
        if (color.equals(Color.GREEN)) {
            soluci = (modulo.getTexto().length() / 2) + valor + 1;
        } else if (color.equals(Color.BLUE)) {
            soluci = (modulo.getTexto().length() / 2) + valor + 2;
        } else {
            soluci = (modulo.getTexto().length() / 2) + valor + 3;
        }
    }

    public CountdownButton() {

    }

    @Override
    public boolean getDesarmado() {
        return desarmado;
    }

    @Override
    public void setDesarmado(boolean var) {
        this.desarmado = var;
    }

    public static Circle circle = new Circle(8);

    public BorderPane testScene() {
        BorderPane border = new BorderPane();
        border.setPadding(new Insets(10, 25, 25, 25));
        border.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-color: black;");
        border.setMinSize(Utilities.ANCHURA_CELDA, Utilities.ALTURA_CELDA);

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(10);
        pane.setHgap(10);

        Button boton = new Button(texto);
        boton.setStyle(
                "-fx-background-radius: 5em; "
                + "-fx-min-width: 75px; "
                + "-fx-min-height: 75px; "
                + "-fx-max-width: 75px; "
                + "-fx-max-height: 75px;"
                + "-fx-font-size: 15px;"
        );
        boton.setOnAction(e -> {
            if (Contexto.getFallos() < 3) {
                long valor = Contador.getSegundos();
                if (String.valueOf(valor).length() == 1) {
                    if (valor == soluci) {
                        setDesarmado(true);
                        circle.setFill(Color.GREEN);
                    } else {
                        Contexto.setFallos();
                    }
                } else {
                    long aux = Long.valueOf(String.valueOf(valor).substring(1));
                    if (aux == soluci) {
                        setDesarmado(true);
                        circle.setFill(Color.GREEN);
                    } else {
                        Contexto.setFallos();
                    }
                }
            }
        });
        Rectangle rectangle = new Rectangle(40, 125);
        rectangle.setFill(this.color);

        pane.add(boton, 0, 0);
        pane.add(rectangle, 1, 0);

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
