package br.com.ada.f1rst.pokebattle.service;

import br.com.ada.f1rst.pokebattle.BaseTestContext;
import br.com.ada.f1rst.pokebattle.client.PokeApiClient;
import br.com.ada.f1rst.pokebattle.client.dto.*;
import br.com.ada.f1rst.pokebattle.model.PokeInfoResponse;
import br.com.ada.f1rst.pokebattle.service.impl.PokeInfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

class PokeInfoResponseServiceTest extends BaseTestContext {

    @Autowired
    private PokeInfoServiceImpl pokeInfoService;

    @MockBean
    private PokeApiClient pokeApiClient;

    @Test
    void returnsBasicData() {
        String pokemonName = "charmander";

        PokemonStat pokemonStat1 = new PokemonStat();
        Stat stat1 = new Stat();
        stat1.setName("stat#1");
        pokemonStat1.setBaseStat(3);
        pokemonStat1.setStat(stat1);

        PokemonStat pokemonStat2 = new PokemonStat();
        Stat stat2 = new Stat();
        stat2.setName("stat#2");
        pokemonStat2.setBaseStat(20);
        pokemonStat2.setStat(stat2);

        Type type1 = new Type();
        type1.setName("fire");

        PokemonType pokemonType = new PokemonType();
        pokemonType.setType(type1);

        Pokemon pokemon = new Pokemon();
        pokemon.setId(1);
        pokemon.setName(pokemonName);
        pokemon.setStats(List.of(pokemonStat1, pokemonStat2));
        pokemon.setTypes(List.of(pokemonType));

        Mockito.doReturn(pokemon).when(pokeApiClient).getPokemonData(anyString());

        PokeInfoResponse pokeInfoResponseResult = pokeInfoService.getInfo(pokemonName);

        assertEquals(pokemonName, pokeInfoResponseResult.getName());
    }
}
