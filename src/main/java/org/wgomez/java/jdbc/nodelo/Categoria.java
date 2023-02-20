package org.wgomez.java.jdbc.nodelo;

public class Categoria {
private Long id;
private String nombre;

public Categoria (String nombre, Long id) {
    this.nombre = nombre;
    this.id     = id;
}

public Categoria (Long id) {
    this.id = id;

}


public String getNombre () {
    return this.nombre;
}

public Long getId () {
    return this.id;
}

public void setNombre (String nombre) {
    this.nombre = nombre;
}

public void setId (Long id) {
    this.id = id;
}


}
