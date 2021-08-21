package com.bamba.gestiondestock.repository;

import com.bamba.gestiondestock.model.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface LigneVenteRepository extends JpaRepository<LigneVente,Integer> {
}
