package com.bamba.gestiondestock.dto;

import com.bamba.gestiondestock.model.CommandeClient;
import lombok.Builder;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Builder
@Data
public class CommandeClientDto {

    private Integer id;

    private String code;

    private Instant dateCommande;

    private ClientDto client;

    public Integer getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(Integer idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    private Integer idEntreprise ;

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

    public Instant getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Instant dateCommande) {
        this.dateCommande = dateCommande;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public List<LigneCommandeClientDto> getLigneCommandeClients() {
        return ligneCommandeClients;
    }

    public void setLigneCommandeClients(List<LigneCommandeClientDto> ligneCommandeClients) {
        this.ligneCommandeClients = ligneCommandeClients;
    }

    private List<LigneCommandeClientDto> ligneCommandeClients;

    public static CommandeClientDto fromEntity(CommandeClient commandeClient){

        if( commandeClient == null){

            return  null ;
        }

        return  CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .idEntreprise(commandeClient.getIdEntreprise())
                .client(ClientDto.fromEntity(commandeClient.getClient()))
                .build();
    }

    public static CommandeClient toEntity(CommandeClientDto commandeClientDto) {

        if (commandeClientDto == null) {

            return null;
        }
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setDateCommande(commandeClientDto.getDateCommande());
        commandeClient.setIdEntreprise(commandeClientDto.getIdEntreprise());
        commandeClient.setCode(commandeClientDto.getCode());
        return commandeClient;
    }
}
