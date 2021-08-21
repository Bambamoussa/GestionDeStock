package com.bamba.gestiondestock.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "mvtStk")
public class MvtStk extends  AbstractEntity{

    @Column(name = "datemvt")
    private Instant dateMvt;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    public Integer getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(Integer idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    @Column(name = "quantite")
    private BigDecimal quantite;

    public Instant getDateMvt() {
        return dateMvt;
    }

    public void setDateMvt(Instant dateMvt) {
        this.dateMvt = dateMvt;
    }

    public BigDecimal getQuantite() {
        return quantite;
    }

    public void setQuantite(BigDecimal quantite) {
        this.quantite = quantite;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public TypeMvtStock getTypeMvt() {
        return typeMvt;
    }

    public void setTypeMvt(TypeMvtStock typeMvt) {
        this.typeMvt = typeMvt;
    }

    @ManyToOne

    @JoinColumn(name = "idarticle")
    private Article article ;

    @Column(name = "typemvt")
    private  TypeMvtStock typeMvt;


}
