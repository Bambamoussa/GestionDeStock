package com.bamba.gestiondestock.dto;

import com.bamba.gestiondestock.model.Fournisseur;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Builder
@Data
public class FournisseurDto {

    private Integer id;

    private String nom ;

    private AdresseDto adresse;

    private String prenom ;

    private String photo ;

    private String mail ;

    private String numTel ;

    public Integer getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(Integer idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    private Integer idEntreprise ;

    private List<CommandeFournisseurDto> commandeFournisseur;

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public List<CommandeFournisseurDto> getCommandeFournisseur() {
        return commandeFournisseur;
    }

    public void setCommandeFournisseur(List<CommandeFournisseurDto> commandeFournisseur) {
        this.commandeFournisseur = commandeFournisseur;
    }

    public static FournisseurDto fromEntity(Fournisseur fournisseur){

        if(fournisseur == null){
            return  null;
        }

        return FournisseurDto.builder()
               .id(fournisseur.getId())
               .nom(fournisseur.getNom())
               .prenom(fournisseur.getPrenom())
               .photo(fournisseur.getPhoto())
               .mail(fournisseur.getMail())
               .numTel(fournisseur.getNumTel())
                .idEntreprise(fournisseur.getIdEntreprise())
                .build();
    }

    public static Fournisseur toEntity(FournisseurDto fournisseurDto){

        if(fournisseurDto == null){
            return  null;
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setMail(fournisseurDto.getMail());
        fournisseur.setNom(fournisseurDto.getNom());
        fournisseur.setPrenom(fournisseurDto.getPrenom());
        fournisseur.setPhoto(fournisseurDto.getPhoto());
        fournisseur.setIdEntreprise(fournisseurDto.getIdEntreprise());
        fournisseur.setNumTel(fournisseurDto.getNumTel());
        fournisseur.setId(fournisseurDto.getId());

        return  fournisseur;
    }
}
