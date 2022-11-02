/**
 * @author @liosyk
 * Project name: DataBase5
 * Package name: kyiv.harvard.lois.database5.domain
 * Class: SteamEntity
 **/

package kyiv.harvard.lois.database5.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "steam", schema = "steam_db", catalog = "")
public class Steam {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "money_on_steam")
    private Integer moneyOnSteam;
    @Basic
    @Column(name = "number_of_friends")
    private Integer numberOfFriends;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToMany
    @JoinTable(name = "steam_has_game", catalog = "", schema = "steam_db", joinColumns = @JoinColumn(name = "steam_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id", nullable = false))
    private List<Game> games;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMoneyOnSteam() {
        return moneyOnSteam;
    }

    public void setMoneyOnSteam(Integer moneyOnSteam) {
        this.moneyOnSteam = moneyOnSteam;
    }

    public Integer getNumberOfFriends() {
        return numberOfFriends;
    }

    public void setNumberOfFriends(Integer numberOfFriends) {
        this.numberOfFriends = numberOfFriends;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Steam that = (Steam) o;
        return Objects.equals(id, that.id) && Objects.equals(moneyOnSteam, that.moneyOnSteam) && Objects.equals(numberOfFriends, that.numberOfFriends);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moneyOnSteam, numberOfFriends);
    }

    public User getUserByUserId() {
        return user;
    }

    public void setUserByUserId(User user) {
        this.user = user;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }


}
