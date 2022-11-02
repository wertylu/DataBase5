/**
 * @author RoSteik (Telegram: @RoSteik)
 * Project: rostyk
 * Package: iot.lviv.ua.rostyk.exception
 * Class: DriverNotFoundException
 */

package kyiv.harvard.lois.database5.exception;

public class SteamNotFoundException extends RuntimeException {
    public SteamNotFoundException(Integer id) {
        super("Could not find 'steam' with id = " + id);
    }
}
