/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos;

import Interfaces.Modulo;
import java.util.Scanner; 

/**
 *
 * @author pablo
 */
public class Simon implements Modulo, Runnable {
    //hilo
    private Thread hilo = null;
    //
    private boolean desarmado = false;
    private boolean stop = false;
    private boolean win = false;
    //
    private String secuencia = "";
    
    public Simon(String sec){
        this.secuencia = sec;
    }

    @Override
    public boolean getDesarmado() {
        return desarmado;
    }

    @Override
    public void setDesarmado(boolean var) {
        this.desarmado = var;
    }

    public String getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
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
        Scanner sc = new Scanner(System.in);
        while (hiloActual == hilo) {
            while (!stop)
            {
                for (int j = 1; j <= secuencia.length(); j++)
                {
                    String aux = secuencia.substring(0, j);
                    System.out.println(aux);
                    System.out.println("Introduzca la letra correspondiente: ");
                    String answer = sc.nextLine();
                    if (answer == aux)
                    {
                        if (answer == secuencia)
                        {
                            win = true;
                            break;
                        }
                    }
                    else
                    {
                        System.out.println("Has fallado");
                        break;
                    }
                }

                if (win)
                {
                    System.out.println("¡Has ganado!");
                    stop = true;
                }

            }
        }
        
    }
    
    
}
