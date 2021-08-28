package com.bamba.gestiondestock.utils;

public interface Constants {

    String APP_ROOT = "gestiondestock/v1";
    String COMMANDE_FOURNISSEUR_ENDPOINT = APP_ROOT+"/commandesfournisseurs";
    String CREATE_COMMANDE_FOURNISSEUR_ENDPOINT = COMMANDE_FOURNISSEUR_ENDPOINT+ "/create";
    String FIND_COMMANDE_FOURNISSEUR_BY_ID_ENDPOINT = COMMANDE_FOURNISSEUR_ENDPOINT + "/{idCommandeFournisseur}";
    String FIND_COMMANDE_FOURNISSEUR_BY_CODE_ENDPOINT = COMMANDE_FOURNISSEUR_ENDPOINT + "/{codeCommandeFournisseur}";
    String FIND_ALL_COMMANDE_FOURNISSEUR_ENDPOINT = COMMANDE_FOURNISSEUR_ENDPOINT + "/all";
    String DELETE_COMMANDE_FOURNISSEUR_ENDPOINT = COMMANDE_FOURNISSEUR_ENDPOINT + "/delete/{idCommandeFournisseur}";

    String FOURNISSEUR_ENDPOINT = APP_ROOT + "/fournisseur";
    String ENTREPRISE_ENDPOINT = APP_ROOT +"/entreprise";
    String UTILISATEUR_ENDPOINT = APP_ROOT+"/utilisateurs";
    String VENTES_ENDPOINT = APP_ROOT + "/ventes";
    String AUTHENTICATION_ENDPOIND= APP_ROOT + "/auth";
}
