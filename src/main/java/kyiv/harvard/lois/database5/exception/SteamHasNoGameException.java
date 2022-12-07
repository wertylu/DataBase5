
package kyiv.harvard.lois.database5.exception;

public class SteamHasNoGameException extends RuntimeException {
    public SteamHasNoGameException(Integer gameId, Integer steamId){
        super("'steam' with id=" + steamId +  " doesn't have 'game' with id=" + gameId);
    }
}
