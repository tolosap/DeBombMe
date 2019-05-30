/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Helpers.Contexto;
import Helpers.Utilities;
import Modulos.*;
import java.io.File;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import pojos.Bomba;

/**
 *
 * @author DAM 6J
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Stage primStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primStage = primaryStage;
        BorderPane border = new BorderPane();
        border.setId("grid");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(10);

        TextField user = new TextField();
        user.setPromptText("Usuario");
        GridPane.setHalignment(user, HPos.CENTER);
        grid.add(user, 0, 1);
        user.setId("usertxt");

        PasswordField pass = new PasswordField();
        pass.setPromptText("Contraseña");
        GridPane.setHalignment(pass, HPos.CENTER);
        grid.add(pass, 0, 2);
        pass.setId("passtxt");

        Button login = new Button("Login");
        login.setMaxWidth(Double.POSITIVE_INFINITY);
        login.setOnAction(e -> {
            if (login.getText().equalsIgnoreCase("login")) {
                if (user.getText().equals("") || pass.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Rellena todos los campos para poder loguearte");
                } else {
                    boolean log = Utilities.login(user.getText(), pass.getText());
                    Contexto.setLogueado(log);
                    if (log) {
                        primStage.setScene(niveles());
                    } else {
                        JOptionPane.showMessageDialog(null, "Error, comprueba tu usuario o contraseña", "Error", JOptionPane.WARNING_MESSAGE);
                        pass.setText("");
                    }
                }
            } else {
                if (user.getText().equals("") || pass.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Rellena todos los campos para poder registrarte");
                } else {
                    boolean reg = Utilities.registro(user.getText(), pass.getText());
                    if (reg) {
                        Utilities.login(user.getText(), pass.getText());
                        primStage.setScene(niveles());
                    }
                }
            }

        });
        GridPane.setHalignment(login, HPos.CENTER);
        grid.add(login, 0, 3);
        login.setId("btn");

        //animacion
        FadeTransition fd = new FadeTransition(Duration.INDEFINITE.seconds(4), grid);
        fd.setFromValue(0.4);
        fd.setToValue(1);
        fd.play();

        //dropshadow
        DropShadow drop = new DropShadow();
        drop.setOffsetY(1.5);
        user.setEffect(drop);
        pass.setEffect(drop);
        //login.setEffect(drop);

        Button registroTxt = new Button("Registrarse");
        registroTxt.setId("botonRegistro");
        registroTxt.setOnAction(e -> {
            if (registroTxt.getText().equalsIgnoreCase("Registrarse")) {
                registroTxt.setText("Loguearse ");
                login.setText("Registro");
            } else {
                registroTxt.setText("Registrarse");
                login.setText("Login");
            }
        });
        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER_RIGHT);
        hb.setPadding(new Insets(0, 20, 20, 0));
        hb.getChildren().add(registroTxt);

        border.setBottom(hb);
        border.setCenter(grid);

        Scene scene = new Scene(border, Utilities.PRIMERA_ANCHURA, Utilities.PRIMERA_ALTURA);
        primaryStage.setScene(scene);
        primaryStage.setTitle("DeBombMe");
        primaryStage.setResizable(false);
        scene.getStylesheets().add(Main.class.getResource("css/Stage1.css").toExternalForm());
        primaryStage.show();
    }

    public Scene niveles() {
        BorderPane border = new BorderPane();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 0, 75, 15));
        grid.setId("selectLvl");
        grid.setVgap(50);
        grid.setHgap(50);
        grid.setId("grid");

        Button niv1 = new Button("Nivel 1");
        niv1.setId("btn");
        niv1.setOnAction(e -> {
            Bomba b = Utilities.dameBomba(1);
            primStage.setScene(montaBomba(b));
        });
        Button niv2 = new Button("Nivel 2");
        niv2.setOnAction(e -> {
            Bomba b = Utilities.dameBomba(2);
            primStage.setScene(montaBomba(b));
        });
        Button niv3 = new Button("Nivel 3");
        niv3.setOnAction(e -> {
            Bomba b = Utilities.dameBomba(3);
            primStage.setScene(montaBomba(b));
        });
        Button niv4 = new Button("Nivel 4");
        niv4.setOnAction(e -> {
            Bomba b = Utilities.dameBomba(4);
            primStage.setScene(montaBomba(b));
        });
        Button niv5 = new Button("Nivel 5");
        niv5.setOnAction(e -> {
            Bomba b = Utilities.dameBomba(5);
            primStage.setScene(montaBomba(b));
        });
        Button niv6 = new Button("Nivel 6");
        niv6.setOnAction(e -> {
            Bomba b = Utilities.dameBomba(6);
            primStage.setScene(montaBomba(b));
        });
        Button random = new Button("Random");
        random.setOnAction(e -> {
            Bomba b = Utilities.dameBomba((int) (Math.random() * 6));
            primStage.setScene(montaBomba(b));
        });
        niv2.setId("btn");
        niv3.setId("btn");
        niv4.setId("btn");
        niv5.setId("btn");
        niv6.setId("btn");
        random.setId("btn");

        grid.add(niv1, 0, 0);
        grid.add(niv2, 1, 0);
        grid.add(niv3, 2, 0);
        grid.add(niv4, 0, 1);
        grid.add(niv5, 1, 1);
        grid.add(niv6, 2, 1);
        grid.add(random, 1, 2);

        border.setCenter(grid);
        Scene sc = new Scene(border, Utilities.PRIMERA_ANCHURA, Utilities.PRIMERA_ALTURA);
        sc.getStylesheets().add(Main.class.getResource("css/Stage2.css").toExternalForm());

        return sc;
    }

    public Scene montaBomba(Bomba bomba) {
        Contador cont = new Contador(bomba.getModContador().getValor());
        Simon sim = new Simon(bomba.getModSimon().getSecuencia());
        Simbolos simbolos = new Simbolos(bomba.getModSimboloses());
        Password password = new Password(bomba.getModPassword().getTexto());
        CountdownButton countdown = new CountdownButton(bomba.getModBoton());
        TemporizadorConBoton tempo = new TemporizadorConBoton(bomba.getModTemporizador().getValor());

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.add(cont.testStage(), 0, 0);
        grid.add(sim.testScene(), 1, 0);
        grid.add(countdown.testScene(), 2, 0);
        grid.add(password.testScene(), 0, 1);
        grid.add(simbolos.testScene(), 1, 1);
        grid.add(tempo.testScene(), 2, 1);

        cont.start();
        tempo.start();

        Scene scene = new Scene(grid, Utilities.PRIMERA_ANCHURA, Utilities.PRIMERA_ALTURA);
        return scene;
    }

}
