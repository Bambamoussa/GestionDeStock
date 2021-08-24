package com.bamba.gestiondestock.services.impl;

import com.bamba.gestiondestock.dto.CategoryDto;
import com.bamba.gestiondestock.dto.EntrepriseDto;
import com.bamba.gestiondestock.exception.EntityNotFoundException;
import com.bamba.gestiondestock.exception.ErrorCodes;
import com.bamba.gestiondestock.exception.InvalidEntityException;
import com.bamba.gestiondestock.model.Entreprise;
import com.bamba.gestiondestock.repository.EntrepriseRepository;
import com.bamba.gestiondestock.services.EntrepriseService;
import com.bamba.gestiondestock.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {
    private EntrepriseRepository entrepriseRepository;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository){
        this.entrepriseRepository = entrepriseRepository;
    }

    /**
     *
     * @param dto
     * @return
     */
    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        List<String> errors = EntrepriseValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error(" l'Entreprise is not valid {}" , dto);
            throw new InvalidEntityException("l'entreprise n'est pas valide" , ErrorCodes.ENTREPRISE_NOT_VALID , errors);
        }
        Entreprise entreprise = entrepriseRepository.save(EntrepriseDto.toEntity(dto));
        return EntrepriseDto.fromEntity(entreprise);

    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public EntrepriseDto findById(Integer id) {
        if( id == null){
            log.error("l'entreprise ID is null");
            return null;
        }
        return entrepriseRepository.findById(id)
                .map(EntrepriseDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException(
                        "Aucune entreprise avec l'ID = "+ id + "n'a été trouvé dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND)
                );
    }

    /**
     *
     * @return
     */
    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDto::fromEntity)
                .collect(Collectors.toList());
    }

    /**
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("entreprise ID is null");
            return;
        }
        entrepriseRepository.deleteById(id);
    }
}
