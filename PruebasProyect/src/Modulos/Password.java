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
public class Password implements Modulo {

    private boolean desarmado = false;
    private String solucion = "";

    public Password() {

    }

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

}
