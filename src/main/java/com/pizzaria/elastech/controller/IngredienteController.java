package com.pizzaria.elastech.controller;
import com.pizzaria.elastech.models.Ingrediente;
import com.pizzaria.elastech.repositories.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {
    @Autowired
    private IngredienteRepository ingredienteRepository;

    @GetMapping
    public List<Ingrediente> getAllIngredientes() {
        return ingredienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ingrediente getIngredienteById(@PathVariable Long id) {
        return ingredienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingrediente not found with id " + id));
    }

    @PostMapping
    public Ingrediente createIngrediente(@RequestBody Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }


    @PutMapping("/{id}")
    public Ingrediente updateIngrediente(@PathVariable Long id, @RequestBody Ingrediente ingredienteDetails) {
        Ingrediente ingrediente = ingredienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingrediente not found with id " + id));

        ingrediente.setNome(ingredienteDetails.getNome());
        ingrediente.setPreco(ingredienteDetails.getPreco());

        return ingredienteRepository.save(ingrediente);
    }

    @DeleteMapping("/{id}")
    public String deleteIngrediente(@PathVariable Long id) {
        ingredienteRepository.deleteById(id);
        return "Ingrediente deleted successfully with id " + id;
    }
}
