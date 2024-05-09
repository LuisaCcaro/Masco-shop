package com.Mascoshop.Entidades;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "Compra")
@Data
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCompra;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "Cantidad")
    private Cantidad cantidad;

    @Column(name = "metodoDepago")
    private String metodoDepago;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "hora")
    private LocalDateTime hora;

    @Column(name = "total")
    private Float total;
}
