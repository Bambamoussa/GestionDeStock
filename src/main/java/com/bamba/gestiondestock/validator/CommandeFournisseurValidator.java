package com.bamba.gestiondestock.validator;

import com.bamba.gestiondestock.dto.CommandeFournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {
    public  static List<String> validate(CommandeFournisseurDto commandeFournisseurDto){
        List<String> errors = new ArrayList<>();
        if (commandeFournisseurDto == null){
            errors.add(("veuillez renseigner le code "));
            errors.add("veuillez renseigner les informations du fournisseur");
            errors.add("veuillez renseigner la date de la commande");
            errors.add("veuillez renseigner les lignes de la commande");
            return errors;
        }
        if(!StringUtils.hasLength(commandeFournisseurDto.getCode())){
            errors.add(("veuillez renseigner le code "));
        }
        if(commandeFournisseurDto.getFournisseur() == null){
            errors.add("veuillez renseigner les informations du fournisseur");
        }
        if(commandeFournisseurDto.getDateCommande() == null){
            errors.add("veuillez renseigner la date de la commande");
        }
        if(commandeFournisseurDto.getLigneCommandeFournisseurs() == null){
            errors.add("veuillez renseigner les lignes de la commande");
        }
        else {
            if (commandeFournisseurDto.getFournisseur().getId() == null) {
                errors.add("veuillez renseigner l'Id du client");
            }
        }
        return  errors;
    }
}
