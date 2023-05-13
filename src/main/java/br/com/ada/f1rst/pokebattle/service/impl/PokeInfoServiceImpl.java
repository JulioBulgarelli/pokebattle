package br.com.ada.f1rst.pokebattle.service.impl;

import br.com.ada.f1rst.pokebattle.client.PokeApiClient;
import br.com.ada.f1rst.pokebattle.client.dto.LocationAreaEncounter;
import br.com.ada.f1rst.pokebattle.client.dto.Pokemon;
import br.com.ada.f1rst.pokebattle.mapper.PokeInfoMapper;
import br.com.ada.f1rst.pokebattle.model.PokeInfoResponse;
import br.com.ada.f1rst.pokebattle.service.PokeInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokeInfoServiceImpl implements PokeInfoService {

    private final PokeApiClient pokeApiClient;

    public PokeInfoServiceImpl(PokeApiClient pokeApiClient) {
        this.pokeApiClient = pokeApiClient;
    }

    @Override
    public PokeInfoResponse getInfo(String pokemonName) {
        Pokemon pokemon = pokeApiClient.getPokemonData(pokemonName);
        List<LocationAreaEncounter> locationAreaEncounters = pokeApiClient.getPokemonEncounters(pokemonName);

        PokeInfoResponse pokeInfoResponse = PokeInfoMapper.INSTANCE.pokemonToPokeInfo(pokemon);
        pokeInfoResponse.setLocations(PokeInfoMapper.INSTANCE.convertLocations(locationAreaEncounters));

        return pokeInfoResponse;
    }
}
