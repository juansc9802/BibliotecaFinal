/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Pablo
 */
public class Biblioteca implements IBilioteca {

    Conexion conectar;
    List<Libro> listaLibros = new ArrayList<>();
    List<Usuario> listareg = new ArrayList<>();

    @Override
    public void register(Usuario o) {
        listareg.add(o);
        System.out.println("Usuario registrado con exito!");
        Conexion conectar = Conexion.getInstance();
        conectar.conectar();
        conectar.addUsr(o.nombre);

    }

    @Override
    public void registerLibro(Libro lib) { //LISTO-------------------
        listaLibros.add(lib);
        Conexion conectar = Conexion.getInstance();
        conectar.addLib(lib.Nombre);
    }

    @Override
    public void unregister(Usuario o) { // FALTA-----------------
        listareg.remove(o);
        System.out.println("Usuario eliminado" + o);
        Conexion conectar = Conexion.getInstance();
        conectar.conectar();
        conectar.delLib(o.nombre);

    }

    @Override
    public void unregisterLibro(Libro lib) {//LISTO--------------
        Conexion conectar = Conexion.getInstance();
        conectar.conectar();
        conectar.delLib(lib.Nombre);
        System.out.println("Libro eliminado: " + lib);
    }

    @Override

    public void setEstadoLib(boolean est, String nombre) {
        Conexion conectar = Conexion.getInstance();
        conectar.conectar();
        conectar.notifUsr(nombre, est);

        conectar.conectar();
        conectar.setLibEst(nombre, est);

    }

    public void getUsuarios(String nombre) {//FALTA----------------------
        Conexion conectar = Conexion.getInstance();
        conectar.conectar();
        conectar.buscarUsuariosPorNombre(nombre);
    }

    public void getLibro(String nombre) { //FALTA
        Conexion conectar = Conexion.getInstance();
        conectar.conectar();
        conectar.buscarLibrosPorNombre(nombre);

    }

    public void mostrarLibros() {
        Conexion conectar = Conexion.getInstance();
        conectar.conectar();
        conectar.conLib();
    }

    public void mostrarUsuarios() {
        Conexion conectar = Conexion.getInstance();
        conectar.conectar();
        conectar.conUsr();
    }
}
