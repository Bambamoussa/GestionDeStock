package com.bamba.gestiondestock.validator;

import com.bamba.gestiondestock.dto.RolesDto;

import java.util.ArrayList;
import java.util.List;

public class RoleValidator {
    public static List<String> validate(RolesDto rolesDto){

        List<String> errors = new ArrayList<>();

        if(rolesDto == null){
            errors.add("veuillez renseigner le role de l'utilisateur");
        }
        return  errors;
    }
}
