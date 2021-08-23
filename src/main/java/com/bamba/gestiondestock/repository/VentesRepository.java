package com.bamba.gestiondestock.repository;

import com.bamba.gestiondestock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VentesRepository extends JpaRepository<Ventes,Integer> {
    Optional<Ventes> findVentesByCode(String code);
}
