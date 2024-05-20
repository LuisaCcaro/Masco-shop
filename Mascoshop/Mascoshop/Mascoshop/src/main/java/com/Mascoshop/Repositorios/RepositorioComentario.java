package com.Mascoshop.Repositorios;

import com.Mascoshop.Entidades.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioComentario extends JpaRepository<Comentario, Integer> {
    List<Comentario> findByProducto_IdProducto(Long idProducto);
}
