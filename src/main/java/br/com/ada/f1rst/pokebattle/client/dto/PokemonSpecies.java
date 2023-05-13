package br.com.ada.f1rst.pokebattle.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PokemonSpecies {

    private Integer id;
    private String name;
    @JsonProperty("evolution_chain")
    private NamedAPIResource evolutionChainRef;
}
