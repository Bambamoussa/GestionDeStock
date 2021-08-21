package com.bamba.gestiondestock.validator;

import com.bamba.gestiondestock.dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {
    /**
     *
     * @param commandeClientDto
     * @return
     */
    public  static List<String> validate(CommandeClientDto commandeClientDto){
        List<String> errors = new ArrayList<>();
        if (commandeClientDto == null){
            errors.add(("veuillez renseigner le code "));
            errors.add("veuillez renseigner les informations du client");
            errors.add("veuillez renseigner la date de la commande");
            errors.add("veuillez renseigner les lignes de la commande");
            return errors;
        }
        if(!StringUtils.hasLength(commandeClientDto.getCode())){
            errors.add(("veuillez renseigner le code "));
        }
        if(commandeClientDto.getClient() == null){
            errors.add("veuillez renseigner les informations du client");
        }
        if(commandeClientDto.getDateCommande() == null){
            errors.add("veuillez renseigner la date de la commande");
        }
        if(commandeClientDto.getLigneCommandeClients() == null){
            errors.add("veuillez renseigner les lignes de la commande");
        }
        return  errors;
    }
}
