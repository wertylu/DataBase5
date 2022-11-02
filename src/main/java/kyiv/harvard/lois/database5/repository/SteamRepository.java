/**
 * @author @liosyk
 * Project name: DataBase5
 * Package name: kyiv.harvard.lois.database5.repository
 * Interface: SteamRepository
 **/

package kyiv.harvard.lois.database5.repository;

import kyiv.harvard.lois.database5.domain.Steam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SteamRepository extends JpaRepository<Steam, Integer> {
}
