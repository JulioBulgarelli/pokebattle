package br.com.ada.f1rst.pokebattle.controller;

import br.com.ada.f1rst.pokebattle.model.PokeEvolutionsResponse;
import br.com.ada.f1rst.pokebattle.service.PokeEvolutionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/evolutions")
public class PokeEvolutionsController {

    private final PokeEvolutionsService pokeEvolutionsService;

    public PokeEvolutionsController(PokeEvolutionsService pokeEvolutionsService) {
        this.pokeEvolutionsService = pokeEvolutionsService;
    }

    @GetMapping("/{pokemon_name}")
    public ResponseEntity<PokeEvolutionsResponse> getInfo(@PathVariable("pokemon_name") String pokemonName) {
        PokeEvolutionsResponse pokeEvolutionsResponse = pokeEvolutionsService.getEvolutions(pokemonName);
        return ResponseEntity.ok(pokeEvolutionsResponse);
    }
}
