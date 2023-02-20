package org.wgomez.java.jdbc;

import org.wgomez.java.jdbc.nodelo.Categoria;
import org.wgomez.java.jdbc.nodelo.Producto;
import org.wgomez.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.wgomez.java.jdbc.repositorio.Repositorio;
import org.wgomez.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
public static void main (String[] args) {


    try (Connection conect = ConexionBaseDatos.getInstance()) {

        Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
        repositorio.findAll().forEach(System.out::println);
        System.out.println(repositorio.findById(1L));

        Categoria categoria = new Categoria(2L);
        Producto mesa = new Producto("Teclado Razen Mecánico ", 350, categoria, new Date());


        repositorio.save(mesa);

    } catch (SQLException e) {
        e.printStackTrace();


    }

}
}
