package br.com.ada.f1rst.pokebattle.client.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Pokemon {

    private Integer id;
    private String name;
    private Integer height;
    private Integer weight;
    private List<PokemonType> types;
    private List<PokemonStat> stats;
}
