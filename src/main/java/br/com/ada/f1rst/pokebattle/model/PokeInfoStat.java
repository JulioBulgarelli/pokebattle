package br.com.ada.f1rst.pokebattle.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PokeInfoStat {

    private String name;
    private Integer value;
}
