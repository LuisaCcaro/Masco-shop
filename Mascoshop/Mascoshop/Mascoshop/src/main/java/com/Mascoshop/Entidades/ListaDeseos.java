package com.Mascoshop.Entidades;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ListaDeseos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListaDeseos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idListaDeseos;

    @ManyToOne
    @JoinColumn(name = "idUsuario",nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;
}