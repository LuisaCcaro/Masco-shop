package com.Mascoshop.Entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Calificacion")
@Data
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCalificacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @Column(name = "Calificacion")
    private int calificacion;
}