package com.webapp.crudspringboot.servicio;

import com.webapp.crudspringboot.entidad.Producto;
import java.util.List;

/*
 * @author JEAN
 */

/*
Creacion de la interface de servicio en la cual se definen los metodos crud  que se usaran con la base de datos 
*/

public interface servProducto {
    
    /*Metodo CREATE: metodo para crear un nuevo producto en la base de datos*/
    public Producto registrarProducto (Producto prodcuto);
    
    /*Metodos READ: permite traer la lista de productos regitrados en la base de datos*/
    public List<Producto> listarProdductos ();
    public Producto obtenerEstudiantePorId(Long id);
    
    /*Metodo UPDATE: permite actualizar la informacion de los productos ya registrados*/
    public Producto actualizarProducto (Producto producto);
    
    /*Metodo DELETE: permite eliminar un producto registrado en la base de datos*/
    public void eliminarProducto (Long id); 
}
