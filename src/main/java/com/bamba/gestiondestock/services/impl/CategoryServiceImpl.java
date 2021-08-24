package com.bamba.gestiondestock.services.impl;

import com.bamba.gestiondestock.dto.CategoryDto;
import com.bamba.gestiondestock.exception.EntityNotFoundException;
import com.bamba.gestiondestock.exception.ErrorCodes;
import com.bamba.gestiondestock.exception.InvalidEntityException;
import com.bamba.gestiondestock.model.Category;
import com.bamba.gestiondestock.repository.CategoryRepository;
import com.bamba.gestiondestock.services.CategoryService;
import com.bamba.gestiondestock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public  CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository =categoryRepository ;
    }

    /**
     *
     * @param dto
     * @return
     */
    @Override
    public CategoryDto save(CategoryDto dto) {
        List<String> errors = CategoryValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error(" Category is not valid {}" , dto);
            throw new InvalidEntityException("la category n'est pas valide" , ErrorCodes.CATEGORY_NOT_VALID , errors);
        }
        Category category = categoryRepository.save(CategoryDto.toEntity(dto));
        return  CategoryDto.fromEntity(category);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public CategoryDto findById(Integer id) {
         if(id == null){
             log.error("Category ID is null");
             return  null ;
         }

         return categoryRepository.findById(id)
                 .map(CategoryDto::fromEntity)
                 .orElseThrow(()->new EntityNotFoundException(
                         "Aucune category avec l'ID = "+ id + "n'a été trouvé dans la BDD",
                         ErrorCodes.CATEGORY_NOT_FOUND)
                 );

    }

    /**
     *
     * @param code
     * @return
     */
    @Override
    public CategoryDto findByCode(String code) {
        if(StringUtils.hasLength(code)){
            log.error("Category CODE is null");
            return  null;
        }
        return categoryRepository.findCategoryByCode(code)
                .map(CategoryDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException(
                        "Aucune category avec le CODE = "+code+"n'a été trouvé dans la  BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND)
                );
    }

    /**
     *
     * @return
     */
    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    /**
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Category ID is null");
            return;
        }
        categoryRepository.deleteById(id);

    }
}
