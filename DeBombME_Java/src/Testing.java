


import Helpers.Utilities;
import Modulos.Contador;
import Modulos.Simon;
import pojos.Bomba;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pablo
 */
public class Testing {

    public static void main(String[] args) {
        Bomba bomba = Utilities.dameBomba(1);
        Contador cont = new Contador(bomba.getModContador().getValor());
        cont.start();
        
        Simon sim = new Simon(bomba.getModSimon().getSecuencia());
        sim.start();
    }
}
