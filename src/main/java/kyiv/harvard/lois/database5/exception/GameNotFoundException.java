

package kyiv.harvard.lois.database5.exception;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(Integer id) {
        super("Could not find 'game' with id = " + id);
    }

}
