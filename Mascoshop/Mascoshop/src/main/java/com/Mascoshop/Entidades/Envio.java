package com.Mascoshop.Entidades;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "Envio")
@Data
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEnvio;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @Column(name = "metodoDeEnvio")
    private String metodoDeEnvio;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "estado")
    private String estado;
}
