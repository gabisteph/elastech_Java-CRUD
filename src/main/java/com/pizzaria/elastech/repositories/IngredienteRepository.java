package com.pizzaria.elastech.repositories;
import com.pizzaria.elastech.models.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
}
