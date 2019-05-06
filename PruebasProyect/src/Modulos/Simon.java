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
public class Simon implements Modulo{
    
    private boolean desarmado = false;
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
    
    
    
}
