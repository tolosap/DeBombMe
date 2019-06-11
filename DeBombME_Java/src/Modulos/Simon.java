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
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author pablo
 */
public class Simon implements Modulo {

    private boolean desarmado = false;
    private boolean continua = false;
    /////////
    private int indexActual;
    private final int EMPIEZA = 3;
    private int longSecuencia = 0;
    private ArrayList<String> sencuencia;
    private final String[] COLORES = {"g", "r", "y", "b"};

    @Override
    public boolean getDesarmado() {
        return desarmado;
    }

    @Override
    public void setDesarmado(boolean var) {
        this.desarmado = var;
        red.setOnMouseClicked(e -> {
        });
        blue.setOnMouseClicked(e -> {
        });
        green.setOnMouseClicked(e -> {
        });
        yellow.setOnMouseClicked(e -> {
        });
    }

    public Simon(String sec) {
        Platform.runLater(() -> {
            longSecuencia = sec.length();
            indexActual = 0;
            continua = true;
            sencuencia = new ArrayList<String>();
            generateRandomSequence();
            iniciaTransic(sencuencia);
        });
    }

    private void generateRandomSequence() {
        for (int i = 0; i < EMPIEZA; i++) {
            sencuencia.add(randomColor());
        }
    }

    public void anyadeSec() {
        sencuencia.add(randomColor());
    }

    private String randomColor() {
        return COLORES[(int) (Math.random() * 4)];
    }

    public void iniciaTransic(ArrayList<String> sencuencia) {
        if (Contexto.getFallos() == 3) {
            endGame();
            setDesarmado(true);
            circle.setFill(Color.RED);
        } else {
            SequentialTransition s = new SequentialTransition();
            s.setCycleCount(1);
            s.setAutoReverse(false);
            for (int i = 0; i < sencuencia.size(); i++) {
                switch (sencuencia.get(i)) {
                    case "g":
                        FadeTransition greenft = new FadeTransition(Duration.millis(300), green);
                        greenft.setAutoReverse(true);
                        greenft.setFromValue(1.0);
                        greenft.setToValue(0.1);
                        greenft.setCycleCount(2);
                        s.getChildren().add(greenft);
                        break;
                    case "r":
                        FadeTransition redft = new FadeTransition(Duration.millis(300), red);
                        redft.setAutoReverse(true);
                        redft.setFromValue(1.0);
                        redft.setToValue(0.1);
                        redft.setCycleCount(2);
                        s.getChildren().add(redft);
                        break;
                    case "y":
                        FadeTransition yellowft = new FadeTransition(Duration.millis(300), yellow);
                        yellowft.setAutoReverse(true);
                        yellowft.setFromValue(1.0);
                        yellowft.setToValue(0.1);
                        yellowft.setCycleCount(2);
                        s.getChildren().add(yellowft);

                        break;
                    case "b":
                        FadeTransition blueft = new FadeTransition(Duration.millis(300), blue);
                        blueft.setAutoReverse(true);
                        blueft.setFromValue(1.0);
                        blueft.setToValue(0.1);
                        blueft.setCycleCount(2);
                        s.getChildren().add(blueft);
                        break;
                }
            }
            s.play();
        }
    }

    public void checkSequence(String color) {
        if ((sencuencia.get(indexActual)).equalsIgnoreCase(color)) {
            if (indexActual == (sencuencia.size() - 1) && sencuencia.size() < longSecuencia) {
                anyadeSec();
                indexActual = 0;
                if (sencuencia.size() < longSecuencia) {
                    iniciaTransic(sencuencia);
                }
                continua = false;
            } else {
                continua = true;
            }
            if (sencuencia.size() == longSecuencia) {
                setDesarmado(true);
                circle.setFill(Color.GREEN);
                endGame();
            }
            if (continua) {
                indexActual++;
            }
        } else {
            endGame();
        }

    }

    public void endGame() {
        indexActual = 0;
        sencuencia.clear();
        if (!desarmado) {
            Contexto.setFallos();
            Contexto.pintaFallos();
        }
        if (!desarmado && Contexto.getFallos() < 3) {
            generateRandomSequence();
            iniciaTransic(sencuencia);
        }
    }

    //////
    public Rectangle red = new Rectangle(50, 50);
    public Rectangle blue = new Rectangle(50, 50);
    public Rectangle green = new Rectangle(50, 50);
    public Rectangle yellow = new Rectangle(50, 50);

    public static Circle circle = new Circle(8);

    public BorderPane testScene() {
        BorderPane border = new BorderPane();
        border.setPadding(new Insets(10, 25, 25, 25));
        border.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-color: black;");
        border.setMinSize(Utilities.ANCHURA_CELDA, Utilities.ALTURA_CELDA);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        red.setFill(Color.RED);
        blue.setFill(Color.BLUE);
        green.setFill(Color.GREEN);
        yellow.setFill(Color.YELLOW);
        red.setStroke(Color.BLACK);
        blue.setStroke(Color.BLACK);
        green.setStroke(Color.BLACK);
        yellow.setStroke(Color.BLACK);

        red.setOnMouseClicked(e -> {
            if (Contexto.getFallos() < 3) {
                checkSequence("r");
            }
        });
        blue.setOnMouseClicked(e -> {
            if (Contexto.getFallos() < 3) {
                checkSequence("b");
            }
        });
        green.setOnMouseClicked(e -> {
            if (Contexto.getFallos() < 3) {
                checkSequence("g");
            }
        });
        yellow.setOnMouseClicked(e -> {
            if (Contexto.getFallos() < 3) {
                checkSequence("y");
            }
        });

        grid.add(red, 0, 0);
        grid.add(blue, 0, 1);
        grid.add(green, 1, 0);
        grid.add(yellow, 1, 1);

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
