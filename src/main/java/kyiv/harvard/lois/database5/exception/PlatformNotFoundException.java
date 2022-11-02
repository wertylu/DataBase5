/**
 * @author RoSteik (Telegram: @RoSteik)
 * Project: rostyk
 * Package: iot.lviv.ua.rostyk.exception
 * Class: TripNotFoundException
 */

package kyiv.harvard.lois.database5.exception;

public class PlatformNotFoundException extends RuntimeException {
    public PlatformNotFoundException(Integer id) {
        super("Could not find 'platform' with id = " + id);
    }
}
