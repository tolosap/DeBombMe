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
public class Simbolos implements Modulo {

    private boolean desarmado = false;
    private int sim1, sim2, sim3, sim4;

    public Simbolos(int sim1, int sim2, int sim3, int sim4) {
        this.sim1 = sim1;
        this.sim2 = sim2;
        this.sim3 = sim3;
        this.sim4 = sim4;
    }

    @Override
    public boolean getDesarmado() {
        return desarmado;
    }

    @Override
    public void setDesarmado(boolean var) {
        this.desarmado = var;
    }

    public int getSim1() {
        return sim1;
    }

    public void setSim1(int sim1) {
        this.sim1 = sim1;
    }

    public int getSim2() {
        return sim2;
    }

    public void setSim2(int sim2) {
        this.sim2 = sim2;
    }

    public int getSim3() {
        return sim3;
    }

    public void setSim3(int sim3) {
        this.sim3 = sim3;
    }

    public int getSim4() {
        return sim4;
    }

    public void setSim4(int sim4) {
        this.sim4 = sim4;
    }

    
}
