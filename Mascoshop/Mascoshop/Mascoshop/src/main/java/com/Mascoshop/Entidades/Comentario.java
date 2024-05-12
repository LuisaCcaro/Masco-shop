package com.Mascoshop.Entidades;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Comentario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idComentario;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    @Column(name = "Comentario", nullable = false)
    private String comentario;

    @Column(name = "FechaYHora", nullable = false)
    private LocalDateTime fechayhora;
}