package com.Mascoshop.Entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Producto")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProducto;

    @ManyToOne
    @JoinColumn(name = "idPCategoria")
    private CategoriaProducto categoriaProducto;

    @ManyToOne
    @JoinColumn(name = "idAnimal")
    private Animal animal;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_Marca")
    private Marca marca;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Imagen")
    private String imagen;

    @Column(name = "Precio")
    private Double precio;

    @Column(name = "Cantidad_Disponible")
    private Integer cantidadDisponible;
}
