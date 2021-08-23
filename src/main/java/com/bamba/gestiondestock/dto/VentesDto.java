package com.bamba.gestiondestock.dto;

import com.bamba.gestiondestock.model.Ventes;
import lombok.Builder;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Builder
@Data
public class VentesDto {

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

    public Instant getDateVente() {
        return dateVente;
    }

    public void setDateVente(Instant dateVente) {
        this.dateVente = dateVente;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    private Integer id;

    private String code ;

    private Instant dateVente;

    private String commentaire;

    public List<LigneVenteDto> getLigneVentes() {
        return ligneVentes;
    }

    public void setLigneVentes(List<LigneVenteDto> ligneVentes) {
        this.ligneVentes = ligneVentes;
    }

    private List<LigneVenteDto> ligneVentes;

    public static VentesDto fromEntity(Ventes ventes){

        if(ventes == null){
            return null;
        }

        return  VentesDto.builder()
                .id(ventes.getId())
                .dateVente(ventes.getDateVente())
                .commentaire(ventes.getCommentaire())
                .code(ventes.getCode())
                .build();
    }

    public static Ventes toEntity( VentesDto ventesDto){
        if(ventesDto == null){
            return  null;
        }

        Ventes ventes =new Ventes();
        ventes.setCode(ventesDto.getCode());
        ventes.setId(ventesDto.getId());
        ventes.setDateVente(ventesDto.getDateVente());
        ventes.setCommentaire(ventesDto.getCommentaire());

        return  ventes;
    }
}
