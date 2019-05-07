/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos;

import Interfaces.Modulo;

/**
 *
 * @author pablo
 */
public class Password implements Modulo, Runnable {

    private Thread hilo = null;

    private boolean desarmado = false;
    private String solucion = "";

    private static String cadena1 = "abcdefghijklmnopqrstuvwxyz";
    private static String cadena2 = "abcdefghijklmnopqrstuvwxyz";
    private static String cadena3 = "abcdefghijklmnopqrstuvwxyz";
    private static String cadena4 = "abcdefghijklmnopqrstuvwxyz";
    private static String cadena5 = "abcdefghijklmnopqrstuvwxyz";

    public Password(String palabra) {
        this.solucion = palabra;
    }

    @Override
    public boolean getDesarmado() {
        return desarmado;
    }

    @Override
    public void setDesarmado(boolean var) {
        this.desarmado = var;
    }

    public void start() {
        if (hilo == null) {
            hilo = new Thread(this); // creo el hilo
            hilo.start(); // lanzo hilo
        }
    }

    @Override
    public void run() {
        Thread hiloActual = Thread.currentThread();
        while (hiloActual == hilo) {
            
        }
    }

}
