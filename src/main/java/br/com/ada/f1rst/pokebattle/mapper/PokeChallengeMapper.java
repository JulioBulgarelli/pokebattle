package br.com.ada.f1rst.pokebattle.mapper;

import br.com.ada.f1rst.pokebattle.client.dto.PokemonStat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PokeChallengeMapper {

    PokeChallengeMapper INSTANCE = Mappers.getMapper(PokeChallengeMapper.class);

    @Mapping(source = "pokemonStat.baseStat", target = "empty")
    default Integer convertStats(List<PokemonStat> pokemonStats) {
        Integer stats = 0;

        for (PokemonStat pokemonStat : pokemonStats) {
            stats += pokemonStat.getBaseStat();
        }

        return stats;
    }
}
