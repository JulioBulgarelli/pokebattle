package br.com.ada.f1rst.pokebattle.service;

import br.com.ada.f1rst.pokebattle.model.PokeEvolutionsResponse;

public interface PokeEvolutionsService {

    PokeEvolutionsResponse getEvolutions(String pokemonName);
}
