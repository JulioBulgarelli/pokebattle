package br.com.ada.f1rst.pokebattle.client;

import br.com.ada.f1rst.pokebattle.client.dto.LocationAreaEncounter;
import br.com.ada.f1rst.pokebattle.client.dto.Pokemon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "pokeApi", url = "https://pokeapi.co/api/v2")
public interface PokeApiClient {

    @GetMapping(value = "/pokemon/{name}", consumes = APPLICATION_JSON_VALUE)
    Pokemon getPokemonData(@PathVariable("name") String name);

    @GetMapping(value = "/pokemon/{name}/encounters", consumes = APPLICATION_JSON_VALUE)
    List<LocationAreaEncounter> getPokemonEncounters(@PathVariable("name") String name);
}
