/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connector;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Connector {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
                
        Connection oCon = Singleton.getInstance();
        String sql = "SELECT * FROM usuario WHERE nombre = ? AND password = ?";
        PreparedStatement sent = oCon.prepareStatement(sql);
        sent.setString(1, "admin");
        sent.setString(2, "admin");
        ResultSet rs = sent.executeQuery();
        String test = "";
        while (rs.next()) {
            test = rs.getString("usuarioid");
        }
        if (test != null && !test.equalsIgnoreCase("")) {
            System.out.println("Bienvenido al sistema.");
        } else {
            System.out.println("Lo siento, sus datos no aparecen en la base de datos.");
        }

        oCon.close();
    } // fin de main
}
