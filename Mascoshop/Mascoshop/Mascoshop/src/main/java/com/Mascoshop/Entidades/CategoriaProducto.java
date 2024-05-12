package com.Mascoshop.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCategoria;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Descripcion", nullable = false)
    private String descripcion;
}