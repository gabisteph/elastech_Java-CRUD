package com.pizzaria.elastech.repositories;

import com.pizzaria.elastech.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
