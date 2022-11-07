/**
 * @author @liosyk
 * Project name: DataBase5
 * Package name: kyiv.harvard.lois.database5.dto
 * Class: CreditScoreDto
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
@Relation(itemRelation = "creditScore", collectionRelation = "creditScores")
public class CreditScoreDto extends RepresentationModel<CreditScoreDto> {
    private final Integer id;
    private final String name;
}
