/**
 * @author @liosyk
 * Project name: DataBase5
 * Package name: kyiv.harvard.lois.database5.exception
 * Class: CreditScoreNotFoundExeption
 **/

package kyiv.harvard.lois.database5.exception;

public class CreditScoreNotFoundException extends RuntimeException {
    public CreditScoreNotFoundException(Integer id) {
        super("Can`t find credit score with id: " + id);
    }
}
