/**
 * @author @liosyk
 * Project name: DataBase5
 * Package name: kyiv.harvard.lois.database5.dto.assembler
 * Class: PlatformDtoAssembler
 **/

package kyiv.harvard.lois.database5.dto.assembler;

import kyiv.harvard.lois.database5.controller.PlatformController;
import kyiv.harvard.lois.database5.domain.Platform;
import kyiv.harvard.lois.database5.dto.PlatformDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PlatformDtoAssembler implements RepresentationModelAssembler<Platform, PlatformDto> {

    @Override
    public PlatformDto toModel(Platform entity) {
        PlatformDto platformDto = PlatformDto.builder()
                .id(entity.getId())
                .platformName(entity.getPlatformName())
                .build();
        Link selfLink = linkTo(methodOn(PlatformController.class).getPlatform(Math.toIntExact(platformDto.getId()))).withSelfRel();
        platformDto.add(selfLink);
        return platformDto;
    }

    @Override
    public CollectionModel<PlatformDto> toCollectionModel(Iterable<? extends Platform> entities) {
        CollectionModel<PlatformDto> platformDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(PlatformController.class).getAllPlatforms()).withSelfRel();
        platformDto.add(selfLink);
        return platformDto;
    }

    public CollectionModel<PlatformDto> toCollectionModel(Iterable<? extends Platform> entities, Link link) {
        CollectionModel<PlatformDto> platformDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        platformDtos.add(link);
        return platformDtos;
    }
}

