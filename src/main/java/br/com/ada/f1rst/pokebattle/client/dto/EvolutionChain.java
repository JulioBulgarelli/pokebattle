package br.com.ada.f1rst.pokebattle.client.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EvolutionChain  {

    private Integer id;
    private ChainLink chain;
}
