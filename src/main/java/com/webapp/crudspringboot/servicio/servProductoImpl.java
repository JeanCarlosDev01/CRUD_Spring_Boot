package com.webapp.crudspringboot.servicio;

import com.webapp.crudspringboot.entidad.Producto;
import com.webapp.crudspringboot.repositorio.repoProducto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEAN
 */

/*
En esta clase se implementan los metodos del archivo servProducto.java con el fin de inicializar 
cada uno de los metodos y acceder a los metodos de lectura y escritura del repositorio
*/

@Service
public class servProductoImpl implements servProducto {
    @Autowired
    repoProducto repProducto;
            
    @Override
    public List<Producto> listarProdductos() {
        return repProducto.findAll();
    }

    @Override
    public Producto registrarProducto(Producto producto) {
        return repProducto.save(producto);
    }

    @Override
    public Producto obtenerEstudiantePorId(Long id) {
        return repProducto.findById(id).get();
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        return repProducto.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        repProducto.deleteById(id);
    }   
}
