package com.bamba.gestiondestock.dto;

import com.bamba.gestiondestock.model.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Builder
@Data
public class LigneCommandeClientDto {

    private Integer id;

    private ArticleDto article ;

    private CommandeClientDto commandeClient;

    private BigDecimal quantite ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArticleDto getArticle() {
        return article;
    }

    public void setArticle(ArticleDto article) {
        this.article = article;
    }

    public CommandeClientDto getCommandeClient() {
        return commandeClient;
    }

    public void setCommandeClient(CommandeClientDto commandeClient) {
        this.commandeClient = commandeClient;
    }

    public BigDecimal getQuantite() {
        return quantite;
    }

    public void setQuantite(BigDecimal quantite) {
        this.quantite = quantite;
    }

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    private  BigDecimal prixUnitaire;

    public  LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient){

        if(ligneCommandeClient == null){

            return  null;
        }

       return LigneCommandeClientDto.builder()
                .id(ligneCommandeClient.getId())
                .quantite(ligneCommandeClient.getQuantite())
                .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
                .build();
    }

    public  LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto){

        if(ligneCommandeClientDto == null){
            return  null;
        }
        LigneCommandeClient ligneCommandeClient =new LigneCommandeClient();
        ligneCommandeClient.setId(ligneCommandeClientDto.getId());
        ligneCommandeClient.setQuantite(ligneCommandeClientDto.getQuantite());
        ligneCommandeClient.setPrixUnitaire(ligneCommandeClientDto.getPrixUnitaire());

        return ligneCommandeClient;
    }
}

