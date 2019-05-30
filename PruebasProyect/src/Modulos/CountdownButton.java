/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos;

import Interfaces.Modulo;
import java.awt.Color;

/**
 *
 * @author pablo
 */
public class CountdownButton implements Modulo, Runnable {
    //hilo
    private Thread hilo = null;
    //modulo var
    private boolean desarmado = false;
    //data
    private Color color = null;
    private String texto = "";
    private int valor = 0;
    //interacciones
    private int soluci = 0;
    private static boolean pulsado = false;
    private static int valorEnvio = 0;

    public CountdownButton(Color color, String txt, int valor) {
        this.color = color;
        this.texto = txt;
        this.valor = valor;
        if ( color.equals(Color.BLACK))
        soluci = txt.length() + valor + 1;
        else if ( color.equals(Color.BLUE))
        soluci = txt.length() + valor + 2;
        else soluci = txt.length() + valor + 3;
    }

    @Override
    public boolean getDesarmado() {
        return desarmado;
    }

    @Override
    public void setDesarmado(boolean var) {
        this.desarmado = var;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public static void setValorEnvio(int valor){
        valorEnvio = valor;
    }

    public static void setPulsado(Boolean puls){
        pulsado = puls;
    }

    @Override
    public void run() {
        Thread hiloActual = Thread.currentThread();
        while (hiloActual == hilo) {
            if(pulsado){
                if(valorEnvio == soluci){
                    setDesarmado(true);
                } else {
                    Contador.setStrikes();

                }
            }
        }
        
    }

    public void start() {
        if (hilo == null) {
            hilo = new Thread(this); // creo el hilo
            hilo.start(); // lanzo hilo
        }
    }



}
