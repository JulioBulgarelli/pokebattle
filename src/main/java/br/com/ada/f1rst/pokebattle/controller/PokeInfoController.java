package br.com.ada.f1rst.pokebattle.controller;

import br.com.ada.f1rst.pokebattle.model.PokeInfo;
import br.com.ada.f1rst.pokebattle.service.PokeInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokeInfoController {

    private final PokeInfoService pokeInfoService;

    public PokeInfoController(PokeInfoService pokeInfoService) {
        this.pokeInfoService = pokeInfoService;
    }

    @GetMapping("/api/{pokemon_name}")
    public ResponseEntity<PokeInfo> getInfo(@PathVariable("pokemon_name") String pokemonName) {
        PokeInfo pokeInfo = pokeInfoService.getInfo(pokemonName);
        return ResponseEntity.ok(pokeInfo);
    }
}
