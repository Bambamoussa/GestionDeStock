package com.bamba.gestiondestock.repository;

import com.bamba.gestiondestock.model.CommandeClient;
import com.bamba.gestiondestock.model.CommandeFournisseur;
import com.bamba.gestiondestock.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur,Integer> {
    Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);
}
