package com.bamba.gestiondestock.services.impl;

import com.bamba.gestiondestock.dto.EntrepriseDto;
import com.bamba.gestiondestock.dto.FournisseurDto;
import com.bamba.gestiondestock.exception.EntityNotFoundException;
import com.bamba.gestiondestock.exception.ErrorCodes;
import com.bamba.gestiondestock.exception.InvalidEntityException;
import com.bamba.gestiondestock.model.Entreprise;
import com.bamba.gestiondestock.model.Fournisseur;
import com.bamba.gestiondestock.repository.FournisseurRepository;
import com.bamba.gestiondestock.services.FournisseurService;
import com.bamba.gestiondestock.validator.EntrepriseValidator;
import com.bamba.gestiondestock.validator.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {
    private FournisseurRepository fournisseurRepository;
    @Autowired
    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository){
        this.fournisseurRepository = fournisseurRepository ;
    }
    @Override
    public FournisseurDto save(FournisseurDto dto) {

        List<String> errors = FournisseurValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error(" fournisseur is not valid {}" , dto);
            throw new InvalidEntityException("le fournisseur n'est pas valide" , ErrorCodes.FOURNISSEUR_NOT_VALID, errors);
        }
        Fournisseur fournisseur = fournisseurRepository.save(FournisseurDto.toEntity(dto));
        return FournisseurDto.fromEntity(fournisseur);
    }

    @Override
    public FournisseurDto findById(Integer id) {

        if( id == null){
            log.error("fournisseur ID is null");
            return null;
        }
        return fournisseurRepository.findById(id)
                .map(FournisseurDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException(
                        "Aucun fournisseur avec l'ID = "+ id + "n'a été trouvé dans la BDD",
                        ErrorCodes.FOURNISSEUR_NOT_FOUND)
                );
    }

    @Override
    public List<FournisseurDto> findAll() {

        return fournisseurRepository.findAll().stream()
                .map(FournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("entreprise ID is null");
            return;
        }
        fournisseurRepository.deleteById(id);
    }
}
