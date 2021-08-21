package com.bamba.gestiondestock.validator;

import com.bamba.gestiondestock.dto.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {
    public static List<String> validate (EntrepriseDto entrepriseDto) {

        List<String> errors = new ArrayList<>();

        if(entrepriseDto == null){
            errors.add("veuillez entrer le nom de l'entreprise");
            errors.add("veuillez entrer le code Fiscal de l'entreprise");
            errors.add("veuillez entrer l'email de l'entreprise");
            errors.add("veuillez entrer le nom de l'entreprise");
            errors.add("veuillez renseigner l'adresse de l'utilisateur");
            return  errors;
        }
        if(!StringUtils.hasLength(entrepriseDto.getNom())){
            errors.add("veuillez entrer le nom de l'entreprise");
        }
        if(!StringUtils.hasLength(entrepriseDto.getCodeFiscal())){
            errors.add("veuillez entrer le code Fiscal de l'entreprise");
        }
        if(!StringUtils.hasLength(entrepriseDto.getEmail())){
            errors.add("veuillez entrer l'email de l'entreprise");
        }
        if(!StringUtils.hasLength(entrepriseDto.getNom())){
            errors.add("veuillez entrer le nom de l'entreprise");
        }

        if(!StringUtils.hasLength(entrepriseDto.getNumTel())){
            errors.add("veuillez entrer le numero de téléphone de l'entreprise");
        }

        if(entrepriseDto.getAdresse() == null){
            errors.add("veuillez renseigner l'adresse  de l'utilisateur");
        }
        else {
            if(!StringUtils.hasLength(entrepriseDto.getAdresse().getAdresse1())){
                errors.add("le champ 'Adresse 1' est obligatoire");
            }
            if(!StringUtils.hasLength(entrepriseDto.getAdresse().getVille())){
                errors.add("le champ 'Ville' est obligatoire");
            }
            if(!StringUtils.hasLength(entrepriseDto.getAdresse().getCodePostale())){
                errors.add("le champ 'Code Postale' est obligatoire");
            }
            if(!StringUtils.hasLength(entrepriseDto.getAdresse().getPays())){
                errors.add("le champ 'Pays' est obligatoire");
            }

        }

        return  errors;
    }
}
