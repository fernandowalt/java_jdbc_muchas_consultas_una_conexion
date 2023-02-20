package org.wgomez.java.jdbc;

import org.wgomez.java.jdbc.nodelo.Categoria;
import org.wgomez.java.jdbc.nodelo.Producto;
import org.wgomez.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.wgomez.java.jdbc.repositorio.Repositorio;
import org.wgomez.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcUpdate {
public static void main (String[] args) {


    try (Connection conect = ConexionBaseDatos.getInstance()) {

        Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
        Producto producto = new Producto();
        producto.setId(15L);
        producto.setNombre("Bicicleta Gw");
        producto.setPrecio(585);
        producto.setCategoria(new Categoria(1L));
        repositorio.save(producto);
        repositorio.findAll().forEach(System.out::println);


    } catch (SQLException e) {
        e.printStackTrace();


    }

}
}
