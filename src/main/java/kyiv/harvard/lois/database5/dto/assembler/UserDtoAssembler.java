/**
 * @author @liosyk
 * Project name: DataBase5
 * Package name: kyiv.harvard.lois.database5.dto.assembler
 * Class: UserDtoAssembler
 **/

package kyiv.harvard.lois.database5.dto.assembler;



import kyiv.harvard.lois.database5.controller.UserController;
import kyiv.harvard.lois.database5.domain.User;
import kyiv.harvard.lois.database5.dto.UserDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserDtoAssembler implements RepresentationModelAssembler<User, UserDto> {

    @Override
    public UserDto toModel(User entity) {
        UserDto userDto = UserDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .age(entity.getAge())
                .build();
        Link selfLink = linkTo(methodOn(UserController.class).getUser(Math.toIntExact(userDto.getId()))).withSelfRel();
        userDto.add(selfLink);
        return userDto;
    }

    @Override
    public CollectionModel<UserDto> toCollectionModel(Iterable<? extends User> entities) {
        CollectionModel<UserDto> userDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel();
        userDtos.add(selfLink);
        return userDtos;
    }

    public CollectionModel<UserDto> toCollectionModel(Iterable<? extends User> entities, Link link) {
        CollectionModel<UserDto> userDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        userDtos.add(link);
        return userDtos;
    }
}
