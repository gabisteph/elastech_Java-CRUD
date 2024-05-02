package com.pizzaria.elastech.repositories;

import com.pizzaria.elastech.models.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BebidaRepository extends JpaRepository<Bebida, Long> {
}
