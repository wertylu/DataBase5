

package kyiv.harvard.lois.database5.exception;

public class PlatformNotFoundException extends RuntimeException {
    public PlatformNotFoundException(Integer id) {
        super("Could not find 'platform' with id = " + id);
    }
}
