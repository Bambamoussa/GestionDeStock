package com.bamba.gestiondestock.dto;

import com.bamba.gestiondestock.model.CommandeClient;
import com.bamba.gestiondestock.model.CommandeFournisseur;
import lombok.Builder;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Builder
@Data
public class CommandeFournisseurDto {

    private Integer id;

    private String code;

    private Instant dateCommande;

    private FournisseurDto fournisseur;

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

    public FournisseurDto getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(FournisseurDto fournisseur) {
        this.fournisseur = fournisseur;
    }

    public List<LigneCommandeFournisseurDto> getLigneCommandeFournisseurs() {
        return ligneCommandeFournisseurs;
    }

    public void setLigneCommandeFournisseurs(List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs) {
        this.ligneCommandeFournisseurs = ligneCommandeFournisseurs;
    }

    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

    public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur){

        if(commandeFournisseur == null){
            return  null;
        }

        return  CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .idEntreprise(commandeFournisseur.getIdEntreprise())
                .dateCommande(commandeFournisseur.getDateCommande())
                .fournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
                .build();

    }

    public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto){

        if(commandeFournisseurDto == null){
            return  null;
        }

        CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
        commandeFournisseur.setId(commandeFournisseurDto.getId());
        commandeFournisseur.setCode(commandeFournisseurDto.getCode());
        commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
        commandeFournisseur.setIdEntreprise(commandeFournisseurDto.getIdEntreprise());
        commandeFournisseur.setFournisseur(FournisseurDto.toEntity(commandeFournisseurDto.getFournisseur()));

        return  commandeFournisseur;
    }

}
