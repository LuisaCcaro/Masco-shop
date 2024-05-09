package com.Mascoshop.Entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Animal")
@Data
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAnimal;

    @Column(name = "Nombre")
    private String nombre;
}