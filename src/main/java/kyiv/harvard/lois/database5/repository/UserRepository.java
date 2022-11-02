/**
 * @author @liosyk
 * Project name: DataBase5
 * Package name: kyiv.harvard.lois.database5.repository
 * Interface: UserEntity
 **/

package kyiv.harvard.lois.database5.repository;

import kyiv.harvard.lois.database5.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Integer> {
}
