package pojos;
// Generated 11-may-2019 16:07:50 by Hibernate Tools 4.3.1



/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private int usuarioId;
     private String nombre;
     private String password;

    public Usuario() {
    }

    public Usuario(int usuarioId, String nombre, String password) {
       this.usuarioId = usuarioId;
       this.nombre = nombre;
       this.password = password;
    }
   
    public int getUsuarioId() {
        return this.usuarioId;
    }
    
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}


