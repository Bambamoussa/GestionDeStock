package com.bamba.gestiondestock.services;

import com.bamba.gestiondestock.dto.CommandeClientDto;
import com.bamba.gestiondestock.model.EtatCommande;

import java.util.List;

public interface CommandeClientService {
    CommandeClientDto save(CommandeClientDto dto);

    CommandeClientDto updateEtatCommande(Integer idCommande, EtatCommande etatCommande);

    CommandeClientDto findById(Integer id);

    CommandeClientDto findByCode(String code);

    List<CommandeClientDto> findAll();

    void delete (Integer id);
}
