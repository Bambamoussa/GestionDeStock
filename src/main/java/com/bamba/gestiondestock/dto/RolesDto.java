package com.bamba.gestiondestock.dto;

import com.bamba.gestiondestock.model.Roles;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RolesDto {

    private Integer id;

    private String roleName;

    private UtilisateurDto utilisateur ;

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public UtilisateurDto getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurDto utilisateur) {
        this.utilisateur = utilisateur;
    }
    public  RolesDto fromEntity(Roles roles){

        if(roles == null){
            return null;
        }

        return  RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .idEntreprise(roles.getIdEntreprise() )
                .build();
    }

    public Roles toEntity(RolesDto rolesDto){

        if(rolesDto == null){
            return  null;
        }

        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setRoleName(rolesDto.getRoleName());
        roles.setIdEntreprise(rolesDto.getIdEntreprise());

        return  roles;
    }
}
