/**
 * @author @liosyk
 * Project name: DataBase5
 * Package name: kyiv.harvard.lois.database5.repository
 * Interface: GameRepository
 **/

package kyiv.harvard.lois.database5.repository;
import kyiv.harvard.lois.database5.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    List<Game> findGameByGenre(String genre);

    @Procedure("CreateTablesWithCursor")
    void createTablesWithCursor();
}

