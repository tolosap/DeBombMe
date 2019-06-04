/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos;

import Helpers.Contexto;
import Helpers.Utilities;
import Interfaces.Modulo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import pojos.ModSimbolos;

/**
 *
 * @author Pablo
 */
public class Simbolos implements Modulo {

    private boolean desarmado = false;
    private List<ModSimbolos> listaSimbolos;

    //
    private int pulsaciones = 0;
    private String respuestaString = "";

    public Simbolos() {

    }

    public Simbolos(Set simbolos) {
        listaSimbolos = new ArrayList<ModSimbolos>(simbolos);
        List<Integer> listaRespuesta = new ArrayList<>();
        for (ModSimbolos simbolo : listaSimbolos) {
            listaRespuesta.add(simbolo.getSimboloId());
        }
        Collections.sort(listaRespuesta);
        for (Integer integ : listaRespuesta) {
            respuestaString += integ;
        }
        System.out.println(respuestaString);
    }

    @Override
    public boolean getDesarmado() {
        return desarmado;
    }

    @Override
    public void setDesarmado(boolean var) {
        this.desarmado = var;
    }

    private String respuesta = "";

    public void comprueba() {
        if (pulsaciones == 4 && Contexto.getFallos() < 3) {
            if (respuesta.equals(respuestaString)) {
                setDesarmado(true);
                circle.setFill(Color.GREEN);
            } else {
                Contexto.setFallos();
                respuesta = "";
                pulsaciones = 0;
            }
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
        grid.setPadding(new Insets(25));
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        Button bt1 = new Button(listaSimbolos.get(0).getSimbolo());
        bt1.setOnAction(e -> {
            pulsaciones++;
            respuesta += listaSimbolos.get(0).getSimboloId();
            comprueba();
        });
        Button bt2 = new Button(listaSimbolos.get(1).getSimbolo());
        bt2.setOnAction(e -> {
            pulsaciones++;
            respuesta += listaSimbolos.get(1).getSimboloId();
            comprueba();
        });
        Button bt3 = new Button(listaSimbolos.get(2).getSimbolo());
        bt3.setOnAction(e -> {
            pulsaciones++;
            respuesta += listaSimbolos.get(2).getSimboloId();
            comprueba();
        });
        Button bt4 = new Button(listaSimbolos.get(3).getSimbolo());
        bt4.setOnAction(e -> {
            pulsaciones++;
            respuesta += listaSimbolos.get(3).getSimboloId();
            comprueba();
        });

        bt1.setMinSize(50, 50);
        bt2.setMinSize(50, 50);
        bt3.setMinSize(50, 50);
        bt4.setMinSize(50, 50);
        bt1.setStyle("-fx-font-size: 20px;");
        bt2.setStyle("-fx-font-size: 20px;");
        bt3.setStyle("-fx-font-size: 20px;");
        bt4.setStyle("-fx-font-size: 20px;");

        grid.add(bt1, 0, 0);
        grid.add(bt2, 1, 0);
        grid.add(bt3, 0, 1);
        grid.add(bt4, 1, 1);

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
