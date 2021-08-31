package com.bamba.gestiondestock.services.impl;

import com.bamba.gestiondestock.dto.CategoryDto;
import com.bamba.gestiondestock.services.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService service;

    @Test
    public void shouldSaveCategoryWithSuccess(){
        CategoryDto expectedCategory = CategoryDto.builder()
                .code("test categorie")
                .designation("Designation test")
                .idEntreprise(1)
                .build();
        CategoryDto saveCategory = service.save(expectedCategory);

        assertNotNull(saveCategory);
        assertNotNull(saveCategory.getId());

        Assertions.assertEquals(expectedCategory.getCode(),saveCategory.getCode());
        Assertions.assertEquals(expectedCategory.getDesignation(),saveCategory.getDesignation());
        Assertions.assertEquals(expectedCategory.getIdEntreprise(),saveCategory.getIdEntreprise() );
    }
    


}