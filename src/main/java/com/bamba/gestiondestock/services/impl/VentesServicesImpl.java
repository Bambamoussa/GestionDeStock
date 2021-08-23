package com.bamba.gestiondestock.services.impl;

import com.bamba.gestiondestock.dto.CommandeFournisseurDto;
import com.bamba.gestiondestock.dto.LigneVenteDto;
import com.bamba.gestiondestock.dto.VentesDto;
import com.bamba.gestiondestock.exception.EntityNotFoundException;
import com.bamba.gestiondestock.exception.ErrorCodes;
import com.bamba.gestiondestock.exception.InvalidEntityException;
import com.bamba.gestiondestock.model.Article;
import com.bamba.gestiondestock.model.LigneVente;
import com.bamba.gestiondestock.model.Ventes;
import com.bamba.gestiondestock.repository.ArticleRepository;
import com.bamba.gestiondestock.repository.LigneVenteRepository;
import com.bamba.gestiondestock.repository.VentesRepository;
import com.bamba.gestiondestock.services.VentesService;
import com.bamba.gestiondestock.validator.VentesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VentesServicesImpl implements VentesService {

    private ArticleRepository articleRepository ;
    private VentesRepository ventesRepository ;
    private LigneVenteRepository ligneVenteRepository;

    @Override
    public VentesDto save(VentesDto dto) {
        List<String> errors = VentesValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("la Ventes n'est pas valide");
            throw  new InvalidEntityException("", ErrorCodes.VENTES_NOT_VALID,errors);
        }
        List<String> articlesErrors = new ArrayList<>();
        dto.getLigneVentes().forEach(ligneVenteDto -> {
            Optional<Article> article =articleRepository.findById(ligneVenteDto.getArticle().getId());
            if(article.isEmpty()){
                articlesErrors.add("Aucun article avec l'ID" + ligneVenteDto.getArticle().getId() +
                        "n'a été trouvé dans la BDD");
            }
        });

        if(!articlesErrors.isEmpty()){
            log.error("One or more article were not found in the DB, {}",errors);
            throw new InvalidEntityException("un ou plusieurs articles n'ont pas été trouvé dans la BDD", ErrorCodes.VENTES_NOT_FOUND);
        }
        Ventes savedVentes = ventesRepository.save(VentesDto.toEntity(dto));

        dto.getLigneVentes().forEach(ligneVenteDto -> {
            LigneVente ligneVente = LigneVenteDto.toEntity(ligneVenteDto);
            ligneVente.setVente(savedVentes);
            ligneVenteRepository.save(ligneVente);
        });

        return  VentesDto.fromEntity(savedVentes);
    }

    @Override
    public VentesDto findById(Integer id) {
        if(id == null){
            log.error("VentesID is null");
            return null;
        }
        return ventesRepository.findById(id)
                .map(VentesDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException(
                        "Aucune vente  n'a été trouvé avec l'ID" + id, ErrorCodes.VENTES_NOT_FOUND
                ));
    }

    @Override
    public VentesDto findByCode(String code) {
        if(code == null){
            log.error("Vente CODE is null");
            return null;
        }
        return ventesRepository.findVentesByCode(code)
                .map(VentesDto ::fromEntity)
                .orElseThrow(()->new EntityNotFoundException(
                        "Aucune vente n'a été trouvé avec le code" + code, ErrorCodes.VENTES_NOT_VALID
                ));
    }

    @Override
    public List<VentesDto> findAll() {
        return ventesRepository.findAll().stream()
                .map(VentesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Commande Fournisseur ID is null");
            return ;
        }
        ventesRepository.deleteById(id);
    }
}
