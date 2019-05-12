/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Helpers.Contexto;
import Helpers.Utilities;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author DAM 6J
 */
public class Login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane border = new BorderPane();
        border.setPadding(new Insets(20, 50, 50, 50));
        border.setId("grid");
        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(10, 0, 20, 0));

        GridPane loginPane = new GridPane();
        loginPane.setPadding(new Insets(10, 0, 0, 15));
        loginPane.setId("loginpane");
        loginPane.setVgap(5);
        loginPane.setHgap(7);
        Reflection reflection = new Reflection();
        reflection.setFraction(0.6);
        loginPane.setEffect(reflection);

        // se crean los elementos
        Text welcome = new Text("JavaFX 2 Login");
        welcome.setId("welcome");
        //dropshadow
        DropShadow drop = new DropShadow();
        drop.setOffsetX(5);
        drop.setOffsetY(5);
        welcome.setEffect(drop);
        //
        Label user = new Label("Username");
        TextField usertx = new TextField();
        Label pass = new Label("Password");
        TextField passtx = new TextField();
        Button login = new Button("Login");
        login.setId("login");
        login.setOnAction(e -> {
            boolean log = Utilities.login(usertx.getText(), passtx.getText());
            Contexto.setLogueado(log);
            if (log) {
                primaryStage.setScene(new Scene(new VBox(10), 250, 150));
            }

        });

        //se añaden a las boxes
        hb.getChildren().add(welcome);

        loginPane.add(user, 0, 0);
        loginPane.add(usertx, 1, 0);
        loginPane.add(pass, 0, 1);
        loginPane.add(passtx, 1, 1);
        loginPane.add(login, 2, 1);

        //se añade todo al grid
        border.setTop(hb);
        border.setCenter(loginPane);

        //se crea la escena
        Scene scene = new Scene(border, 407, 326);
        primaryStage.setScene(scene);
        primaryStage.titleProperty().bind(scene.widthProperty().asString().concat(" : ").concat(scene.heightProperty().asString()));

        //scene.getStylesheets().add(Test.class.getResource("/css/Login.css").toExternalForm());
        primaryStage.show();
    }

}
