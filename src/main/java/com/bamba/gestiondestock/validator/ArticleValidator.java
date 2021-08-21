package com.bamba.gestiondestock.validator;

import com.bamba.gestiondestock.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {
    public static List<String> validate(ArticleDto articleDto){

        List<String> errors = new ArrayList<>();

        if(articleDto == null){
            errors.add("veuillez renseigner le code  de l'article");
            errors.add("veuillez renseigner la designation  de l'article");
            errors.add("veuillez renseigner le prix unitaire hors taxe  de l'article");
            errors.add("veuillez renseigner le prix unitaire toutes  taxe comprises  de l'article");
            errors.add("veuillez renseigner le taux TVA de l'article");
            errors.add("veuillez selectionner une categorie");
            return  errors;
        }

        if(!StringUtils.hasLength(articleDto.getCodeArticle())){
            errors.add("veuillez renseigner le code  de l'article");
        }
        if(!StringUtils.hasLength(articleDto.getDesignation())){
            errors.add("veuillez renseigner la designation  de l'article");
        }
        if(articleDto.getPrixUnitaireHt() == null){
            errors.add("veuillez renseigner le prix unitaire hors taxe  de l'article");
        }
        if(articleDto.getPrixUnitaireTtc() == null){
            errors.add("veuillez renseigner le prix unitaire toutes  taxe comprises  de l'article");
        }
        if(articleDto.getTauxTva() == null){
            errors.add("veuillez renseigner le taux TVA de l'article");
        }
        if(articleDto.getCategory() == null){
            errors.add("veuillez selectionner une categorie");
        }

        return  errors;
    }
}
