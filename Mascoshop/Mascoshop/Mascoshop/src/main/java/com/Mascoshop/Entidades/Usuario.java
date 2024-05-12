package com.Mascoshop.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idUsuario;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Column(name = "nombreUsuario", nullable = false )
    private String nombreUsuario;

    @Column(name = "Direccion", nullable = false)
    private String direccion;

    @Column(name = "Telefono", nullable = false)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "idRol", nullable = false)
    private Rol rol;
}


