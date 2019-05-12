package Modulos;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pablo
 */
public class Contador implements Runnable {

    private Thread hilo = null;
    private static long segundosC; //en milesimas
    private static int strikes; //fallos cometidos al desactivar la bomba

    public Contador(long segundos) {
        segundosC = segundos;
    }

    public int getStrikes() {
        return strikes;
    }

    public static void setStrikes() {
        strikes++;
    }

    public static long getSegundos() {
        return segundosC;
    }

    public void start() {
        if (hilo == null) {
            strikes = 0;
            hilo = new Thread(this); // creo el hilo
            hilo.start(); // lanzo hilo
        }
    }

    @Override
    public void run() {
        Thread hiloActual = Thread.currentThread();
        while (hiloActual == hilo) {
            if (strikes == 0) { // si no hay fallos, el contador funciona con normalidad
                System.out.println(segundosC);
                segundosC--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (strikes == 1) { //si hay un fallo, el contador ira un 25% mas rapido
                System.out.println(segundosC);
                segundosC--;
                try {
                    Thread.sleep(750);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (strikes == 2) { //si hay dos fallos, el contador ira el doble de rapido
                System.out.println(segundosC);
                segundosC--;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (strikes == 3) {
                
            }
        }
    }

}