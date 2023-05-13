package br.com.ada.f1rst.pokebattle.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ChainLink {

    @JsonProperty("evolves_to")
    private List<ChainLink> evolvesTo;
    private NamedAPIResource species;
}
