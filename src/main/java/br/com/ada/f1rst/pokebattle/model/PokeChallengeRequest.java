package br.com.ada.f1rst.pokebattle.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PokeChallengeRequest {

    private String challenger;
    private String challenged;
}
