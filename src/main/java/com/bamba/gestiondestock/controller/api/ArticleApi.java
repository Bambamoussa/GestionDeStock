package com.bamba.gestiondestock.controller.api;

import com.bamba.gestiondestock.dto.ArticleDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.bamba.gestiondestock.utils.Constants.APP_ROOT;
import java.util.List;

@Api(APP_ROOT +"/articles")
public interface ArticleApi {
    @PostMapping(value = APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un article (Ajouter)", notes = "cette methode permet d'enregistrer ou modifier un article", response = ArticleDto.class)
    @ApiResponses(value ={@ApiResponse(code = 200, message = "L'objet article a été crée"),
                          @ApiResponse(code= 400, message = "l'article n'est pas valide"),
    })
    ArticleDto save(@RequestBody ArticleDto dto);

    @GetMapping(value = APP_ROOT + "/articles/{idArticle}", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un article par ID", notes = "cette methode permet de chercher un article par son ID", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code= 200, message = "l'article a été trouvé dans la BDD"),
            @ApiResponse(code= 404, message = "l'article n'a pas été trouvé dans la BDD"),
    })
    ArticleDto findById(@PathVariable("idArticle") Integer id);

    @GetMapping(value = APP_ROOT + "/articles/{codeArticle}", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)

    @ApiOperation(value = "Rechercher un article par CODE", notes = "cette methode permet de chercher un article par son CODE", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code= 200, message = "l'article a été trouvé dans la BDD"),
            @ApiResponse(code= 404, message = "Aucun article n'existe dans la BDD avec le CODE fourni"),
    })
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);

    @GetMapping(value = APP_ROOT + "/articles/all", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie la liste des articles", notes = "cette methode permet de chercher et de renvoyer la liste des articles qui existent dans la BDD", responseContainer = "List <ArticleDto>")
    @ApiResponses(value = {
            @ApiResponse(code= 200, message = "la liste des articles / une liste vide"),
    })
    List<ArticleDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/articles/delete/{idArticle}")

    @ApiOperation(value = "supprimer un article", notes = "cette methode permet de supprimer un article par son ID", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code= 200, message = "l'article a été supprimé dans la BDD"),
    })
    void delete (@PathVariable("idArticle") Integer id);
}
