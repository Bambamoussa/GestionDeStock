package com.bamba.gestiondestock.validator;

import com.bamba.gestiondestock.dto.CategoryDto;
import com.bamba.gestiondestock.model.Category;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public  static List<String> validate(CategoryDto categoryDto){
        List<String> errors = new ArrayList<>();

        if(categoryDto == null || !StringUtils.hasLength(categoryDto.getCode())){
            errors.add("veuillez renseigner le code de la categorie");
        }
        return  errors;
    }
}
