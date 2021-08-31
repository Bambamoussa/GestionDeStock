package com.bamba.gestiondestock.dto.auth;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class AuthenticationRequest {
    @Getter
    @Setter
    private String login ;

    @Getter
    @Setter
    private String password;

    public AuthenticationRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
