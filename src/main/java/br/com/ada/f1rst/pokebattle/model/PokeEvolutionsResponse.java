package br.com.ada.f1rst.pokebattle.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PokeEvolutionsResponse {

    private List<String> forms;
}
