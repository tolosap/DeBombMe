
import Connector.Singleton;
import java.awt.Color;

import Modulos.Contador;
/*import javafx.application.Application;
 import javafx.stage.Stage;*/
import Modulos.Simon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pablo
 */
public class Pruebas {
    
    private static boolean logged = false;
    
    private static void setLogged(boolean log){
        logged = log;
    }
    
    private static boolean getLogged(){
        return logged;
    }

    public static void main(String[] args) throws SQLException {
        Pruebas test = new Pruebas();
        test.dameBomba(1);
    }
    
    public void dameBomba(int nivel) throws SQLException{
        Connection oCon = Singleton.getInstance();
        String sql = "SELECT * FROM bomba WHERE BombaID = ?";
        PreparedStatement sent = oCon.prepareStatement(sql);
        sent.setInt(1, nivel);
        ResultSet rs = sent.executeQuery();
        while (rs.next()) {            
            System.out.println();
        }
    }

    public void login(String user, String pass) throws SQLException {
        Connection oCon = Singleton.getInstance();
        String sql = "SELECT * FROM usuario WHERE nombre = ? AND password = ?";
        PreparedStatement sent = oCon.prepareStatement(sql);
        sent.setString(1, user);
        sent.setString(2, pass);
        ResultSet rs = sent.executeQuery();
        String test = "";
        while (rs.next()) {
            test = rs.getString("usuarioid");
        }
        if (test != null && !test.equalsIgnoreCase("")) {
            System.out.println("Bienvenido al sistema.");
            setLogged(true);
        } else {
            System.out.println("Lo siento, sus datos no aparecen en la base de datos.");
        }
        oCon.close();

    }

}
