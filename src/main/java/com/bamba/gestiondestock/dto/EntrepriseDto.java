package com.bamba.gestiondestock.dto;

import com.bamba.gestiondestock.model.Entreprise;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Builder
@Data
public class EntrepriseDto {

    private Integer id;

    private String nom;

    private AdresseDto adresse;

    private String codeFiscal;

    private String photo;

    private  String email;

    private String numTel;

    private String siteWeb;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public AdresseDto getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDto adresse) {
        this.adresse = adresse;
    }

    public String getCodeFiscal() {
        return codeFiscal;
    }

    public void setCodeFiscal(String codeFiscal) {
        this.codeFiscal = codeFiscal;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public List<UtilisateurDto> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<UtilisateurDto> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    private List<UtilisateurDto> utilisateurs;

    public static EntrepriseDto fromEntity(Entreprise entreprise){

        if(entreprise == null){

            return  null;
        }

        return  EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .codeFiscal(entreprise.getCodeFiscal())
                .photo(entreprise.getPhoto())
                .email(entreprise.getEmail())
                .numTel(entreprise.getNumTel())
                .siteWeb(entreprise.getSiteWeb())
                .build();
    }

    public static Entreprise toEntity(EntrepriseDto entrepriseDto){

        if(entrepriseDto == null){
            return  null ;
        }

        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setEmail(entrepriseDto.getEmail());
        entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
        entreprise.setPhoto(entrepriseDto.getPhoto());
        entreprise.setNumTel(entrepriseDto.getNumTel());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setSiteWeb(entrepriseDto.getSiteWeb());

        return  entreprise;
    }
}
