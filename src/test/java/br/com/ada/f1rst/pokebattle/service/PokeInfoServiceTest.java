package br.com.ada.f1rst.pokebattle.service;

import br.com.ada.f1rst.pokebattle.BaseTestContext;
import br.com.ada.f1rst.pokebattle.client.PokeApiClient;
import br.com.ada.f1rst.pokebattle.client.dto.Pokemon;
import br.com.ada.f1rst.pokebattle.model.PokeInfo;
import br.com.ada.f1rst.pokebattle.service.impl.PokeInfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

class PokeInfoServiceTest extends BaseTestContext {

    @Autowired
    private PokeInfoServiceImpl pokeInfoService;

    @MockBean
    private PokeApiClient pokeApiClient;

    @Test
    void returnsTheDesiredPokemon() {
        String pokemonName = "charmander";

        Pokemon pokemon = new Pokemon();
        pokemon.setId(1);
        pokemon.setName(pokemonName);

        Mockito.doReturn(pokemon).when(pokeApiClient).getPokemonData(anyString());

        PokeInfo pokeInfoResult = pokeInfoService.getInfo(pokemonName);

        assertEquals(pokemonName, pokeInfoResult.getName());
    }
}
