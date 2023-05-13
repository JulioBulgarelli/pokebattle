package br.com.ada.f1rst.pokebattle.controller;

import br.com.ada.f1rst.pokebattle.model.PokeInfoResponse;
import br.com.ada.f1rst.pokebattle.service.PokeInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/info")
public class PokeInfoController {

    private final PokeInfoService pokeInfoService;

    public PokeInfoController(PokeInfoService pokeInfoService) {
        this.pokeInfoService = pokeInfoService;
    }

    @GetMapping("/{pokemon_name}")
    public ResponseEntity<PokeInfoResponse> getInfo(@PathVariable("pokemon_name") String pokemonName) {
        PokeInfoResponse pokeInfoResponse = pokeInfoService.getInfo(pokemonName);
        return ResponseEntity.ok(pokeInfoResponse);
    }
}
