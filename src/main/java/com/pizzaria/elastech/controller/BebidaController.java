package com.pizzaria.elastech.controller;

import com.pizzaria.elastech.models.Bebida;
import com.pizzaria.elastech.models.Pizza;
import com.pizzaria.elastech.repositories.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bebida")
public class BebidaController {
    @Autowired
    private BebidaRepository bebidaRepository;
    @GetMapping
    public List<Bebida>getAllBebidas(){
        return bebidaRepository.findAll();
    }
    @GetMapping("/{id}")
    public Bebida getBebidaById(@PathVariable Long id){
        return bebidaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Bebida not found with id "+ id));
    }
    @PostMapping
    public Bebida saveBebida(@RequestBody Bebida bebida){
        return bebidaRepository.save(bebida);
    }
    @PutMapping("/{id}")
    public Bebida updateBebida(@PathVariable Long id, @RequestBody Bebida bebidaDetails){
        Bebida bebida = bebidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bebida not found with id "+id));
        bebida.setNome(bebidaDetails.getNome());
        bebida.setPreco(bebidaDetails.getPreco());

        return bebidaRepository.save(bebida);
    }
    @DeleteMapping("/{id}")
    public String deleteBebida(@PathVariable Long id){
        Bebida bebida = bebidaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Bebida not found with id "+id));
        bebidaRepository.deleteById(id);
        return "Bebida deleted successfully with id "+ id;
    }
}
