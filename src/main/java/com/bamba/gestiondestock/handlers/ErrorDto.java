package com.bamba.gestiondestock.handlers;

import com.bamba.gestiondestock.exception.ErrorCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * l'objet qu'on va renvoyer si l'on rencontre une exception
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {

    private  Integer httpCode;

    private ErrorCodes code;

    private  String message;

    private List<String> errors = new ArrayList<>();

}
