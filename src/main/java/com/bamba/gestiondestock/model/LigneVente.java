package com.bamba.gestiondestock.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "lignevente")
public class LigneVente extends  AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "idvente")
    private Ventes vente ;

    public Integer getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(Integer idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    @Column(name = "identreprise")
    private Integer idEntreprise;

    public Ventes getVente() {
        return vente;
    }

    public void setVente(Ventes vente) {
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

    @Column(name = "quantite")
    private BigDecimal quantite ;

    @Column(name = "prixunitaire")
    private  BigDecimal prixUnitaire;

}
