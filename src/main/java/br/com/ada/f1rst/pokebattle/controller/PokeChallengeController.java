package br.com.ada.f1rst.pokebattle.controller;

import br.com.ada.f1rst.pokebattle.model.PokeChallengeRequest;
import br.com.ada.f1rst.pokebattle.model.PokeChallengeResponse;
import br.com.ada.f1rst.pokebattle.service.PokeChallengeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/challenge")
public class PokeChallengeController {

    private final PokeChallengeService pokeChallengeService;

    public PokeChallengeController(PokeChallengeService pokeChallengeService) {
        this.pokeChallengeService = pokeChallengeService;
    }

    @PostMapping
    public ResponseEntity<PokeChallengeResponse> getInfo(@RequestBody PokeChallengeRequest pokeChallengeRequest) {
        PokeChallengeResponse pokeChallengeResponse = pokeChallengeService.challenge(pokeChallengeRequest);
        return ResponseEntity.ok(pokeChallengeResponse);
    }
}
