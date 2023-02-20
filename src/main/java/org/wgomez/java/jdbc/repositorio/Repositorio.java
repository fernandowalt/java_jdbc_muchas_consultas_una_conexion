package org.wgomez.java.jdbc.repositorio;

import java.sql.SQLException;
import java.util.List;

public interface Repositorio<T> {

List<T> findAll () throws SQLException;

T findById (Long id);

void save (T t);

void delete (Long id);
}
