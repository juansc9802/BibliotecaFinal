/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.*;

/**
 *
 * @author Juan Pablo
 */
public interface IBilioteca {
    void register(Usuario o);
    void registerLibro(Libro lib);
    void unregister(Usuario o);
    void unregisterLibro(Libro lib);
    void setEstadoLib(boolean est, String nombre);
    void getUsuarios(String nombre);
    void getLibro(String nombre);
    void mostrarLibros();
    void mostrarUsuarios();
}
