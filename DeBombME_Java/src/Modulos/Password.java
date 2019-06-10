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
public class Password implements Modulo {

    private boolean desarmado = false;
    private String solucion = "";

    private static String cadena = "abcdefghijlmnopqrstuv";

    public Password(String palabra) {
        this.solucion = palabra;
        cadena = cadena.toUpperCase();
        btn1.setText(String.valueOf(cadena.charAt(0)));
        btn2.setText(String.valueOf(cadena.charAt(0)));
        btn3.setText(String.valueOf(cadena.charAt(0)));
        btn4.setText(String.valueOf(cadena.charAt(0)));
        btn5.setText(String.valueOf(cadena.charAt(0)));
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

    public void compruebaPassword() {
        if (desarmado) {

        } else {
            String solucionUser = btn1.getText() + "" + btn2.getText() + ""
                    + btn3.getText() + "" + btn4.getText() + "" + btn5.getText();
            if (solucion.equalsIgnoreCase(solucionUser)) {
                System.out.println("Perfecto.");
                setDesarmado(true);
                circle.setFill(Color.GREEN);
            } else {
                System.out.println("Error");
                Contexto.setFallos();
                Contexto.pintaFallos();
            }
        }

    }

    ///////////////panel
    private Button btn1 = new Button();
    private Button btn2 = new Button();
    private Button btn3 = new Button();
    private Button btn4 = new Button();
    private Button btn5 = new Button();

    private int index1 = 0;
    private int index2 = 0;
    private int index3 = 0;
    private int index4 = 0;
    private int index5 = 0;

    public static Circle circle = new Circle(8);

    public BorderPane testScene() {

        btn1.setOnAction(e -> {
            compruebaPassword();
        });
        btn2.setOnAction(e -> {
            compruebaPassword();
        });
        btn3.setOnAction(e -> {
            compruebaPassword();
        });
        btn4.setOnAction(e -> {
            compruebaPassword();
        });
        btn5.setOnAction(e -> {
            compruebaPassword();
        });

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
        arrowUp1.setOnMouseClicked(e -> {
            if (index1 < 20) {
                index1++;
            } else {
                index1 = 0;
            }
            btn1.setText(String.valueOf(cadena.charAt(index1)));
        });
        ImageView arrowUp2 = new ImageView(imgUp);
        arrowUp2.setOnMouseClicked(e -> {
            if (index2 < 20) {
                index2++;
                btn2.setText(String.valueOf(cadena.charAt(index2)));
            }
        });
        ImageView arrowUp3 = new ImageView(imgUp);
        arrowUp3.setOnMouseClicked(e -> {
            if (index3 < 20) {
                index3++;
                btn3.setText(String.valueOf(cadena.charAt(index3)));
            }
        });
        ImageView arrowUp4 = new ImageView(imgUp);
        arrowUp4.setOnMouseClicked(e -> {
            if (index4 < 20) {
                index4++;
                btn4.setText(String.valueOf(cadena.charAt(index4)));
            }
        });
        ImageView arrowUp5 = new ImageView(imgUp);
        arrowUp5.setOnMouseClicked(e -> {
            if (index5 < 20) {
                index5++;
                btn5.setText(String.valueOf(cadena.charAt(index5)));
            }
        });

        ImageView arrowDown1 = new ImageView(imgDown);
        ImageView arrowDown2 = new ImageView(imgDown);
        ImageView arrowDown3 = new ImageView(imgDown);
        ImageView arrowDown4 = new ImageView(imgDown);
        ImageView arrowDown5 = new ImageView(imgDown);
        arrowDown1.setOnMouseClicked(e -> {
            if (index1 > 0) {
                index1--;
            } else {
                index1 = 20;
            }
            btn1.setText(String.valueOf(cadena.charAt(index1)));
        });
        arrowDown2.setOnMouseClicked(e -> {
            if (index2 > 0) {
                index2--;
            } else {
                index2 = 20;
            }
            btn2.setText(String.valueOf(cadena.charAt(index2)));
        });
        arrowDown3.setOnMouseClicked(e -> {
            if (index3 > 0) {
                index3--;
            } else {
                index3 = 20;
            }
            btn3.setText(String.valueOf(cadena.charAt(index3)));
        });
        arrowDown4.setOnMouseClicked(e -> {
            if (index4 > 0) {
                index4--;
            } else {
                index4 = 20;
            }
            btn4.setText(String.valueOf(cadena.charAt(index4)));
        });
        arrowDown5.setOnMouseClicked(e -> {
            if (index5 > 0) {
                index5--;
            } else {
                index5 = 20;
            }
            btn5.setText(String.valueOf(cadena.charAt(index5)));
        });

        btn1.setMinSize(27, 20);
        btn2.setMinSize(27, 20);
        btn3.setMinSize(27, 20);
        btn4.setMinSize(27, 20);
        btn5.setMinSize(27, 20);

        pane.add(arrowUp1, 0, 0);
        pane.add(arrowUp2, 1, 0);
        pane.add(arrowUp3, 2, 0);
        pane.add(arrowUp4, 3, 0);
        pane.add(arrowUp5, 4, 0);
        pane.add(btn1, 0, 1);
        pane.add(btn2, 1, 1);
        pane.add(btn3, 2, 1);
        pane.add(btn4, 3, 1);
        pane.add(btn5, 4, 1);
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
