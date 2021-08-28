package com.bamba.gestiondestock.controller.api;

import com.bamba.gestiondestock.dto.CommandeClientDto;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.bamba.gestiondestock.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/commandesClient")
public interface CommandeClientApi {

    @PostMapping(APP_ROOT+ "/commandesclients/create")
    ResponseEntity <CommandeClientDto> save(CommandeClientDto dto);

    @GetMapping(APP_ROOT + "/commandesclients/{idCommandeClient}")
    ResponseEntity <CommandeClientDto> findById(@PathVariable("idCommandeClient") Integer idCommandeClient);

    @GetMapping(APP_ROOT+ "/commandesclients/{codeCommandeClient}")
    ResponseEntity <CommandeClientDto> findByCode( @PathVariable("codeCommandeClient") String codeCommandeClient);

    @GetMapping(APP_ROOT + "/commandesclients/all")
    ResponseEntity<List<CommandeClientDto>> findAll();

    @DeleteMapping(APP_ROOT + "/commandesclients/delete/{idCommandeClient}")
    ResponseEntity delete (@PathVariable("idCommandeClient") Integer id);
}
