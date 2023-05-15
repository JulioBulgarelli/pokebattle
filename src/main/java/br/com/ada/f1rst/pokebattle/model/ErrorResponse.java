package br.com.ada.f1rst.pokebattle.model;

import lombok.*;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private Integer statusCode;
    private String message;
    private String timestamp;
}
