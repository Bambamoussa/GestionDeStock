package com.bamba.gestiondestock.dto;

import com.bamba.gestiondestock.model.MvtStk;
import com.bamba.gestiondestock.model.TypeMvtStock;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
public class MvtStkDto {

    private Integer id;

    private Instant dateMvt;

    private BigDecimal quantite;

    private ArticleDto article ;

    private TypeMvtStock typeMvt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public ArticleDto getArticle() {
        return article;
    }

    public void setArticle(ArticleDto article) {
        this.article = article;
    }

    public TypeMvtStock getTypeMvt() {
        return typeMvt;
    }

    public void setTypeMvt(TypeMvtStock typeMvt) {
        this.typeMvt = typeMvt;
    }

    public MvtStkDto fromEntity(MvtStk mvtStk){

        if(mvtStk == null){
            return  null;
        }

        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .quantite(mvtStk.getQuantite())
                .typeMvt(mvtStk.getTypeMvt())
                .build();
    }

    public MvtStk toEntity(MvtStkDto mvtStkDto){

        if (mvtStkDto == null){
            return  null;
        }
        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(mvtStkDto.getId());
        mvtStk.setDateMvt(mvtStkDto.getDateMvt());
        mvtStk.setTypeMvt(mvtStkDto.getTypeMvt());
        mvtStk.setQuantite(mvtStkDto.getQuantite());

        return  mvtStk;
    }
}
