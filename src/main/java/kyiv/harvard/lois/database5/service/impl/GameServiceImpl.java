

package kyiv.harvard.lois.database5.service.impl;


import kyiv.harvard.lois.database5.domain.Game;
import kyiv.harvard.lois.database5.exception.GameNotFoundException;
import kyiv.harvard.lois.database5.repository.GameRepository;
import kyiv.harvard.lois.database5.repository.PlatformRepository;
import kyiv.harvard.lois.database5.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlatformRepository platformRepository;


    @Override
    public void createTablesWithCursor() {
        gameRepository.createTablesWithCursor();
    }


    @Override
    public List<Game> findGameByGenre(String genre) {
        return gameRepository.findGameByGenre(genre);
    }

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public Game findById(Integer id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException(id));
    }

    @Transactional
    public Game create(Game game) {
        gameRepository.save(game);
        return game;
    }

    @Transactional
    public void update(Integer id, Game uGame) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException(id));
        //update
        game.setGenre(uGame.getGenre());
        game.setRating(uGame.getRating());
        game.setEngine(uGame.getEngine());


        gameRepository.save(game);
    }

    @Transactional
    public void delete(Integer id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException(id));
        gameRepository.delete(game);
    }
}
