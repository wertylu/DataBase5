
package kyiv.harvard.lois.database5.dto.assembler;
import kyiv.harvard.lois.database5.controller.GameController;
import kyiv.harvard.lois.database5.domain.Game;
import kyiv.harvard.lois.database5.dto.GameDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class GameDtoAssembler implements RepresentationModelAssembler<Game, GameDto> {
    @Override
    public GameDto toModel(Game entity) {
        GameDto gameDto = GameDto.builder()
                .id(entity.getId())
                .genre(entity.getGenre())
                .rating(entity.getRating())
                .engine(entity.getEngine())
                .build();
        Link selfLink = linkTo(methodOn(GameController.class).getGame(Math.toIntExact(gameDto.getId()))).withSelfRel();
        gameDto.add(selfLink);
        return gameDto;
    }

    @Override
    public CollectionModel<GameDto> toCollectionModel(Iterable<? extends Game> entities) {
        CollectionModel<GameDto> gameDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(GameController.class).getAllGames()).withSelfRel();
        gameDtos.add(selfLink);
        return gameDtos;
    }

    public CollectionModel<GameDto> toCollectionModel(Iterable<? extends Game> entities, Link link) {
        CollectionModel<GameDto> gameDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        gameDtos.add(link);
        return gameDtos;
    }
}

