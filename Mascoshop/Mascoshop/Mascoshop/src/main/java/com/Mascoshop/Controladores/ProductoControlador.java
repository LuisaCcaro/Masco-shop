package com.Mascoshop.Controladores;

import com.Mascoshop.Entidades.Producto;
import com.Mascoshop.Servicios.ServiciosProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@RestController
@RequestMapping("/api/productos")
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
    @GetMapping("/buscar/{id}")
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
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto, @RequestParam("File") MultipartFile imagen) {
        Producto nuevoProducto = serviciosProductos.agregarProducto(producto);

        if (!imagen.isEmpty()){
            Path directorioImagenes = Paths.get("src//main//resources//static/Imagenes");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();

            try {
                byte [] byteImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//"+ imagen.getOriginalFilename());
                Files.write(rutaCompleta, byteImg);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            producto.setImagen(imagen.getOriginalFilename());
        }
        return new ResponseEntity<>(producto, HttpStatus.CREATED);
    }


//    @PostMapping por si no funciona el original
//    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto) {
//        Producto nuevoProducto = serviciosProductos.agregarProducto(producto);
//        return new ResponseEntity<>(producto, HttpStatus.CREATED);
//    }

    //Buscar producto por animal
    @GetMapping("/animal/{animalId}")
    public ResponseEntity<List<Producto>> buscarPorAnimal(@PathVariable Integer animalId) {
        List<Producto> productos = serviciosProductos.encontrarPorAnimal(animalId);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    //Buscar producto por categoria
    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<Producto>> buscarPorCategoria(@PathVariable Integer categoriaId) {
        List<Producto> productos = serviciosProductos.encontrarPorCategoria(categoriaId);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    //Buscar producto por marca
    @GetMapping("/marca/{marcaId}")
    public ResponseEntity<List<Producto>> buscarPorMarca(@PathVariable Integer marcaId) {
        List<Producto> productos = serviciosProductos.encontrarPorMarca(marcaId);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    //Actualizar el producto.
    @PutMapping("/editar-producto/{id}")
    public ResponseEntity<?> actualizarProd(@PathVariable Integer id, @RequestBody Producto productoActualizado) {
        try {
            Producto producto = serviciosProductos.editarProducto(id, productoActualizado);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("No se pudo actualizar el producto", HttpStatus.NOT_FOUND);
        }
    }

    //Eliminar un producto.
    @DeleteMapping("/eliminar-producto/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id) {
        serviciosProductos.borrarProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Eliminar imagen de un producto
    @DeleteMapping("/borrar-imagen/{id}/imagen")
    public ResponseEntity<Void> eliminarImagen(@PathVariable Integer id) {
        try {
            serviciosProductos.eliminarImagen(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Descargar una imagen de un producto
    @GetMapping("/descargar/{id}/imagen")
    public ResponseEntity<Resource> descargarImagen(@PathVariable Integer id) {
        try {
            String imagePath = serviciosProductos.obtenerRutaImagen(id);
            Path file = Paths.get(imagePath);
            if (!Files.exists(file) || !Files.isReadable(file)) {
                throw new RuntimeException("No se puede leer el archivo: " + imagePath);
            }
            Resource resource = new UrlResource(file.toUri());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName().toString() + "\"")
                    .body(resource);
        } catch (MalformedURLException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
