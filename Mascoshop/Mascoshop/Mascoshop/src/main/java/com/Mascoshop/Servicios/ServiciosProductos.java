package com.Mascoshop.Servicios;

import com.Mascoshop.Entidades.Calificacion;
import com.Mascoshop.Entidades.Comentario;
import com.Mascoshop.Entidades.Producto;
import com.Mascoshop.Repositorios.RepositorioCalificacion;
import com.Mascoshop.Repositorios.RepositorioComentario;
import com.Mascoshop.Repositorios.RepositorioProducto;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class ServiciosProductos {
    private final RepositorioProducto repoProducto;
    private final RepositorioCalificacion reposCalificacion;
    private final RepositorioComentario reposComentario;


    public ServiciosProductos(RepositorioProducto repoProducto,
                              RepositorioCalificacion reposCalificacion,
                              RepositorioComentario reposComentario) {
        this.repoProducto = repoProducto;
        this.reposCalificacion = reposCalificacion;
        this.reposComentario = reposComentario;
    }

    /*Listar productos*/
    public List<Producto> listarProductos(){
        return repoProducto.findAll();
    }
    /*Buscar por nombre*/
//    public Producto encontrarPorNom(String nombre){
//        return (Producto) repoProducto.findByNombreContaining(nombre);
//    }
    /*Buscar por animal, listar*/
    public  List<Producto> encontrarPorAnimal(long aninalId){
        return  repoProducto.findByAnimal_IdAnimal(aninalId);
    }
    /*Buscar por categoria*/
    public List<Producto> encontrarPorCategoria(long categoriaId){
        return repoProducto.findByCategoriaProducto_IdCategoria((int) categoriaId);
    }
    /*Buscar por Marca*/
    public  List<Producto> encontrarPorMarca(long marcaId){
        return repoProducto.findByMarca_IdMarca(marcaId);
    }

    /*Buscar por ID*/
    public Producto buscarPorId(Integer id){
        return repoProducto.findById(id).orElse(null);
    }

    public List<Producto>listarCategoria(Integer id){
        return repoProducto.findByCategoriaProducto_IdCategoria(id);
    }
    /*Agregar producto*/
    public Producto agregarProducto(Producto producto){
        return repoProducto.save(producto);
    }
    /*Actualizar producto*/
    public Producto editarProducto(Integer id, Producto productoEditar){
        return  repoProducto.findById(id).map(producto ->{
            producto.setNombre(productoEditar.getNombre());
            producto.setCategoriaProducto(productoEditar.getCategoriaProducto());
            producto.setAnimal(productoEditar.getAnimal());
            producto.setMarca(productoEditar.getMarca());
            producto.setDescripcion((productoEditar.getDescripcion()));
            producto.setImagen((productoEditar.getImagen()));
            producto.setImagen(productoEditar.getImagen());
            producto.setCantidadDisponible(productoEditar.getCantidadDisponible());
            return  repoProducto.save(producto);
        }).orElseThrow(() -> new RuntimeException("Ups, producto no encontrado"));
    }
    /*Comentar un producto*/
    public Comentario comentar(Comentario comentario){
        return reposComentario.save(comentario);
    }
    /*Listar comentarios*/
    public List<Comentario> listarComentario(Integer productoId){
        return reposComentario.findByProducto_IdProducto(Long.valueOf(productoId));
    }
    /*Calificar un producto*/
    public Calificacion agregarCalificacion(Calificacion calificacion){
        return reposCalificacion.save(calificacion);
    }
    /*borrar producto*/
    public void borrarProducto(Integer id){
        repoProducto.deleteById(id);
    }
}
