package com.bamba.gestiondestock.services.impl;

import com.bamba.gestiondestock.dto.CommandeFournisseurDto;
import com.bamba.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.bamba.gestiondestock.exception.EntityNotFoundException;
import com.bamba.gestiondestock.exception.ErrorCodes;
import com.bamba.gestiondestock.exception.InvalidEntityException;
import com.bamba.gestiondestock.model.*;
import com.bamba.gestiondestock.repository.ArticleRepository;
import com.bamba.gestiondestock.repository.CommandeFournisseurRepository;
import com.bamba.gestiondestock.repository.FournisseurRepository;
import com.bamba.gestiondestock.repository.LigneCommandeFournisseurRepository;
import com.bamba.gestiondestock.services.CommandeFournisseurService;
import com.bamba.gestiondestock.validator.CommandeFournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {

    private CommandeFournisseurRepository commandeFournisseurRepository;
    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;
    private FournisseurRepository fournisseurRepository;
    private ArticleRepository articleRepository ;

    @Autowired
    public CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository, LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository, FournisseurRepository fournisseurRepository, ArticleRepository articleRepository) {
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        List<String> errors = CommandeFournisseurValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Commande fournisseur n'est pas valide {}",dto);
            throw new InvalidEntityException("la commande fournisseur n'est pas valide", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID,errors);
        }
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(dto.getFournisseur().getId());

        if(fournisseur.isEmpty()){
            log.warn("le Fournisseur avec ce ID {} n'existe pas dans la BDD",dto.getFournisseur().getId());
            throw new EntityNotFoundException("Aucun fournisseur avec l'ID "+dto.getFournisseur().getId() +"n'a été trouvé dans la BDD",ErrorCodes.FOURNISSEUR_NOT_FOUND);

        }
        List<String> articleErrors = new ArrayList<>();
        if(dto.getLigneCommandeFournisseurs() !=null){
            for(LigneCommandeFournisseurDto ligneCommandeFournisseurDto : dto.getLigneCommandeFournisseurs()){
                if(ligneCommandeFournisseurDto.getArticle() != null){
                    Optional<Article> article = articleRepository.findById(ligneCommandeFournisseurDto.getArticle().getId());
                    if(article.isEmpty()){
                        articleErrors.add("l'article avec l'ID"+ ligneCommandeFournisseurDto.getArticle().getId() + "n'existe pas");
                    }
                }
                else {
                    articleErrors.add("impossible d'enregistrer une commande avec un article null");

                }
            }
        }
        if(!articleErrors.isEmpty()){
            log.warn(" l'article n'existe pas");
            throw new InvalidEntityException("Article n'existe pas dans la BDD",ErrorCodes.ARTICLE_NOT_FOUND,articleErrors);

        }

        CommandeFournisseur saveCmmdfournisseur = commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(dto));
        if(dto.getLigneCommandeFournisseurs() != null){
            dto.getLigneCommandeFournisseurs().forEach(ligCmmd->{
                LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurDto.toEntity(ligCmmd);
                ligneCommandeFournisseur.setCommandeFournisseur(saveCmmdfournisseur);
                ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);
            });
        }

        return CommandeFournisseurDto.fromEntity(saveCmmdfournisseur);

    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        if(id == null){
            log.error("Commande client ID is null");
            return null;
        }
        return commandeFournisseurRepository.findById(id)
                .map(CommandeFournisseurDto ::fromEntity)
                .orElseThrow(()->new EntityNotFoundException(
                        "Aucune commande fournisseur n'a été trouvé avec l'ID" + id, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
                ));
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        if(code == null){
            log.error("Commande Fournisseur CODE is null");
            return null;
        }
        return commandeFournisseurRepository.findCommandeFournisseurByCode(code)
                .map(CommandeFournisseurDto ::fromEntity)
                .orElseThrow(()->new EntityNotFoundException(
                        "Aucune commande fournisseur n'a été trouvé avec le code" + code, ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND
                ));
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurRepository.findAll().stream()
                .map(CommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

        if(id == null){
            log.error("Commande Fournisseur ID is null");
            return ;
        }
        commandeFournisseurRepository.deleteById(id);
    }

}
