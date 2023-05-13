package br.com.ada.f1rst.pokebattle.service.impl;

import br.com.ada.f1rst.pokebattle.client.PokeApiClient;
import br.com.ada.f1rst.pokebattle.client.dto.Pokemon;
import br.com.ada.f1rst.pokebattle.mapper.PokeChallengeMapper;
import br.com.ada.f1rst.pokebattle.model.PokeChallengeRequest;
import br.com.ada.f1rst.pokebattle.model.PokeChallengeResponse;
import br.com.ada.f1rst.pokebattle.service.PokeChallengeService;
import org.springframework.stereotype.Service;

@Service
public class PokeChallengeServiceImpl implements PokeChallengeService {

    private final PokeApiClient pokeApiClient;

    public PokeChallengeServiceImpl(PokeApiClient pokeApiClient) {
        this.pokeApiClient = pokeApiClient;
    }

    @Override
    public PokeChallengeResponse challenge(PokeChallengeRequest pokeChallengeRequest) {
        Pokemon challenger = pokeApiClient.getPokemonData(pokeChallengeRequest.getChallenger());
        Integer challengerStats = PokeChallengeMapper.INSTANCE.convertStats(challenger.getStats());

        Pokemon challenged = pokeApiClient.getPokemonData(pokeChallengeRequest.getChallenged());
        Integer challengedStats = PokeChallengeMapper.INSTANCE.convertStats(challenged.getStats());

        if (challengedStats.equals(challengerStats)) {
            return PokeChallengeResponse.builder().winner("DRAW").build();
        } else if (challengedStats > challengerStats) {
            return PokeChallengeResponse.builder().winner(challenged.getName()).build();
        } else {
            return PokeChallengeResponse.builder().winner(challenger.getName()).build();
        }
    }
}
