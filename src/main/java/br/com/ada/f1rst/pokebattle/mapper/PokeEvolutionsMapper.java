package br.com.ada.f1rst.pokebattle.mapper;

import br.com.ada.f1rst.pokebattle.client.dto.ChainLink;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface PokeEvolutionsMapper {

    PokeEvolutionsMapper INSTANCE = Mappers.getMapper(PokeEvolutionsMapper.class);
    @Mapping(source = "pokemonForm.name", target = "empty")
    default List<String> convertChain(ChainLink chainLink) {
        List<String> evolutions = new ArrayList<>();
        evolutions.add(chainLink.getSpecies().getName());

        if (chainLink.getEvolvesTo() != null) {
            addRecursively(chainLink.getEvolvesTo(), evolutions);
        }

        return evolutions;
    }

    private void addRecursively(List<ChainLink> chainLinks, List<String> evolutions) {
        for (ChainLink chainLink : chainLinks) {
            evolutions.add(chainLink.getSpecies().getName());

            if (chainLink.getEvolvesTo() != null) {
                addRecursively(chainLink.getEvolvesTo(), evolutions);
            }
        }
    }
}
