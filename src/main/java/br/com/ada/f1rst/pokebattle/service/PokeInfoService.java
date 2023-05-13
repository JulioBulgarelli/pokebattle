package br.com.ada.f1rst.pokebattle.service;

import br.com.ada.f1rst.pokebattle.model.PokeInfoResponse;

public interface PokeInfoService {

    PokeInfoResponse getInfo(String pokemonName);
}
