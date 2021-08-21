package com.bamba.gestiondestock.validator;

import com.bamba.gestiondestock.dto.LigneCommandeFournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeFournisseurValidator {
    public static List<String> validate(LigneCommandeFournisseurDto ligneCommandeFournisseurDto){
        List<String> errors = new ArrayList<>();

        if(ligneCommandeFournisseurDto == null){
            errors.add("veuillez renseigner l'article commandé");
            errors.add("veuillez renseigner le prix unitaire de l'article");
            errors.add("veuillez renseigner la quantité  commandée");
            return  errors;
        }
        if(ligneCommandeFournisseurDto.getArticle() == null){
            errors.add("veuillez renseigner l'article commandé");
        }
        if(ligneCommandeFournisseurDto.getPrixUnitaire() == null){
            errors.add("veuillez renseigner le prix unitaire de l'article");
        }
        if(ligneCommandeFournisseurDto.getQuantite() == null){
            errors.add("veuillez renseigner la quantité  commandée");
        }
        return errors;
    }
}
