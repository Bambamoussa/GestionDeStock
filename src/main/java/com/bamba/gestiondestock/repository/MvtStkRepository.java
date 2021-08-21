package com.bamba.gestiondestock.repository;

import com.bamba.gestiondestock.model.MvtStk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MvtStkRepository extends JpaRepository<MvtStk,Integer> {
}
