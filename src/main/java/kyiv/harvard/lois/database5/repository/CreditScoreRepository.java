/**
 * @author @liosyk
 * Project name: DataBase5
 * Package name: kyiv.harvard.lois.database5.repository
 * Interface: CreditScoreRepository
 **/

package kyiv.harvard.lois.database5.repository;

import kyiv.harvard.lois.database5.domain.CreditScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CreditScoreRepository extends JpaRepository<CreditScore, Integer> {
}
