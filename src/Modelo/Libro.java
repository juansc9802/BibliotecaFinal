/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.*;
import java.util.ArrayList;
import java.util.List;

public class Libro {

    String Nombre;
    Boolean estadoReserva = true;

    public Libro(String Nombre) {
        this.Nombre = Nombre;
        this.estadoReserva = true;

    }

    public String getEstado(Libro libro){
                return libro.estadoReserva == true? "Estado: Disponible" : "Estado: En prestamo";
    }

    public boolean setEstado(boolean estadoNuevo,Libro lib) {
                    lib.estadoReserva = estadoNuevo;
                    String temp = lib.Nombre;
                    boolean temp2 = lib.estadoReserva;
                    return temp2;
                }

    public String getNombre() {
        return Nombre;
    }
            }
