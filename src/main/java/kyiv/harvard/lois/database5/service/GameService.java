/**
 * Created by RoSteik (Telegram: @RoSteik)
 * Project name: rostyk
 * Package name: iot.lviv.ua.rostyk.service
 * Interface: CarService
 */

package kyiv.harvard.lois.database5.service;



import kyiv.harvard.lois.database5.domain.Game;

import java.util.List;

public interface GameService extends GeneralService<Game, Integer> {
    List<Game> findGameByGenre(String genre);
    void createTablesWithCursor();
}
