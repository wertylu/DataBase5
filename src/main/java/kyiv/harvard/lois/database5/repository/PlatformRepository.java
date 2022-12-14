/**
 * @author @liosyk
 * Project name: DataBase5
 * Package name: kyiv.harvard.lois.database5.repository
 * Interface: PlatformRepository
 **/

package kyiv.harvard.lois.database5.repository;

import kyiv.harvard.lois.database5.domain.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository  extends JpaRepository<Platform, Integer> {
}
