package com.bamba.gestiondestock.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "fournisseur")
public class Fournisseur extends  AbstractEntity{
    @Column(name = "nom")
    private String nom ;

    @Embedded
    private Adresse adresse;

    @Column(name = "prenom")
    private String prenom ;

    public Integer getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(Integer idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @Column(name = "photo")
    private String photo ;

    @Column(name = "mail")
    private String mail ;

    @Column(name = "numTel")
    private String numTel ;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
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

    public List<CommandeFournisseur> getCommandeFournisseur() {
        return commandeFournisseur;
    }

    public void setCommandeFournisseur(List<CommandeFournisseur> commandeFournisseur) {
        this.commandeFournisseur = commandeFournisseur;
    }

    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> commandeFournisseur;
}
