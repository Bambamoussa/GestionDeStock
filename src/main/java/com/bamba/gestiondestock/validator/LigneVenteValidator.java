package com.bamba.gestiondestock.validator;

import com.bamba.gestiondestock.dto.LigneVenteDto;
import com.bamba.gestiondestock.model.LigneVente;

import java.util.ArrayList;
import java.util.List;

public class LigneVenteValidator {
    public  static List<String> validate(LigneVenteDto ligneVenteDto){
        List<String> errors = new ArrayList<>();
        if(ligneVenteDto == null){
            errors.add("veuillez renseigner les informations de la vente");
            errors.add("veuillez renseigner le prix unitaire du produit");
            errors.add("veuillez renseigner la quantité vendu");
            return errors ;

        }
        if(ligneVenteDto.getVente() == null){
            errors.add("veuillez renseigner les informations de la vente");
        }
        if(ligneVenteDto.getPrixUnitaire() == null){
            errors.add("veuillez renseigner le prix unitaire du produit");
        }
        if(ligneVenteDto.getQuantite() == null){
            errors.add("veuillez renseigner la quantité vendu");
        }
        return  errors;
    }
}
