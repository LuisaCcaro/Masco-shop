package com.Mascoshop.Entidades;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "Carrito")
@Data
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCarrito;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @OneToMany
    @JoinColumn(name = "idCarrito")
    private List<Producto> productos;
}
