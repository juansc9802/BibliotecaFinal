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
public class Usuario {

    String nombre;

    public Usuario() {
        this.nombre = "";
    }
    public Usuario(String nombre){
        this.nombre = nombre;
    }
    //TRUE SI ESTA EN STOCK - FALSE ESTA PRESTADO


    public String getNombre() {
        return nombre;
    }
}
