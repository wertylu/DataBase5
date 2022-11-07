

package kyiv.harvard.lois.database5.controller;


import kyiv.harvard.lois.database5.domain.Game;
import kyiv.harvard.lois.database5.dto.GameDto;
import kyiv.harvard.lois.database5.dto.assembler.GameDtoAssembler;
import kyiv.harvard.lois.database5.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/games")
public class GameController {
    @Autowired
    private GameService gameService;
    @Autowired
    private GameDtoAssembler gameDtoAssembler;

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<GameDto>> getAllGames() {
        List<Game> games = gameService.findAll();
        CollectionModel<GameDto> gameDtos = gameDtoAssembler.toCollectionModel(games);
        return new ResponseEntity<>(gameDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{gameId}")
    public ResponseEntity<GameDto> getGame(@PathVariable Integer gameId) {
        Game game = gameService.findById(gameId);
        GameDto gameDto = gameDtoAssembler.toModel(game);
        return new ResponseEntity<>(gameDto, HttpStatus.OK);
    }

    @GetMapping(value = "/genre/{genre}")
    public ResponseEntity<CollectionModel<GameDto>> getGameByGenre(@PathVariable String genre) {
        List<Game> games = gameService.findGameByGenre(genre);
        CollectionModel<GameDto> gameDtos = gameDtoAssembler.toCollectionModel(games);
        return new ResponseEntity<>(gameDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<GameDto> addGame(@RequestBody Game game) {
        Game newGame = gameService.create(game);
        GameDto gameDto = gameDtoAssembler.toModel(newGame);
        return new ResponseEntity<>(gameDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{gameId}")
    public ResponseEntity<?> updateGame(@RequestBody Game uGame, @PathVariable Integer gameId) {
        gameService.update(gameId, uGame);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{gameId}")
    public ResponseEntity<?> deleteGame(@PathVariable Integer gameId) {
        gameService.delete(gameId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping(value = "/cursor")
    public ResponseEntity<?> createTablesWithCursor() {
        gameService.createTablesWithCursor();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
