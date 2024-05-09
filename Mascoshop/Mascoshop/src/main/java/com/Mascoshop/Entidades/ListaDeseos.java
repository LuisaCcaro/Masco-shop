package com.Mascoshop.Entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ListaDeseos")
@Data
public class ListaDeseos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idListaDeseos;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;
}
