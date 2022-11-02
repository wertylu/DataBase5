/**
 * Created by RoSteik (Telegram: @RoSteik)
 * Project name: rostyk
 * Package name: iot.lviv.ua.rostyk.service
 * Interface: DriverService
 */

package kyiv.harvard.lois.database5.service;



import kyiv.harvard.lois.database5.domain.Game;
import kyiv.harvard.lois.database5.domain.Steam;

import java.util.List;

public interface SteamService extends GeneralService<Steam, Integer> {
    List<Game> findGamesBySteamId(Integer steamId);
}
