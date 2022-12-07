

package kyiv.harvard.lois.database5.service;



import kyiv.harvard.lois.database5.domain.Game;
import kyiv.harvard.lois.database5.domain.Steam;

import java.util.List;

public interface SteamService extends GeneralService<Steam, Integer> {
    List<Game> findGamesBySteamId(Integer steamId);
    void addSteamHasGameRelationship(Integer moneyOnSteam, String gameGenre);
}
