package com.pizzaria.elastech.controller;

import com.pizzaria.elastech.models.Cliente;
import com.pizzaria.elastech.repositories.ClienteRepository;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    @GetMapping
    public List<Cliente>getallClientes(){
        return clienteRepository.findAll();
    }
    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id){
        return clienteRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Client not found with id "+ id));
    }
    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }
    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetail){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Cliente not found with id "+ id));
        cliente.setNome(clienteDetail.getNome());
        cliente.setLogin(clienteDetail.getLogin());
        cliente.setEndereco(clienteDetail.getEndereco());
        cliente.setTelefone(clienteDetail.getTelefone());
        cliente.setSenha(clienteDetail.getSenha());

        return clienteRepository.save(cliente);
    }
    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable Long id){
        clienteRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Cliente not found with id "+ id));
        clienteRepository.deleteById(id);
        return "cliente deleted sucessfully with id "+id;
    }
}
