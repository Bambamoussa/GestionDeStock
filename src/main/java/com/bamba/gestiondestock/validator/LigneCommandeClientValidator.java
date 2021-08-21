package com.bamba.gestiondestock.validator;

import com.bamba.gestiondestock.dto.LigneCommandeClientDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {
    /**
     *
     * @param ligneCommandeClientDto
     * @return
     */
    public  static List<String> validate(LigneCommandeClientDto ligneCommandeClientDto){

        List<String> errors = new ArrayList<>();

        if(ligneCommandeClientDto == null){
            errors.add("veuillez renseigner la quantité de la commande");
            errors.add("veuillez renseigner le prix unitaire de la commande");
            errors.add("veuillez renseigner l'article commandé");
            return  errors;
        }
        if(ligneCommandeClientDto.getArticle() == null){
            errors.add("veuillez renseigner l'article commandé");
        }

        if(ligneCommandeClientDto.getQuantite() == null){
            errors.add("veuillez renseigner la quantité de la commande");
        }
        if(ligneCommandeClientDto.getPrixUnitaire() == null){
            errors.add("veuillez renseigner le prix unitaire de la commande");
        }

        return  errors;
    }
}
