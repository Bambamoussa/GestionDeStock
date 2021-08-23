package com.bamba.gestiondestock.validator;

import com.bamba.gestiondestock.dto.VentesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VentesValidator {
    /**
     *
     * @param ventesDto
     * @return
     */
    public  static List<String> validate (VentesDto ventesDto){
        List<String> errors = new ArrayList<>();
        if(ventesDto == null){
            errors.add("veuillez renseigner la date de la vente ");
            errors.add("veuillez renseigner le code ");
            errors.add("veuillez renseigner le champ commentaire ");
            return  errors;
        }
        if(ventesDto.getDateVente() == null){
            errors.add("veuillez renseigner la date de la vente ");
        }

        if(!StringUtils.hasLength(ventesDto.getCode())){
            errors.add("veuillez renseigner le code ");
        }
        if(!StringUtils.hasLength(ventesDto.getCommentaire())){
            errors.add("veuillez renseigner le champ commentaire ");
        }
        return  errors;
    }
}
