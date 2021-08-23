package com.bamba.gestiondestock.dto;

import com.bamba.gestiondestock.model.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Builder
@Data
public class ClientDto {

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

    public List<CommandeClientDto> getCommandeClients() {
        return commandeClients;
    }

    public void setCommandeClients(List<CommandeClientDto> commandeClients) {
        this.commandeClients = commandeClients;
    }

    @JsonIgnore
    private List<CommandeClientDto> commandeClients;

    public static ClientDto fromEntity(Client client){
        if(client == null){
            return null;
        }

        return ClientDto.builder()
               .id(client.getId())
               .nom(client.getNom())
               .prenom(client.getPrenom())
               .photo(client.getPhoto())
                .idEntreprise(client.getIdEntreprise())
               .mail(client.getMail())
               .numTel(client.getNumTel())
               .build();
    }

    public static Client toEntity(ClientDto clientDto){
         if(clientDto == null){
             return  null;
         }
         Client client = new Client();
         client.setId(clientDto.getId());
         client.setMail(clientDto.getMail());
         client.setNom(clientDto.getNom());
         client.setPhoto(clientDto.getPhoto());
         client.setPrenom(clientDto.getPrenom());
         client.setIdEntreprise(clientDto.getIdEntreprise());
         client.setNumTel(clientDto.getNumTel());

         return client ;

    }
}
