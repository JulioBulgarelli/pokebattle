package br.com.ada.f1rst.pokebattle.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
public class PokeInfoResponse {

    private String name;
    private Integer height;
    private Integer weight;
    private List<String> locations;
    private Map<String, Integer> stats;
    private List<String> types;
}
