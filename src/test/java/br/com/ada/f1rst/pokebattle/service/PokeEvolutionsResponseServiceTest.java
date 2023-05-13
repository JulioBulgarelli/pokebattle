package br.com.ada.f1rst.pokebattle.service;

import br.com.ada.f1rst.pokebattle.BaseTestContext;
import br.com.ada.f1rst.pokebattle.client.PokeApiClient;
import br.com.ada.f1rst.pokebattle.client.dto.*;
import br.com.ada.f1rst.pokebattle.model.PokeEvolutionsResponse;
import br.com.ada.f1rst.pokebattle.service.impl.PokeEvolutionsServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

class PokeEvolutionsResponseServiceTest extends BaseTestContext {

    @Autowired
    private PokeEvolutionsServiceImpl pokeEvolutionsService;

    @MockBean
    private PokeApiClient pokeApiClient;

    @Test
    void returnsEvolutions() {
        String pokemonName = "charmander";

        Pokemon pokemon = new Pokemon();
        pokemon.setId(1);
        pokemon.setName(pokemonName);
        Mockito.doReturn(pokemon).when(pokeApiClient).getPokemonData(anyString());

        PokemonSpecies pokemonSpecies = new PokemonSpecies();
        pokemonSpecies.setId(1);
        pokemonSpecies.setName(pokemonName);

        PokemonSpecies pokemonSpecies1 = new PokemonSpecies();
        pokemonSpecies1.setId(1);
        pokemonSpecies1.setName(pokemonName + "#1");

        NamedAPIResource namedAPIResource1 = new NamedAPIResource();
        namedAPIResource1.setName(pokemonSpecies1.getName());
        namedAPIResource1.setUrl("/sdsadas/adsasdsa/dasdsada/1");
        pokemon.setSpecies(namedAPIResource1);
        pokemonSpecies.setEvolutionChainRef(namedAPIResource1);
        Mockito.doReturn(pokemonSpecies).when(pokeApiClient).getPokemonSpecies(anyString());

        ChainLink chainLink1 = new ChainLink();
        chainLink1.setSpecies(namedAPIResource1);

        PokemonSpecies pokemonSpecies2 = new PokemonSpecies();
        pokemonSpecies2.setId(2);
        pokemonSpecies2.setName(pokemonName + "#2");

        NamedAPIResource namedAPIResource2 = new NamedAPIResource();
        namedAPIResource2.setName(pokemonSpecies2.getName());
        namedAPIResource2.setUrl("/sdsadas/adsasdsa/dasdsada/2");

        ChainLink chainLink2 = new ChainLink();
        chainLink2.setSpecies(namedAPIResource2);

        PokemonSpecies pokemonSpecies3 = new PokemonSpecies();
        pokemonSpecies3.setId(3);
        pokemonSpecies3.setName(pokemonName + "#3");

        NamedAPIResource namedAPIResource3 = new NamedAPIResource();
        namedAPIResource3.setName(pokemonSpecies3.getName());
        namedAPIResource3.setUrl("/sdsadas/adsasdsa/dasdsada/3");

        ChainLink chainLink3 = new ChainLink();
        chainLink3.setSpecies(namedAPIResource3);

        chainLink2.setEvolvesTo(List.of(chainLink3));
        chainLink1.setEvolvesTo(List.of(chainLink2));

        EvolutionChain evolutionChain = new EvolutionChain();
        evolutionChain.setId(1);
        evolutionChain.setChain(chainLink1);
        Mockito.doReturn(evolutionChain).when(pokeApiClient).getPokemonEvolutionChain(anyInt());

        PokeEvolutionsResponse pokeInfoResult = pokeEvolutionsService.getEvolutions(pokemonName);

        assertEquals(3, pokeInfoResult.getForms().size());
    }
}
