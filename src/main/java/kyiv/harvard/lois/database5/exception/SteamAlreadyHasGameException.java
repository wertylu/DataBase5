/**
 * @author RoSteik (Telegram: @RoSteik)
 * Project: rostyk
 * Package: iot.lviv.ua.rostyk.exception
 * Class: DriverAlreadyHasCarException
 */

package kyiv.harvard.lois.database5.exception;

public class SteamAlreadyHasGameException extends RuntimeException {
    public SteamAlreadyHasGameException(Integer gameId, Integer steamId){
        super("'steam' with id=" + steamId +  " already have 'game' with id=" + gameId);
    }
}
