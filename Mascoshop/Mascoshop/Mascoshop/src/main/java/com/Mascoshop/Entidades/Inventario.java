package com.Mascoshop.Entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Inventario")
@Data
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idInventario;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @Column(name = "Cantidad_Disponible")
    private Integer cantidadDisponible;
}
