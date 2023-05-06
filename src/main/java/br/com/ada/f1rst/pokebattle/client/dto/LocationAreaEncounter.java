package br.com.ada.f1rst.pokebattle.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocationAreaEncounter {

    @JsonProperty("location_area")
    private LocationArea locationArea;
}
