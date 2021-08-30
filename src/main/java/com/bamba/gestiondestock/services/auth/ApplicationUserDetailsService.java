package com.bamba.gestiondestock.services.auth;

import com.bamba.gestiondestock.dto.UtilisateurDto;
import com.bamba.gestiondestock.exception.EntityNotFoundException;
import com.bamba.gestiondestock.exception.ErrorCodes;
import com.bamba.gestiondestock.model.Utilisateur;
import com.bamba.gestiondestock.model.auth.ExtendedUser;
import com.bamba.gestiondestock.services.impl.UtilisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationUserDetailsService  implements UserDetailsService {

    @Autowired
    private UtilisateurServiceImpl utilisateurService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UtilisateurDto utilisateur =  utilisateurService.findByEmail(email);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        utilisateur.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));

        return new ExtendedUser(utilisateur.getEmail(),utilisateur.getMotDePasse() ,utilisateur.getEntreprise().getId(),authorities);
    }
}
