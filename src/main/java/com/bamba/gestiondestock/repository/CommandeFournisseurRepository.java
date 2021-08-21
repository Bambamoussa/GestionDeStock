package com.bamba.gestiondestock.repository;

import com.bamba.gestiondestock.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeFournisseurRepository extends JpaRepository<Fournisseur,Integer> {
}
