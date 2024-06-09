package com.webapp.crudspringboot.repositorio;

import com.webapp.crudspringboot.entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author JEAN
 */

/*
Esta interfaz actúa como un repositorio y proporciona métodos convenientes para realizar 
operaciones de lectura y escritura en la base de datos
*/

public interface repoProducto extends JpaRepository<Producto, Long> {    
}
