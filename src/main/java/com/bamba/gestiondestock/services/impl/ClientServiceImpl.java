package com.bamba.gestiondestock.services.impl;

import com.bamba.gestiondestock.dto.ClientDto;
import com.bamba.gestiondestock.exception.EntityNotFoundException;
import com.bamba.gestiondestock.exception.ErrorCodes;
import com.bamba.gestiondestock.exception.InvalidEntityException;
import com.bamba.gestiondestock.model.Client;
import com.bamba.gestiondestock.repository.ClientRepository;
import com.bamba.gestiondestock.services.ClientService;
import com.bamba.gestiondestock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;
    @Autowired
    public  ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    /**
     *
     * @param dto
     * @return
     */
    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors = ClientValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Client is not valid {} ",dto);
            throw new InvalidEntityException("le client n'est pas valide ", ErrorCodes.ARTICLE_NOT_VALID , errors);
        }
        Client client = clientRepository.save(ClientDto.toEntity(dto));
        return ClientDto.fromEntity(client);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public ClientDto findById(Integer id) {
         if( id == null){
             log.error("Client ID is null");
             return null;
         }
         return clientRepository.findById(id)
                 .map(ClientDto :: fromEntity)
                 .orElseThrow(() -> new EntityNotFoundException(
                         "Aucun client avec l'ID = " +id + "n'a été trouvé dans la BDD",
                         ErrorCodes.CLIENT_NOT_FOUND)
                 );
    }

    /**
     *
     * @return
     */
    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto :: fromEntity)
                .collect(Collectors.toList());
    }

    /**
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Client is null");
            return;
        }
        clientRepository.deleteById(id);

    }
}
