package br.com.ada.f1rst.pokebattle.service.impl;

import br.com.ada.f1rst.pokebattle.client.PokeApiClient;
import br.com.ada.f1rst.pokebattle.client.dto.EvolutionChain;
import br.com.ada.f1rst.pokebattle.client.dto.Pokemon;
import br.com.ada.f1rst.pokebattle.client.dto.PokemonSpecies;
import br.com.ada.f1rst.pokebattle.mapper.PokeEvolutionsMapper;
import br.com.ada.f1rst.pokebattle.model.PokeEvolutionsResponse;
import br.com.ada.f1rst.pokebattle.service.PokeEvolutionsService;
import org.springframework.stereotype.Service;

@Service
public class PokeEvolutionsServiceImpl implements PokeEvolutionsService {

    private final PokeApiClient pokeApiClient;

    public PokeEvolutionsServiceImpl(PokeApiClient pokeApiClient) {
        this.pokeApiClient = pokeApiClient;
    }

    @Override
    public PokeEvolutionsResponse getEvolutions(String pokemonName) {
        Pokemon pokemon = pokeApiClient.getPokemonData(pokemonName);
        PokemonSpecies pokemonSpecies = pokeApiClient.getPokemonSpecies(pokemon.getSpecies().getName());

        String[] chainIdUrlSegments = pokemonSpecies.getEvolutionChainRef().getUrl().split("/");
        Integer chainId = Integer.valueOf(chainIdUrlSegments[chainIdUrlSegments.length - 1]);
        EvolutionChain evolutionChain = pokeApiClient.getPokemonEvolutionChain(chainId);

        return PokeEvolutionsResponse.builder()
            .forms(PokeEvolutionsMapper.INSTANCE.convertChain(evolutionChain.getChain()))
        .build();
    }
}
