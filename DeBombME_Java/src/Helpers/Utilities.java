/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Conexion.SessionFactoryUtil;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojos.Bomba;
import pojos.Usuario;

/**
 *
 * @author Pablo
 */
public class Utilities {
    
    public static final int PRIMERA_ALTURA = 400;
    public static final int PRIMERA_ANCHURA = 550;
    
    public static final int ALTURA_CELDA = 200;
    public static final int ANCHURA_CELDA = 183;
    
    public static boolean registro(String user, String password) {
        SessionFactory oSes = null;
        Session sesion = null;
        Transaction tx = null;
        boolean registrado = false;
        try {
            oSes = SessionFactoryUtil.getSessionFactory();
            sesion = oSes.openSession();
            tx = sesion.beginTransaction();

            Usuario us = new Usuario();
            us.setNombre(user);
            us.setPassword(Sha256.getSHA(password));

            Query q = sesion.createQuery("from Usuario where Nombre = :nombre ");
            q.setParameter("nombre", user);
            if (q.uniqueResult() == null) {
                sesion.save(us);
                tx.commit();
                registrado = true;
            } else {
                JOptionPane.showMessageDialog(null, "Error, el nombre de usuario ya existe");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sesion.close();
            //oSes.close();
            //SessionFactoryUtil.destroy();
        }
        return registrado;
    }

    public static boolean login(String user, String password) {
        SessionFactory oSes = null;
        Session sesion = null;
        boolean entra = false;
        try {
            oSes = SessionFactoryUtil.getSessionFactory();
            sesion = oSes.openSession();

            Query q = sesion.createQuery("from Usuario where Nombre = :nombre and Password = :password");
            q.setParameter("nombre", user);
            q.setParameter("password", Sha256.getSHA(password));

            if (q.uniqueResult() == null) {
                JOptionPane.showMessageDialog(null, "¡Error en el login!");
            } else {
                JOptionPane.showMessageDialog(null, "¡Bienvenido al sistema!");
                entra = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sesion.close();
            //oSes.close();
            //SessionFactoryUtil.destroy();
        }
        return entra;
    }

    public static Bomba dameBomba(int id) {
        SessionFactory oSes = null;
        Session sesion = null;
        Bomba bombaBD = null;
        try {
            oSes = SessionFactoryUtil.getSessionFactory();
            sesion = oSes.openSession();
            Query q = sesion.createQuery("from Bomba where BombaID = :id");
            q.setParameter("id", id);

            bombaBD = (Bomba) q.uniqueResult();
            System.out.println("Obtenida bomba: " + bombaBD.getBombaId());
            System.out.println("Contador: " + bombaBD.getModContador().getValor());
            System.out.println("Secuencia Simon: " + bombaBD.getModSimon().getSecuencia());
            System.out.println(""+bombaBD.getDificultad());
            System.out.println(""+bombaBD.getModBoton());
            System.out.println(""+bombaBD.getModPassword());
            System.out.println(""+bombaBD.getModSimboloses());
            System.out.println(""+bombaBD.getModTemporizador());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sesion.close();
            //oSes.close();
            //SessionFactoryUtil.destroy();
        }
        return bombaBD;
    }
}
