package com.bamba.gestiondestock.dto;

import com.bamba.gestiondestock.model.Article;
import com.bamba.gestiondestock.model.LigneVente;
import com.bamba.gestiondestock.model.Ventes;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LigneVenteDto {

    private Integer id;

    private VentesDto vente ;

    private BigDecimal quantite ;

    private  BigDecimal prixUnitaire;

    public Integer getIdEntreprise() {
        return idEntreprise;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    private Article article;
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

    public VentesDto getVente() {
        return vente;
    }

    public void setVente(VentesDto vente) {
        this.vente = vente;
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

    public static LigneVenteDto fromEntity(LigneVente ligneVente){

        if(ligneVente == null){
            return  null;
        }

        return  LigneVenteDto.builder()
                .id(ligneVente.getId())
                .quantite(ligneVente.getQuantite())
                .idEntreprise(ligneVente.getIdEntreprise())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .build();
    }

    public static LigneVente toEntity(LigneVenteDto ligneVenteDto){

        if(ligneVenteDto == null){
            return  null;
        }
        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(ligneVenteDto.getId());
        ligneVente.setQuantite(ligneVenteDto.getQuantite());
        ligneVente.setIdEntreprise(ligneVenteDto.getIdEntreprise());
        ligneVente.setPrixUnitaire(ligneVenteDto.getPrixUnitaire());

        return  ligneVente;
    }
}
