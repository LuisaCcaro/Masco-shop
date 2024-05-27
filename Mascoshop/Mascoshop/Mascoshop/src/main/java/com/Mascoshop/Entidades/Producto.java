package com.Mascoshop.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @ManyToOne
    @JoinColumn(name = "idPCategoria")
    private CategoriaProducto categoriaProducto;

    @ManyToOne
    @JoinColumn(name = "idAnimal",nullable = false)
    private Animal animal;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_Marca", nullable = false)
    private Marca marca;

    @Column(name = "Descripcion", nullable = false)
    private String descripcion;

    @Column(name = "Imagen")
    private String imagen;

    @Column(name = "Precio", nullable = false)
    private Double precio;

    @Column(name = "Cantidad_Disponible", nullable = false)
    private Integer cantidadDisponible;

}
