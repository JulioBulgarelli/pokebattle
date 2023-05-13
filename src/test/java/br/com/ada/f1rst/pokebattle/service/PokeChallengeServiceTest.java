package br.com.ada.f1rst.pokebattle.service;

import br.com.ada.f1rst.pokebattle.BaseTestContext;
import br.com.ada.f1rst.pokebattle.client.PokeApiClient;
import br.com.ada.f1rst.pokebattle.client.dto.Pokemon;
import br.com.ada.f1rst.pokebattle.client.dto.PokemonStat;
import br.com.ada.f1rst.pokebattle.client.dto.Stat;
import br.com.ada.f1rst.pokebattle.model.PokeChallengeRequest;
import br.com.ada.f1rst.pokebattle.model.PokeChallengeResponse;
import br.com.ada.f1rst.pokebattle.service.impl.PokeChallengeServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokeChallengeServiceTest extends BaseTestContext {

    @Autowired
    private PokeChallengeServiceImpl pokeChallengeService;

    @MockBean
    private PokeApiClient pokeApiClient;

    @Test
    void winnerIsChallenger() {
        PokemonStat pokemon1Stat1 = new PokemonStat();
        Stat stat1 = new Stat();
        stat1.setName("stat#1");
        pokemon1Stat1.setBaseStat(3);
        pokemon1Stat1.setStat(stat1);

        PokemonStat pokemon1Stat2 = new PokemonStat();
        Stat stat2 = new Stat();
        stat2.setName("stat#2");
        pokemon1Stat2.setBaseStat(20);
        pokemon1Stat2.setStat(stat2);

        Pokemon pokemon1 = new Pokemon();
        pokemon1.setName("rattata");
        pokemon1.setStats(List.of(pokemon1Stat1, pokemon1Stat2));
        Mockito.doReturn(pokemon1).when(pokeApiClient).getPokemonData("rattata");

        PokemonStat pokemon2Stat1 = new PokemonStat();
        Stat stat3 = new Stat();
        stat1.setName("stat#1");
        pokemon2Stat1.setBaseStat(6);
        pokemon2Stat1.setStat(stat3);

        PokemonStat pokemon2Stat2 = new PokemonStat();
        Stat stat4 = new Stat();
        stat4.setName("stat#2");
        pokemon2Stat2.setBaseStat(20);
        pokemon2Stat2.setStat(stat4);

        Pokemon pokemon2 = new Pokemon();
        pokemon2.setName("pikachu");
        pokemon2.setStats(List.of(pokemon2Stat1, pokemon2Stat2));
        Mockito.doReturn(pokemon2).when(pokeApiClient).getPokemonData("pikachu");

        PokeChallengeResponse pokeChallengeResponse = pokeChallengeService.challenge(PokeChallengeRequest.builder()
            .challenger(pokemon1.getName())
            .challenged(pokemon2.getName())
        .build());

        assertEquals("pikachu", pokeChallengeResponse.getWinner());
    }

    @Test
    void winnerIsChallenged() {
        PokemonStat pokemon1Stat1 = new PokemonStat();
        Stat stat1 = new Stat();
        stat1.setName("stat#1");
        pokemon1Stat1.setBaseStat(12);
        pokemon1Stat1.setStat(stat1);

        PokemonStat pokemon1Stat2 = new PokemonStat();
        Stat stat2 = new Stat();
        stat2.setName("stat#2");
        pokemon1Stat2.setBaseStat(20);
        pokemon1Stat2.setStat(stat2);

        Pokemon pokemon1 = new Pokemon();
        pokemon1.setName("rattata");
        pokemon1.setStats(List.of(pokemon1Stat1, pokemon1Stat2));
        Mockito.doReturn(pokemon1).when(pokeApiClient).getPokemonData("rattata");

        PokemonStat pokemon2Stat1 = new PokemonStat();
        Stat stat3 = new Stat();
        stat1.setName("stat#1");
        pokemon2Stat1.setBaseStat(6);
        pokemon2Stat1.setStat(stat3);

        PokemonStat pokemon2Stat2 = new PokemonStat();
        Stat stat4 = new Stat();
        stat4.setName("stat#2");
        pokemon2Stat2.setBaseStat(20);
        pokemon2Stat2.setStat(stat4);

        Pokemon pokemon2 = new Pokemon();
        pokemon2.setName("pikachu");
        pokemon2.setStats(List.of(pokemon2Stat1, pokemon2Stat2));
        Mockito.doReturn(pokemon2).when(pokeApiClient).getPokemonData("pikachu");

        PokeChallengeResponse pokeChallengeResponse = pokeChallengeService.challenge(PokeChallengeRequest.builder()
            .challenger(pokemon1.getName())
            .challenged(pokemon2.getName())
        .build());

        assertEquals("rattata", pokeChallengeResponse.getWinner());
    }

    @Test
    void draws() {
        PokemonStat pokemon1Stat1 = new PokemonStat();
        Stat stat1 = new Stat();
        stat1.setName("stat#1");
        pokemon1Stat1.setBaseStat(3);
        pokemon1Stat1.setStat(stat1);

        PokemonStat pokemon1Stat2 = new PokemonStat();
        Stat stat2 = new Stat();
        stat2.setName("stat#2");
        pokemon1Stat2.setBaseStat(20);
        pokemon1Stat2.setStat(stat2);

        Pokemon pokemon1 = new Pokemon();
        pokemon1.setName("rattata");
        pokemon1.setStats(List.of(pokemon1Stat1, pokemon1Stat2));
        Mockito.doReturn(pokemon1).when(pokeApiClient).getPokemonData("rattata");

        PokemonStat pokemon2Stat1 = new PokemonStat();
        Stat stat3 = new Stat();
        stat1.setName("stat#1");
        pokemon2Stat1.setBaseStat(3);
        pokemon2Stat1.setStat(stat3);

        PokemonStat pokemon2Stat2 = new PokemonStat();
        Stat stat4 = new Stat();
        stat4.setName("stat#2");
        pokemon2Stat2.setBaseStat(20);
        pokemon2Stat2.setStat(stat4);

        Pokemon pokemon2 = new Pokemon();
        pokemon2.setName("pikachu");
        pokemon2.setStats(List.of(pokemon2Stat1, pokemon2Stat2));
        Mockito.doReturn(pokemon2).when(pokeApiClient).getPokemonData("pikachu");

        PokeChallengeResponse pokeChallengeResponse = pokeChallengeService.challenge(PokeChallengeRequest.builder()
                .challenger(pokemon1.getName())
                .challenged(pokemon2.getName())
                .build());

        assertEquals("DRAW", pokeChallengeResponse.getWinner());
    }
}
