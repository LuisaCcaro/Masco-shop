package com.Mascoshop.Entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Saldo")
@Data
public class Saldo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSaldo;

    @Column(name = "monto")
    private Double monto;


    // relación de la tabla idusuario(fk) a la tabla usuario(pk)
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
}
