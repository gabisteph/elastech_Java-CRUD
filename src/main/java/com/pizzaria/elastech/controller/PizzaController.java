package com.pizzaria.elastech.controller;


import com.pizzaria.elastech.repositories.PizzaRepository;
import com.pizzaria.elastech.models.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/pizza")
public class PizzaController {
    @Autowired
    private PizzaRepository pizzaRepository;
    @GetMapping
    public List<Pizza> getAllPizzas(){
        return pizzaRepository.findAll();
    }
    @GetMapping("/{id}")
    public Pizza getPizzaById(@PathVariable Long id){
        return pizzaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pizza not found with id "+id));
    }
    @PostMapping
    public Pizza createPizza(@RequestBody Pizza pizza){
        return pizzaRepository.save(pizza);
    }
    @PutMapping("/{id}")
    public Pizza updatePizza(@PathVariable Long id, @RequestBody Pizza pizzaDetails){
        Pizza pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pizza not found with id "+id));
        pizza.setNome(pizzaDetails.getNome());
        pizzaDetails.setPrecoBase(pizza.getPrecoBase());
        pizza.setPersonalizada(pizzaDetails.isPersonalizada());

        return pizzaRepository.save(pizza);
    }
    @DeleteMapping("/{id}")
    public String deletePizza(@PathVariable Long id){
        pizzaRepository.deleteById(id);
        return "Pizza deleted successfully with id "+id;
    }
}
