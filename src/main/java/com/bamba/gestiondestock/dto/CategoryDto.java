package com.bamba.gestiondestock.dto;

import com.bamba.gestiondestock.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
 

import java.util.List;


@Data
@Builder
public class CategoryDto {

    private Integer id;

    private  String code;

    private  String designation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @JsonIgnore
    private List<ArticleDto> articles;

    public static CategoryDto fromEntity(Category category){

        if(category == null){
            return  null;
        }

        return CategoryDto.builder()
                .id(category.getId())
               .code(category.getCode())
               .designation(category.getDesignation())
               .build();
    }

    public static Category toEntity(CategoryDto categoryDto){

        if(categoryDto == null){
            return  null;
        }
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());

        return  category;
    }


}
