/**
 * @author @liosyk
 * Project name: DataBase5
 * Package name: kyiv.harvard.lois.database5.dto.assembler
 * Class: SteamDtoAssembler
 **/

package kyiv.harvard.lois.database5.dto.assembler;

import kyiv.harvard.lois.database5.controller.SteamController;
import kyiv.harvard.lois.database5.domain.Steam;
import kyiv.harvard.lois.database5.dto.SteamDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SteamDtoAssembler implements RepresentationModelAssembler<Steam, SteamDto> {
    @Override
    public SteamDto toModel(Steam entity) {
        SteamDto steamDto = SteamDto.builder()
                .id(entity.getId())
                .moneyOnSteam(entity.getMoneyOnSteam())
                .numberOfFriends(entity.getNumberOfFriends())
                .build();
        Link selfLink = linkTo(methodOn(SteamController.class).getSteam(Math.toIntExact(steamDto.getId()))).withSelfRel();
        steamDto.add(selfLink);
        Link gameLink = linkTo(methodOn(SteamController.class).getAllGamesForSteam(Math.toIntExact(entity.getId()))).withRel("games");
        steamDto.add(gameLink);
        return steamDto;
    }

    @Override
    public CollectionModel<SteamDto> toCollectionModel(Iterable<? extends Steam> entities) {
        CollectionModel<SteamDto> steamDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(SteamController.class).getAllSteams()).withSelfRel();
        steamDtos.add(selfLink);
        return steamDtos;
    }

    public CollectionModel<SteamDto> toCollectionModel(Iterable<? extends Steam> entities, Link link) {
        CollectionModel<SteamDto> steamDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        steamDtos.add(link);
        return steamDtos;
    }
}