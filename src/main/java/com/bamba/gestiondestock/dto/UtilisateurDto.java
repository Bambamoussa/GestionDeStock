package com.bamba.gestiondestock.dto;

import com.bamba.gestiondestock.model.Adresse;
import com.bamba.gestiondestock.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class UtilisateurDto {

    private Integer id;

    private String nom;

    private String prenom;

    private String email;

    private String motDePasse;

    private Adresse adresse;

    private String photo;

    public Instant getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Instant dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    private Instant dateDeNaissance;

    private EntrepriseDto entreprise ;

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public EntrepriseDto getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(EntrepriseDto entreprise) {
        this.entreprise = entreprise;
    }

    public List<RolesDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RolesDto> roles) {
        this.roles = roles;
    }

    private List<RolesDto> roles;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur){

        if(utilisateur == null){
            return null;
        }
        return  UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .dateDeNaissance(utilisateur.getDateDeNaissance())
                .email(utilisateur.getPrenom())
                .motDePasse(utilisateur.getMotDePasse())
                .photo(utilisateur.getPhoto())
                .build();

    }

    public static Utilisateur toEntity(UtilisateurDto utilisateurDto){

        if(utilisateurDto == null){
            return null;
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPhoto(utilisateurDto.getPhoto());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setMotDePasse(utilisateurDto.getMotDePasse());
        utilisateur.setDateDeNaissance(utilisateurDto.getDateDeNaissance());

        return utilisateur;


    }

}
