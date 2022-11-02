

package kyiv.harvard.lois.database5.controller;



import kyiv.harvard.lois.database5.domain.User;
import kyiv.harvard.lois.database5.dto.UserDto;
import kyiv.harvard.lois.database5.dto.assembler.UserDtoAssembler;
import kyiv.harvard.lois.database5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDtoAssembler userDtoAssembler;

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<UserDto>> getAllUsers() {
        List<User> users = userService.findAll();
        CollectionModel<UserDto> userDtos = userDtoAssembler.toCollectionModel(users);
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer userId) {
        User user = userService.findById(userId);
        UserDto userDto = userDtoAssembler.toModel(user);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping(value = "platforms/{platformId}")
    public ResponseEntity<CollectionModel<UserDto>> getUsersByPlatformId(
            @PathVariable Integer platformId) {
        List<User> users = userService.findUsersByPlatformId(platformId);
        Link selfLink = linkTo(methodOn(UserController.class).getUsersByPlatformId(platformId))
                .withSelfRel();
        CollectionModel<UserDto> userDtos = userDtoAssembler.
                toCollectionModel(users, selfLink);
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<UserDto> addUser(@RequestBody User user) {
        User newUser = userService.create(user);
        UserDto userDto = userDtoAssembler.toModel(newUser);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<?> updateUser(@RequestBody User uUser, @PathVariable Integer userId) {
        userService.update(userId, uUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
        userService.delete(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
