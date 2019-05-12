package pojos;
// Generated 11-may-2019 16:07:50 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * ModBoton generated by hbm2java
 */
public class ModBoton  implements java.io.Serializable {


     private int botonId;
     private String texto;
     private String color;
     private int valor;
     private Set bombas = new HashSet(0);

    public ModBoton() {
    }

	
    public ModBoton(int botonId, String texto, String color, int valor) {
        this.botonId = botonId;
        this.texto = texto;
        this.color = color;
        this.valor = valor;
    }
    public ModBoton(int botonId, String texto, String color, int valor, Set bombas) {
       this.botonId = botonId;
       this.texto = texto;
       this.color = color;
       this.valor = valor;
       this.bombas = bombas;
    }
   
    public int getBotonId() {
        return this.botonId;
    }
    
    public void setBotonId(int botonId) {
        this.botonId = botonId;
    }
    public String getTexto() {
        return this.texto;
    }
    
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    public int getValor() {
        return this.valor;
    }
    
    public void setValor(int valor) {
        this.valor = valor;
    }
    public Set getBombas() {
        return this.bombas;
    }
    
    public void setBombas(Set bombas) {
        this.bombas = bombas;
    }




}

