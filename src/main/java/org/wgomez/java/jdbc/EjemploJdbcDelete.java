package org.wgomez.java.jdbc;

import org.wgomez.java.jdbc.nodelo.Producto;
import org.wgomez.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.wgomez.java.jdbc.repositorio.Repositorio;
import org.wgomez.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJdbcDelete {
public static void main (String[] args) {


    try (Connection conect = ConexionBaseDatos.getInstance()) {

        Repositorio<Producto> repositorio = new ProductoRepositorioImpl();

        repositorio.delete(13L);


    } catch (SQLException e) {
        e.printStackTrace();


    }

}
}
