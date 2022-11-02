/**
 * @author @liosyk
 * Project name: DataBase5
 * Package name: kyiv.harvard.lois.database5.dto
 * Class: GameDto
 **/

package kyiv.harvard.lois.database5.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "game", collectionRelation = "games")
public class GameDto extends RepresentationModel<GameDto> {
    private Integer id;
    private String genre;
    private Integer rating;
    private String engine;
}
