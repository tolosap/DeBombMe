/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Modulos.Contador;
import javafx.scene.paint.Color;

/**
 *
 * @author Pablo
 */
public class Contexto {

    public static boolean logueado = false;
    public static int fallos = 0;

    public static void setLogueado(boolean logueado) {
        Contexto.logueado = logueado;
    }

    public static boolean isLogueado() {
        return logueado;
    }

    public static int getFallos() {
        return fallos;
    }

    public static void setFallos() {
        fallos++;
    }
    
    public static void pintaFallos(){
        switch (fallos) {
            case 1:
                Contador.strike1.setFill(Color.RED);
                break;
            case 2:
                Contador.strike2.setFill(Color.RED);
                break;
            case 3:
                Contador.strike3.setFill(Color.RED);
                break;
            default:
                break;
        }
    }

}
