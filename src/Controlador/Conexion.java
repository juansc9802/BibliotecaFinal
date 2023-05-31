/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Libro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Pablo
 */
public class Conexion {

    private Conexion() {

    }

    //Primero: Crear una variable en la cual vamos a guarda el estado de la conexion a nuestra BD
    private static Connection conexion;
    //Creamos una variable para crear una sola instancia (Singleton)
    private static Conexion instancia;
    //creamos las variables para poder conectarnos a la BD
    private static final String URL = "jdbc:mysql://localhost/bd_biblioteca";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    //Metodo para conectar a la base de datos.
    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Se carga el driver que descargamos
            conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexión exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return conexion;
    }

    //Metodo para cerrar conexion
    public void desconectar() throws SQLException {

        try {
            conexion.close();
            System.out.println("Desconectado exitosamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            conexion.close();
        } finally {
            conexion.close();
        }
    }

    //PATRON SINGLETON
    public static Conexion getInstance() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public void addLib(String nombre) {
        conectar();
        try {
            PreparedStatement insertar = conexion.prepareStatement("INSERT into libros values(?,?,?)");
            insertar.setString(1, "0");
            insertar.setString(2, nombre);
            insertar.setBoolean(3, true);
            insertar.executeUpdate();
            System.out.println("Dato registrado");
            desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void delLib(String nombre) {
        if (conexion == null) {
            conectar();
        }
        try {
            PreparedStatement eliminar = conexion.prepareStatement("delete from libros WHERE Nombre = ?");
            eliminar.setString(1, nombre);
            eliminar.executeUpdate();
            System.out.println("Libro eliminado");
            desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void setLibEst(String nombre, boolean est) {

        if (conexion == null) {
            conectar();
        }
        try {
            System.out.println("Entrando al set");
            PreparedStatement modificar = conexion.prepareStatement("UPDATE libros SET Estado = ? WHERE Nombre = ?");
            modificar.setBoolean(1, est);
            modificar.setString(2, nombre);
            modificar.executeUpdate();

            desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void buscarLibrosPorNombre(String nombre) {
        List<Libro> listaLibros = new ArrayList<>();
        if (conexion == null) {
            conectar();
        }
        try {
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM libros WHERE Nombre LIKE ?");
            statement.setString(1, "%" + nombre + "%");
            ResultSet consulta = statement.executeQuery();

            while (consulta.next()) {
                int id = consulta.getInt("ID");
                String nombreLibro = consulta.getString("Nombre");
                boolean estado = consulta.getBoolean("Estado");
                System.out.println(id+" "+nombreLibro+" "+estado);
                
            }
            desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void conLib() {
        List<String> listaLibros = new ArrayList<>();
        if (conexion == null) {
            conectar();
        }
        try {
            Statement statement = conexion.createStatement();
            PreparedStatement seleccionar = conexion.prepareStatement("SELECT * FROM libros");
            ResultSet consulta = seleccionar.executeQuery();

            while (consulta.next()) {
                listaLibros.add(consulta.getString(1));
                listaLibros.add(consulta.getString(2));
                listaLibros.add(consulta.getString(3));
                listaLibros.add("\n");
            }
            desconectar();
            System.out.println(listaLibros);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void addUsr(String nombre) {
        conectar();
        try {
            PreparedStatement insertar = conexion.prepareStatement("INSERT into usuarios values(?,?)");
            insertar.setString(1, "0");
            insertar.setString(2, nombre);
            insertar.executeUpdate();
            System.out.println("Dato registrado");
            desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void delUsr(String nombre) {
        if (conexion == null) {
            conectar();
        }
        try {
            PreparedStatement eliminar = conexion.prepareStatement("delete from usuarios WHERE Nombre = ?");
            eliminar.setString(1, nombre);
            eliminar.executeUpdate();
            System.out.println("Usuario eliminado");
            desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void conUsr() {
        List<String> listaUsuarios = new ArrayList<>();
        if (conexion == null) {
            conectar();
        }
        try {
            Statement statement = conexion.createStatement();
            PreparedStatement seleccionar = conexion.prepareStatement("SELECT * FROM usuarios");
            ResultSet consulta = seleccionar.executeQuery();

            while (consulta.next()) {
                listaUsuarios.add(consulta.getString(1));
                listaUsuarios.add(consulta.getString(2));
                listaUsuarios.add("\n");
            }
            desconectar();
            System.out.println(listaUsuarios);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void buscarUsuariosPorNombre(String nombre) {
        if (conexion == null) {
            conectar();
        }
        try {
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM usuarios WHERE Nombre LIKE ?");
            statement.setString(1, "%" + nombre + "%");
            ResultSet consulta = statement.executeQuery();

            while (consulta.next()) {
                int id = consulta.getInt("ID");
                String nombreUsuario = consulta.getString("Nombre");
                System.out.println(id+" "+nombreUsuario+" ");

            }
            desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


public void notifUsr(String nombre, boolean est) {
        if (conexion == null) {
            conectar();
        }
        try {
            Statement statement = conexion.createStatement();
            PreparedStatement seleccionar = conexion.prepareStatement("SELECT * FROM usuarios");
            ResultSet consulta = seleccionar.executeQuery();

            while (consulta.next()) {
                System.out.println(consulta.getString(2) + ", Se realizo un cambio en la disponibilidad del libro " + nombre + (est == true? " Estado: Disponible" : " Estado: En prestamo"));
            }
            desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}

//    try {
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
