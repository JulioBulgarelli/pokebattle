package br.com.ada.f1rst.pokebattle.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PokeInfo {

    private String name;
    private Integer height;
    private Integer weight;
    private List<String> locations;
    private List<PokeInfoStat> stats;
    private List<String> types;
}
