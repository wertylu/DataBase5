

package kyiv.harvard.lois.database5.service;



import kyiv.harvard.lois.database5.domain.Game;

import java.util.List;

public interface GameService extends GeneralService<Game, Integer> {
    List<Game> findGameByGenre(String genre);
    void createTablesWithCursor();
}
