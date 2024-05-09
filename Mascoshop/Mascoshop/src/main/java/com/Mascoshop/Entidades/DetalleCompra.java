package com.Mascoshop.Entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DetalleCompra")
@Data
public class DetalleCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDetalle;

    @ManyToOne
    @JoinColumn(name = "idCompra")
    private Compra compra;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "subTotal")
    private Float subTotal;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;
}
