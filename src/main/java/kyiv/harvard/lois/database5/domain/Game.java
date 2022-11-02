/**
 * @author @liosyk
 * Project name: DataBase5
 * Package name: kyiv.harvard.lois.database5.domain
 * Class: GameEntity
 **/

package kyiv.harvard.lois.database5.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "game", schema = "steam_db", catalog = "")
public class Game {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "genre")
    private String genre;
    @Basic
    @Column(name = "rating")
    private Integer rating;
    @Basic
    @Column(name = "engine")
    private String engine;
//    @ManyToOne
//    @JoinColumn(name = "platform_id", referencedColumnName = "id", nullable = false)
//    private Platform platform;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game that = (Game) o;
        return Objects.equals(id, that.id) && Objects.equals(genre, that.genre) && Objects.equals(rating, that.rating) && Objects.equals(engine, that.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, genre, rating, engine);
    }

//    public Platform getPlatform() {
//        return platform;
//    }
//
//    public void setPlatform(Platform platform) {
//        this.platform = platform;
//    }
}
