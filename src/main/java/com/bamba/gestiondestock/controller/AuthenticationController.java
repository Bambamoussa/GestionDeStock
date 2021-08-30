package com.bamba.gestiondestock.controller;

import com.bamba.gestiondestock.dto.auth.AuthenticationRequest;
import com.bamba.gestiondestock.dto.auth.AuthenticationResponse;
import com.bamba.gestiondestock.model.auth.ExtendedUser;
import com.bamba.gestiondestock.services.auth.ApplicationUserDetailsService;
import com.bamba.gestiondestock.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bamba.gestiondestock.utils.Constants.APP_ROOT;
import static com.bamba.gestiondestock.utils.Constants.AUTHENTICATION_ENDPOIND;

@RestController
@RequestMapping(AUTHENTICATION_ENDPOIND)
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager ;

    @Autowired
    private ApplicationUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());

        final String jwt = jwtUtil.generateToken((ExtendedUser) userDetails);

        return ResponseEntity.ok(AuthenticationResponse.builder().accessToken(jwt).build());
    }
}
