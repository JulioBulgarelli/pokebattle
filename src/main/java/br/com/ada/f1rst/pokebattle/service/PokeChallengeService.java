package br.com.ada.f1rst.pokebattle.service;

import br.com.ada.f1rst.pokebattle.model.PokeChallengeRequest;
import br.com.ada.f1rst.pokebattle.model.PokeChallengeResponse;

public interface PokeChallengeService {

    PokeChallengeResponse challenge(PokeChallengeRequest pokeChallengeRequest);
}
