package org.wgomez.java.jdbc.repositorio;

import org.wgomez.java.jdbc.nodelo.Categoria;
import org.wgomez.java.jdbc.nodelo.Producto;
import org.wgomez.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto> {

private Connection getConnection () throws SQLException {
    return ConexionBaseDatos.getInstance();
}

@Override
public List<Producto> findAll () {
    List<Producto> all = new ArrayList<>();

    try (Statement stmt = getConnection().createStatement(); ResultSet result = stmt.executeQuery(
            "SELECT p.*, c.nombre AS categoria FROM productos AS p " + "INNER JOIN categorias AS " + "c ON " + "(p.categoria_id=c.id)")) {

        while (result.next()) {
            Producto p = crearProducto(result);
            all.add(p);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return all;
}


@Override
public Producto findById (Long id) {
    Producto product = null;

    try (PreparedStatement stmt = getConnection().prepareStatement(
            "SELECT p.*, c.nombre AS categoria FROM productos AS p " + "INNER JOIN categorias AS " +
                    "c ON (p.categoria_id=c.id) WHERE p.id = ?")) {
        stmt.setLong(1, id);
        ResultSet result = stmt.executeQuery();
        if (result.next()) {
            product = crearProducto(result);
        }
        result.close();

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return product;
}

@Override
public void save (Producto producto) {

    String sql = null;
    if (producto.getId() != null && producto.getId() > 0) {
        sql = "UPDATE productos SET nombre=?, precio=?, categoria_id=? WHERE id=?";

    } else {
        sql = "INSERT INTO productos " + "(nombre,precio,categoria_id,fecha_registro) VALUES" + "(?,?,?,?)";

    }
    try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
        stmt.setString(1, producto.getNombre());
        stmt.setInt(2, producto.getPrecio());
        stmt.setLong(3, producto.getCategoria().getId());


        if (producto.getId() != null && producto.getId() > 0) {
            stmt.setLong(4, producto.getId());
        } else {
            stmt.setDate(4, new Date(producto.getFecha_registro().getTime()));
        }
        stmt.executeUpdate();


    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

@Override
public void delete (Long id) {
    try (PreparedStatement stmt = getConnection().prepareStatement(
            "DELETE FROM productos WHERE id =?")) {
        stmt.setLong(1, id);
        stmt.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }


}

private static Producto crearProducto (ResultSet result) throws SQLException {
    Producto p = new Producto();
    p.setId(result.getLong("id"));
    p.setNombre(result.getString("nombre"));
    p.setPrecio(result.getInt("precio"));
    p.setFecha_registro(result.getDate("fecha_registro"));
    Categoria categoria = new Categoria(result.getLong("categoria_id"));
    /*    categoria como alias en la consulta*/
    categoria.setNombre(result.getString("categoria"));
    p.setCategoria(categoria);
    return p;
}

}


