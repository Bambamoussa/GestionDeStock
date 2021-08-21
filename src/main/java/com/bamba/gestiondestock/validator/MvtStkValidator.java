package com.bamba.gestiondestock.validator;

import com.bamba.gestiondestock.dto.MvtStkDto;

import java.util.ArrayList;
import java.util.List;

public class MvtStkValidator {
    public  static List<String> validate(MvtStkDto mvtStkDto){
        List<String> errors = new ArrayList<>();
        if(mvtStkDto == null){
            errors.add("veuillez renseigner la date du mouvement");
            errors.add("veuillez renseigner le type du mouvement");
            errors.add("veuillez renseigner les informations de l'article");
            errors.add("veuillez renseigner la quantité ");
            return  errors;
        }
        if(mvtStkDto.getDateMvt() == null){
            errors.add("veuillez renseigner la date du mouvement");
        }
        if(mvtStkDto.getTypeMvt() == null){
            errors.add("veuillez renseigner le type du mouvement");
        }
        if(mvtStkDto.getArticle() == null){
            errors.add("veuillez renseigner les informations de l'article");
        }
        if(mvtStkDto.getQuantite() == null){
            errors.add("veuillez renseigner la quantité ");
        }
        return errors;
    }
}
