package com.bamba.gestiondestock.services.impl;

import com.bamba.gestiondestock.dto.EntrepriseDto;
import com.bamba.gestiondestock.dto.FournisseurDto;
import com.bamba.gestiondestock.dto.UtilisateurDto;
import com.bamba.gestiondestock.exception.EntityNotFoundException;
import com.bamba.gestiondestock.exception.ErrorCodes;
import com.bamba.gestiondestock.exception.InvalidEntityException;
import com.bamba.gestiondestock.model.Entreprise;
import com.bamba.gestiondestock.model.Utilisateur;
import com.bamba.gestiondestock.repository.UtilisateurRepository;
import com.bamba.gestiondestock.services.UtilisateurService;
import com.bamba.gestiondestock.validator.EntrepriseValidator;
import com.bamba.gestiondestock.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public  UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository = utilisateurRepository ;
    }

    /**
     *
     * @param dto
     * @return
     */
    @Override
    public UtilisateurDto save(UtilisateurDto dto) {

        List<String> errors = UtilisateurValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error(" utilisateur is not valid {}" , dto);
            throw new InvalidEntityException("l'utilisateur n'est pas valide" , ErrorCodes.UTILISATEUR_NOT_VALID , errors);
        }
        Utilisateur utilisateur = utilisateurRepository.save(UtilisateurDto.toEntity(dto));
        return UtilisateurDto.fromEntity(utilisateur);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public UtilisateurDto findById(Integer id) {

        if( id == null){
            log.error("utilisateur ID is null");
            return null;
        }
        return utilisateurRepository.findById(id)
                .map(UtilisateurDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException(
                        "Aucun utilisateur avec l'ID = "+ id + "n'a été trouvé dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
                );
    }

    /**
     *
     * @return
     */
    @Override
    public List<UtilisateurDto> findAll() {

        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    /**
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("l'utilisateur ID is null");
            return;
        }
        utilisateurRepository.deleteById(id);
    }

}
