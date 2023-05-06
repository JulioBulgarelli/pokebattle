package br.com.ada.f1rst.pokebattle.mapper;

import br.com.ada.f1rst.pokebattle.client.dto.LocationAreaEncounter;
import br.com.ada.f1rst.pokebattle.client.dto.Pokemon;
import br.com.ada.f1rst.pokebattle.client.dto.PokemonStat;
import br.com.ada.f1rst.pokebattle.client.dto.PokemonType;
import br.com.ada.f1rst.pokebattle.model.PokeInfo;
import br.com.ada.f1rst.pokebattle.model.PokeInfoStat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PokeInfoMapper {

    PokeInfoMapper INSTANCE = Mappers.getMapper(PokeInfoMapper.class);

    @Mapping(source = "pokemon.name", target = "name")
    @Mapping(source = "pokemon.height", target = "height")
    @Mapping(source = "pokemon.weight", target = "weight")
    //@Mapping(source = "locationAreaEncounters.locationArea.name", target = "locations")
    PokeInfo pokemonToPokeInfo(Pokemon pokemon, List<LocationAreaEncounter> locationAreaEncounters);

    List<String> convertLocations(List<LocationAreaEncounter> locationAreaEncounters);
    @Mapping(source = "locationArea.name", target = "empty")
    default String convertLocation(LocationAreaEncounter locationAreaEncounter) {
        return locationAreaEncounter.getLocationArea().getName();
    }

    List<String> convertTypes(List<PokemonType> pokemonTypes);
    @Mapping(source = "pokemonType.name", target = "empty")
    default String convertType(PokemonType pokemonType) {
        return pokemonType.getType().getName();
    }

    List<PokeInfoStat> convertStats(List<PokemonStat> pokemonStats);
    @Mapping(source = "pokemonStat.name", target = "empty")
    default PokeInfoStat convertStat(PokemonStat pokemonStat) {
        return PokeInfoStat.builder().name(pokemonStat.getStat().getName()).value(pokemonStat.getBaseStat()).build();
    }
}
