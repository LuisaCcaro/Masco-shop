package com.Mascoshop.Controladores;

import com.Mascoshop.Entidades.Producto;
import com.Mascoshop.Servicios.ServiciosProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoControlador {

    private final ServiciosProductos serviciosProductos;


    @Autowired
    public ProductoControlador(ServiciosProductos serviciosProductos) {
        this.serviciosProductos = serviciosProductos;
    }

    //Listar los productos disponibles.
    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos() {
        List<Producto> productos = serviciosProductos.listarProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
    //Listar por ID, Obtener producto.
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerProducto(@PathVariable Integer id) {
        try {
            Producto producto = serviciosProductos.buscarPorId(id);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    //Agregar un producto.
    @PostMapping
    public  ResponseEntity<Producto>agregarProducto(@RequestBody Producto producto){
        Producto nuevoProducto = serviciosProductos.agregarProducto(producto);
        return new ResponseEntity<>(producto, HttpStatus.CREATED);
    }
    //Buscar producto por animal
    @GetMapping("/animal/{animalId}")
    public ResponseEntity<List<Producto>> buscarPorAnimal(@PathVariable Integer animalId){
        List<Producto> productos = serviciosProductos.encontrarPorAnimal(animalId);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
    //Buscar producto por categoria
    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<Producto>> buscarPorCategoria(@PathVariable Integer categoriaId){
        List<Producto> productos = serviciosProductos.encontrarPorCategoria(categoriaId);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
    //Buscar producto por marca
    @GetMapping("/marca/{marcaId}")
    public ResponseEntity<List<Producto>> buscarPorMarca(@PathVariable Integer marcaId){
        List<Producto> productos = serviciosProductos.encontrarPorMarca(marcaId);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    //Actualizar el producto.
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProd(@PathVariable Integer id, @RequestBody Producto productoActualizado) {
        try {
            Producto producto = serviciosProductos.editarProducto(id, productoActualizado);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("No se pudo actualizar el producto", HttpStatus.NOT_FOUND);
        }
    }
    //Eliminar un producto.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id){
        serviciosProductos.borrarProducto(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
