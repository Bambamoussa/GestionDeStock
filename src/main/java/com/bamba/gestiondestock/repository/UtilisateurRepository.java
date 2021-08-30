package com.bamba.gestiondestock.repository;

import com.bamba.gestiondestock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    @Query("select U from Utilisateur U where  U.email = :email")
    Optional<Utilisateur> findUtilisateurByEmail(@Param("email") String email);
}
