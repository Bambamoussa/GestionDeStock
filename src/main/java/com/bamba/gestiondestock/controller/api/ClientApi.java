package com.bamba.gestiondestock.controller.api;

import com.bamba.gestiondestock.dto.ClientDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bamba.gestiondestock.utils.Constants.APP_ROOT;

@Api(APP_ROOT +"/clients")
public interface ClientApi {

        @PostMapping(value = APP_ROOT + "/clients/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "Enregistrer un client  (Ajouter)", notes = "cette methode permet d'enregistrer ou modifier un client", response = ClientDto.class)
        @ApiResponses(value ={@ApiResponse(code = 200, message = "Le client a été crée"),
                @ApiResponse(code= 400, message = "le client n'est pas valide"),
        })
        ClientDto save(@RequestBody ClientDto dto);

        @GetMapping(value = APP_ROOT + "/clients/{idClient}", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "Rechercher un client par ID", notes = "cette methode permet de chercher un client par son ID", response = ClientDto.class)
        @ApiResponses(value = {
                @ApiResponse(code= 200, message = " le client a été trouvé dans la BDD"),
                @ApiResponse(code= 404, message = "Aucune  client n'existe dans la BDD"),
        })
        ClientDto findById(@PathVariable("idClient")Integer id);

        @GetMapping(value = APP_ROOT + "/clients/all", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "Renvoie la liste des clients", notes = "cette methode permet de chercher et de renvoyer la liste des clients qui existent dans la BDD", responseContainer = "List <ClientDto>")
        @ApiResponses(value = {
                @ApiResponse(code= 200, message = "la liste des clients / une liste vide"),
        })
        List<ClientDto> findAll() ;

        @DeleteMapping(value = APP_ROOT + "/clients/delete/{idClient}")

        @ApiOperation(value = "supprimer un client", notes = "cette methode permet de supprimer un client par son ID", response = ClientDto.class)
        @ApiResponses(value = {
                @ApiResponse(code= 200, message = "le client a été supprimé dans la BDD"),
        })
        void delete(@PathVariable("idClient}") Integer id);
}
