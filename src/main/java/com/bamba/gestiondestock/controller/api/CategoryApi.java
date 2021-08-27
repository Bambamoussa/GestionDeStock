package com.bamba.gestiondestock.controller.api;

import com.bamba.gestiondestock.dto.ArticleDto;
import com.bamba.gestiondestock.dto.CategoryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bamba.gestiondestock.utils.Constants.APP_ROOT;

@Api(APP_ROOT +"/cartegories")
public interface CategoryApi {

    @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une categories  (Ajouter)", notes = "cette methode permet d'enregistrer ou modifier une categorie", response = CategoryDto.class)
    @ApiResponses(value ={@ApiResponse(code = 200, message = "L'objet categorie a été crée"),
            @ApiResponse(code= 400, message = "la categorie n'est pas valide"),
    })
    CategoryDto save(@RequestBody CategoryDto dto);

    @GetMapping(value = APP_ROOT + "/categories/{idCategory}", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une categorie par ID", notes = "cette methode permet de chercher une categorie par son ID", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code= 200, message = " la categorie a été trouvé dans la BDD"),
            @ApiResponse(code= 404, message = "Aucune  categorie n'existe dans la BDD"),
    })
    CategoryDto findById(@PathVariable("idCategory")Integer id);

    @GetMapping(value = APP_ROOT + "/categories/{codeCategory}", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une category par CODE", notes = "cette methode permet de chercher une categorie par son CODE", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code= 200, message = "la category a été trouvé dans la BDD"),
            @ApiResponse(code= 404, message = "Aucune category n'existe dans la BDD avec le CODE fourni"),
    })
    CategoryDto findByCode(@PathVariable("codeCategory") String code);

    @GetMapping(value = APP_ROOT + "/categories/all", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie la liste des categories", notes = "cette methode permet de chercher et de renvoyer la liste des categories qui existent dans la BDD", responseContainer = "List <CategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code= 200, message = "la liste des categories / une liste vide"),
    })
    List<CategoryDto> findAll() ;

    @DeleteMapping(value = APP_ROOT + "/categories/delete/{idCategory}")

    @ApiOperation(value = "supprimer une categorie", notes = "cette methode permet de supprimer une categorie par son ID", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code= 200, message = "la categorie a été supprimé dans la BDD"),
    })
    void delete(@PathVariable("idCategory}") Integer id);
}
