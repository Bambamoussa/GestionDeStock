package com.bamba.gestiondestock.services.impl;

import com.bamba.gestiondestock.dto.CommandeClientDto;
import com.bamba.gestiondestock.dto.LigneCommandeClientDto;
import com.bamba.gestiondestock.exception.EntityNotFoundException;
import com.bamba.gestiondestock.exception.ErrorCodes;
import com.bamba.gestiondestock.exception.InvalidEntityException;
import com.bamba.gestiondestock.model.Article;
import com.bamba.gestiondestock.model.Client;
import com.bamba.gestiondestock.model.CommandeClient;
import com.bamba.gestiondestock.model.LigneCommandeClient;
import com.bamba.gestiondestock.repository.ArticleRepository;
import com.bamba.gestiondestock.repository.ClientRepository;
import com.bamba.gestiondestock.repository.CommandeClientRepository;
import com.bamba.gestiondestock.repository.LigneCommandeClientRepository;
import com.bamba.gestiondestock.services.CommandeClientService;
import com.bamba.gestiondestock.validator.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService {
    private CommandeClientRepository commandeClientRepository;
    private LigneCommandeClientRepository ligneCommandeClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository, ClientRepository clientRepository,
                                     ArticleRepository articleRepository ,LigneCommandeClientRepository ligneCommandeClientRepository) {
        this.commandeClientRepository = commandeClientRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
    }

    /**
     *
     * @param dto
     * @return
     */
    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        List<String> errors = CommandeClientValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Commande client n'est pas valide {}",dto);
            throw new InvalidEntityException("la commande client n'est pas valide", ErrorCodes.COMMANDE_CLIENT_NOT_VALID,errors);

        }
        Optional<Client> client = clientRepository.findById(dto.getClient().getId());

        if(client.isEmpty()){
            log.warn("le Client avec ce ID {} n'existe pas dans la BDD",dto.getClient().getId());
            throw new EntityNotFoundException("Aucun client avec l'ID "+dto.getClient().getId() +"n'a été trouvé dans la BDD",ErrorCodes.CLIENT_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();

        if(dto.getLigneCommandeClients() != null){
            for (LigneCommandeClientDto ligneCommandeClient : dto.getLigneCommandeClients()) {
                if(ligneCommandeClient.getArticle() != null){
                    Optional<Article> article = articleRepository.findById(ligneCommandeClient.getArticle().getId());
                    if(article.isEmpty()){
                        articleErrors.add("l'article avec l'ID"+ ligneCommandeClient.getArticle().getId() + "n'existe pas");
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
        CommandeClient saveCmmdClient = commandeClientRepository.save(CommandeClientDto.toEntity(dto));
        if(dto.getLigneCommandeClients() != null){
            dto.getLigneCommandeClients().forEach(ligCmmd->{
                LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligCmmd);
                ligneCommandeClient.setCommandeClient(saveCmmdClient);
                ligneCommandeClientRepository.save(ligneCommandeClient);
            });
        }

        return CommandeClientDto.fromEntity(saveCmmdClient);

    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public CommandeClientDto findById(Integer id) {
        if(id == null){
            log.error("Commande client ID is null");
            return null;
        }
        return commandeClientRepository.findById(id)
                .map(CommandeClientDto ::fromEntity)
                .orElseThrow(()->new EntityNotFoundException(
                        "Aucune commande client n'a été trouvé avec l'ID" + id, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
                ));
    }

    /**
     *
     * @param code
     * @return
     */
    @Override
    public CommandeClientDto findByCode(String code) {
        if(code == null){
            log.error("Commande client CODE is null");
            return null;
        }
        return commandeClientRepository.findCommandeClientByCode(code)
                .map(CommandeClientDto ::fromEntity)
                .orElseThrow(()->new EntityNotFoundException(
                        "Aucune commande client n'a été trouvé avec le code" + code, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
                ));
    }

    /**
     *
     * @return
     */
    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream()
                .map(CommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    /**
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Commande client ID is null");
            return ;
        }
        commandeClientRepository.deleteById(id);
    }
}
