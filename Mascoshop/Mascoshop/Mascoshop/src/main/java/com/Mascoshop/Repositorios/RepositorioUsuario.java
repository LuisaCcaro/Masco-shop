package com.Mascoshop.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Mascoshop.Entidades.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {
    Usuario findByNombreUsuario(String nombreUsuario);
}
