package com.Mascoshop.Repositorios;

import com.Mascoshop.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {

}
