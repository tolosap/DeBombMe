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
public class Boton implements Modulo {

    private boolean desarmado = false;
    private Color color = null;
    private String texto = "";

    public Boton() {

    }

    public Boton(Color color, String txt) {
        this.color = color;
        this.texto = txt;
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

}
