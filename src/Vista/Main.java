/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.*;
import Modelo.Biblioteca;
import Modelo.Libro;
import Modelo.Usuario;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Juan Pablo
 */
public class Main {

    Biblioteca bib = new Biblioteca();

    public static void main(String[] args) {
        Biblioteca bib = new Biblioteca();
        Scanner lector = new Scanner(System.in);
        Calendar fechaAct = new GregorianCalendar(2022, Calendar.APRIL, 27);
        Calendar fechaEnt = new GregorianCalendar(2022, Calendar.APRIL, 28);
        while (true) {
            String tempop;
            System.out.println("Bienvenido");
            String Menu = "1. Registrar usuario \n 2.Registrar libro \n 3.Buscar usuario \n 4. Buscar libro\n 5. pedir un prestamo \n 6. Devolver prestamo \n 7.Eliminar libro \n 8.Eliminar usuario \n 9.Mostrar todos los usuarios \n 10. Mostrar todos los libros";
            System.out.println(Menu);
            System.out.println("Elija una opción");
            int elex = lector.nextInt();

            example:
            switch (elex) {
                case 1:
                    System.out.println("Ingrese el usuario ha añadir");
                    tempop = lector.next();
                    bib.register(new Usuario(tempop));
                    break;

                case 2:
                    System.out.println("Ingrese el libro ha registrar ");
                    tempop = lector.next();
                    bib.registerLibro(new Libro(tempop));
                    break;

                case 3: //Falta
                    System.out.println("Ingrese el usuario que quieres buscar");
                    tempop = lector.next();
                    bib.getUsuarios(tempop);
                    break;

                case 4: //Falta
                    System.out.println("Ingrese el libro que quieres buscar");
                    tempop = lector.next();
                    bib.getLibro(tempop);
                    break;

                case 5: //LISTO
                    System.out.println("Ingrese el libro a prestar");
                    tempop = lector.next();
                    bib.setEstadoLib(false, tempop);
                    break;

                case 6: //LISTO
                    System.out.println("Ingrese el nombre del libro a devolver");
                    tempop = lector.next();
                    bib.setEstadoLib(true, tempop);
                    break;

                case 7: //LISTO
                    System.out.println("Ingrese el libro a ELIMINAR");
                    tempop = lector.next();
                    bib.unregisterLibro(new Libro(tempop));
                    break;

                case 8: //LISTO
                    System.out.println("Ingrese el usuario a ELIMINAR");
                    tempop = lector.next();
                    bib.unregister(new Usuario(tempop));
                    break;

                case 9: //LISTO
                    bib.mostrarUsuarios();
                    break;

                case 10: //LISTO
                    bib.mostrarLibros();
                    break;

                default:
                // Default secuencia de sentencias.
            }
        }

    }

}
