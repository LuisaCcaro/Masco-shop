package com.Mascoshop.Entidades;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Table(name = "Comentario")
@Data
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idComentario;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @Column(name = "Comentario")
    private String comentario;

    @Column(name = "Fecha")
    private LocalDate fecha;
}
