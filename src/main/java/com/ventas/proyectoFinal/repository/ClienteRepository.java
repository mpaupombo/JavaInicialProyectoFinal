package com.ventas.proyectoFinal.repository;

import com.ventas.proyectoFinal.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//creo un repository que extiende de la clase cliente cuyo ID es un Long

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
