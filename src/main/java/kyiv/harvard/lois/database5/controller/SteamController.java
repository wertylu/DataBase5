

package kyiv.harvard.lois.database5.controller;


import kyiv.harvard.lois.database5.domain.Game;
import kyiv.harvard.lois.database5.domain.Steam;
import kyiv.harvard.lois.database5.dto.GameDto;
import kyiv.harvard.lois.database5.dto.SteamDto;
import kyiv.harvard.lois.database5.dto.assembler.GameDtoAssembler;
import kyiv.harvard.lois.database5.dto.assembler.SteamDtoAssembler;
import kyiv.harvard.lois.database5.service.SteamService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api/steams")
public class SteamController {
    @Autowired
    private SteamService steamService;
    @Autowired
    private SteamDtoAssembler steamDtoAssembler;
    @Autowired
    private GameDtoAssembler gameDtoAssembler;

    @GetMapping(value = "/{steamId}/games")
    public ResponseEntity<CollectionModel<GameDto>> getAllGamesForSteam(@PathVariable Integer steamId) {
        List<Game> games = steamService.findGamesBySteamId(steamId);
        Link selfLink = linkTo(methodOn(SteamController.class).getAllGamesForSteam(steamId)).withSelfRel();
        CollectionModel<GameDto> gameDtos = gameDtoAssembler.toCollectionModel(games, selfLink);
        return new ResponseEntity<>(gameDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{steamId}")
    public ResponseEntity<SteamDto> getSteam(@PathVariable Integer steamId) {
        Steam steam = steamService.findById(steamId);
        SteamDto steamDto = steamDtoAssembler.toModel(steam);
        return new ResponseEntity<>(steamDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<SteamDto>> getAllSteams() {
        List<Steam> steams = steamService.findAll();
        CollectionModel<SteamDto> steamDtos = steamDtoAssembler.toCollectionModel(steams);
        return new ResponseEntity<>(steamDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<SteamDto> addSteam(@RequestBody Steam steam) {
        Steam newSteam = steamService.create(steam);
        SteamDto steamDto = steamDtoAssembler.toModel(newSteam);
        return new ResponseEntity<>(steamDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{steamId}")
    public ResponseEntity<?> updateSteam(@RequestBody Steam uSteam, @PathVariable Integer steamId) {
        steamService.update(steamId, uSteam);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{steamId}")
    public ResponseEntity<?> deleteSteam(@PathVariable Integer steamId) {
        steamService.delete(steamId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional
    @PostMapping(value = "/relationship")
    public ResponseEntity<?> addDriverHasCarRelationship(@RequestBody JSONObject jsonObject) {
        steamService.addSteamHasGameRelationship(Integer.valueOf(jsonObject.getAsString("money_on_steam")), jsonObject.getAsString("game_genre"));
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
