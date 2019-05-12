package pojos;
// Generated 11-may-2019 16:07:50 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * Bomba generated by hbm2java
 */
public class Bomba implements java.io.Serializable {

    private Integer bombaId;
    private ModBoton modBoton;
    private ModContador modContador;
    private ModPassword modPassword;
    private ModSimon modSimon;
    private ModTemporizador modTemporizador;
    private int dificultad;
    private Set modSimboloses = new HashSet(0);

    public Bomba() {
    }

    public Bomba(ModBoton modBoton, ModContador modContador, ModPassword modPassword, ModSimon modSimon, ModTemporizador modTemporizador, int dificultad) {
        this.modBoton = modBoton;
        this.modContador = modContador;
        this.modPassword = modPassword;
        this.modSimon = modSimon;
        this.modTemporizador = modTemporizador;
        this.dificultad = dificultad;
    }

    public Bomba(ModBoton modBoton, ModContador modContador, ModPassword modPassword, ModSimon modSimon, ModTemporizador modTemporizador, int dificultad, Set modSimboloses) {
        this.modBoton = modBoton;
        this.modContador = modContador;
        this.modPassword = modPassword;
        this.modSimon = modSimon;
        this.modTemporizador = modTemporizador;
        this.dificultad = dificultad;
        this.modSimboloses = modSimboloses;
    }

    public Integer getBombaId() {
        return this.bombaId;
    }

    public void setBombaId(Integer bombaId) {
        this.bombaId = bombaId;
    }

    public ModBoton getModBoton() {
        return this.modBoton;
    }

    public void setModBoton(ModBoton modBoton) {
        this.modBoton = modBoton;
    }

    public ModContador getModContador() {
        return this.modContador;
    }

    public void setModContador(ModContador modContador) {
        this.modContador = modContador;
    }

    public ModPassword getModPassword() {
        return this.modPassword;
    }

    public void setModPassword(ModPassword modPassword) {
        this.modPassword = modPassword;
    }

    public ModSimon getModSimon() {
        return this.modSimon;
    }

    public void setModSimon(ModSimon modSimon) {
        this.modSimon = modSimon;
    }

    public ModTemporizador getModTemporizador() {
        return this.modTemporizador;
    }

    public void setModTemporizador(ModTemporizador modTemporizador) {
        this.modTemporizador = modTemporizador;
    }

    public int getDificultad() {
        return this.dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public Set getModSimboloses() {
        return this.modSimboloses;
    }

    public void setModSimboloses(Set modSimboloses) {
        this.modSimboloses = modSimboloses;
    }

}