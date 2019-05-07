
import java.awt.Color;

import Modulos.Boton;
import Modulos.Contador;
/*import javafx.application.Application;
import javafx.stage.Stage;*/
import Modulos.Simon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pablo
 */
public class Pruebas {

    public static void main(String[] args) {
        
        /*Contador cont = new Contador(120);
        cont.start();
        Boton bot = new Boton(Color.BLACK, "Test", 2);
        bot.start();*/
        Simon sim = new Simon("RRGYB");
        sim.start();
    }

}
