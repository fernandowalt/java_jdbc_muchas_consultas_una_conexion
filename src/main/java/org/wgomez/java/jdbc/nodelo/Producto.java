package org.wgomez.java.jdbc.nodelo;

import java.util.Date;

public class Producto {
private Long id;
private String nombre;
private Integer precio;
private Date fecha_registro;
private Categoria categoria;

public Producto () {

}

public Producto (String nombre, Integer precio, Categoria categoria, Date fecha_registro) {
    this.nombre    = nombre;
    this.precio    = precio;
    this.categoria = categoria;
    this.fecha_registro = fecha_registro;

}


public Long getId () {
    return id;
}

public void setId (Long id) {
    this.id = id;
}

public String getNombre () {
    return nombre;
}

public void setNombre (String nombre) {
    this.nombre = nombre;
}

public Integer getPrecio () {
    return precio;
}

public Categoria getCategoria () {
    return this.categoria;
}

public void setCategoria (Categoria categoria) {
    this.categoria = categoria;
}

public void setPrecio (Integer precio) {
    this.precio = precio;
}

public Date getFecha_registro () {
    return fecha_registro;
}

public void setFecha_registro (Date fecha_registro) {
    this.fecha_registro = fecha_registro;
}

@Override
public String toString () {

    return id + " !" + nombre + " !" + precio + " !" + fecha_registro + " !" + categoria.getNombre();
}
}
