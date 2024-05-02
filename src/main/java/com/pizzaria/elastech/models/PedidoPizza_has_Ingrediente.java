package com.pizzaria.elastech.models;

import jakarta.persistence.*;

@Entity
public class PedidoPizza_has_Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idPizzaPedida")
    private PizzaPedida pizzaPedida;

    @ManyToOne
    @JoinColumn(name = "idIngrediente")
    private Ingrediente ingrediente;



    public PizzaPedida getPizzaPedida() {
        return pizzaPedida;
    }

    public void setPizzaPedida(PizzaPedida pizzaPedida) {
        this.pizzaPedida = pizzaPedida;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }
}
