package br.com.ada.f1rst.pokebattle.mapper;

import br.com.ada.f1rst.pokebattle.client.dto.LocationAreaEncounter;
import br.com.ada.f1rst.pokebattle.client.dto.Pokemon;
import br.com.ada.f1rst.pokebattle.client.dto.PokemonStat;
import br.com.ada.f1rst.pokebattle.client.dto.PokemonType;
import br.com.ada.f1rst.pokebattle.model.PokeInfoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface PokeInfoMapper {

    PokeInfoMapper INSTANCE = Mappers.getMapper(PokeInfoMapper.class);

    @Mapping(source = "pokemon.name", target = "name")
    @Mapping(source = "pokemon.height", target = "height")
    @Mapping(source = "pokemon.weight", target = "weight")
    PokeInfoResponse pokemonToPokeInfo(Pokemon pokemon);

    @Mapping(source = "locationAreaEncounter.locationArea", target = "empty")
    default List<String> convertLocations(List<LocationAreaEncounter> locationAreaEncounters) {
        return locationAreaEncounters.stream().map(l -> l.getLocationArea().getName()).toList();
    }

    @Mapping(source = "pokemonType.name", target = "empty")
    default List<String> convertTypes(List<PokemonType> pokemonTypes) {
        return pokemonTypes.stream().map(p -> p.getType().getName()).toList();
    }

    @Mapping(source = "pokemonStat.name", target = "empty")
    default Map<String, Integer>  convertStats(List<PokemonStat> pokemonStats) {
        Map<String, Integer> stats = new HashMap<>();

        for (PokemonStat pokemonStat : pokemonStats) {
            stats.put(pokemonStat.getStat().getName(), pokemonStat.getBaseStat());
        }

        return stats;
    }
}
