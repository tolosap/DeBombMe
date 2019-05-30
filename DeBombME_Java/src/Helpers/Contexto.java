/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

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
    
}
