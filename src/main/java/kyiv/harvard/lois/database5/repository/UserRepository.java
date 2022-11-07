/**
 * @author @liosyk
 * Project name: DataBase5
 * Package name: kyiv.harvard.lois.database5.repository
 * Interface: UserEntity
 **/

package kyiv.harvard.lois.database5.repository;

import kyiv.harvard.lois.database5.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

public interface UserRepository  extends JpaRepository<User, Integer> {
    @Procedure("UserParamInsert")
    User addUserWithProcedure(String name, Integer age);


    @Query(value = "CALL CalcAverageAge();", nativeQuery = true)
    Integer getAverageAge();
}
