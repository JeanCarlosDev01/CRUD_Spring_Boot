package com.webapp.crudspringboot.controlador;

import com.webapp.crudspringboot.entidad.Producto;
import com.webapp.crudspringboot.servicio.servProductoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/*
 * @author JEAN
 */

/*
El controlador me permite manejar las solicitudes HTTP
Este interacua con el servicio para devolver una respuesta al usuario
*/

@Controller
public class ctrlProducto {
    
    /*
    Esta línea de código está diciendo a Spring que inyecte (automáticamente) 
    una instancia de ServProductoImpl en el campo srvProducto
    */
    @Autowired
    private servProductoImpl srvProducto;
    
    /*
    Al ingresar la URL indicada, se retornara el nombre del archivo HTML 
    correspondiente junto con la lista de objetos Producto
    */
    @GetMapping({"/productos","/"})
    public String getTodosProductos (Model modelo) {
        modelo.addAttribute("productos", srvProducto.listarProdductos());
        return "productos";
    }
    
    /*
    Al ingresar la URL indicada, se retornara el nombre del formulario HTML 
    correspondiente junto al objeto Producto donde se almacenaran los datos
    */
    @GetMapping({"/productos/registrar", "/registrar"})
    public String mostrarFormularioRegistro(Model modelo) {
        Producto producto = new Producto();
        modelo.addAttribute("producto",producto);
        return "formularioRegistrar";
    }
    /*
    Cuando se envie la informacion del formulario, esta se cargara en el objeto
    y se envia a la base de datos por medio del servicio
    */
    @PostMapping("/productos")
    public String registrarProducto (@ModelAttribute("producto") Producto producto) {
        srvProducto.registrarProducto(producto);
        return "redirect:/productos";
    }
    
    @GetMapping("/productos/editar/{id}")
    public String MostratFormularioEditar (@PathVariable Long id, Model modelo) {
        modelo.addAttribute("producto", srvProducto.obtenerEstudiantePorId(id));
        return "formularioEditar";
    }
    
    /*
    Al ingresar la URL indicada mas el id, se cargara el formulario HTML para 
    realizar la actualizacion de la informacion el producto seleccionado
    */
    @PostMapping("/productos/{id}")
    public String actualizarProducto (@PathVariable Long id, @ModelAttribute("producto") Producto producto, Model modelo) {
        Producto prod = srvProducto.obtenerEstudiantePorId(id);
        prod.setPrId(id);
        prod.setPrNombre(producto.getPrNombre());
        prod.setPrCategoria(producto.getPrCategoria());
        prod.setPrDesc(producto.getPrDesc());
        prod.setPrPrecio(producto.getPrPrecio());
        srvProducto.actualizarProducto(prod);
        return "redirect:/productos";
    }
    
    /*
    Se captura el objeto seleccionado por el usuario para ser eliminado 
    por medio del id del producto
    */
    @GetMapping("/productos/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        srvProducto.eliminarProducto(id);      
        return "redirect:/productos";
    }
}
