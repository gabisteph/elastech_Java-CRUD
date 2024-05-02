package com.pizzaria.elastech.models;

import jakarta.persistence.*;

import java.security.Timestamp;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "idfornada")
    private Fornada fornada;
    private Timestamp timestamp;

}
