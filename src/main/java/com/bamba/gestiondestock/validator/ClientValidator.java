package com.bamba.gestiondestock.validator;

import com.bamba.gestiondestock.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {
    public  static List<String> validate (ClientDto clientDto){
        List<String> errors = new ArrayList<>();

        if(clientDto == null){
            errors.add("veuillez renseigner le nom du client ");
            errors.add("veuillez renseigner le prenom du client ");
            errors.add("veuillez renseigner l'email du client ");
            errors.add("veuillez renseigner le numéro de téléphone du client ");
            return  errors;
        }
        if (!StringUtils.hasLength(clientDto.getNom())){
            errors.add("veuillez renseigner le nom du client ");
        }
        if (!StringUtils.hasLength(clientDto.getPrenom())){
            errors.add("veuillez renseigner le prenom du client ");
        }
        if (!StringUtils.hasLength(clientDto.getMail())){
            errors.add("veuillez renseigner l'email du client ");
        }
        if (!StringUtils.hasLength(clientDto.getNumTel())){
            errors.add("veuillez renseigner le numéro de téléphone du client ");
        }


        return errors;
    }
}
