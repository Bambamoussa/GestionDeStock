package com.bamba.gestiondestock.services;

import com.bamba.gestiondestock.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    UtilisateurDto save(UtilisateurDto dto);

    UtilisateurDto findById(Integer id);

    List<UtilisateurDto> findAll();

    UtilisateurDto findByEmail(String email);

    void delete (Integer id);
}
