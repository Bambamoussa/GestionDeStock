package com.bamba.gestiondestock.services.auth;

import com.bamba.gestiondestock.exception.EntityNotFoundException;
import com.bamba.gestiondestock.exception.ErrorCodes;
import com.bamba.gestiondestock.model.Utilisateur;
import com.bamba.gestiondestock.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class ApplicationUserDetailsService  implements UserDetailsService {

    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public ApplicationUserDetailsService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email).orElseThrow(() ->
                new EntityNotFoundException("Aucun utilisateur avec l'email fourni", ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
        return new User(utilisateur.getEmail(), utilisateur.getMotDePasse(), Collections.emptyList());
    }
}
