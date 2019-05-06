/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pablo
 */
public class Singleton {

    private static Connection oCon;

    private Singleton() {
        System.out.println("Clase connection creada.");
    }

    public static Connection getInstance() {
        if (oCon == null) {
            try {
                System.out.println("Conexion creada");
                Class.forName("com.mysql.cj.jdbc.Driver");
                oCon = DriverManager.getConnection("jdbc:mysql://localhost/debombme", "root", "root");
            } catch (ClassNotFoundException cn) {
                cn.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return oCon;
    }
}
