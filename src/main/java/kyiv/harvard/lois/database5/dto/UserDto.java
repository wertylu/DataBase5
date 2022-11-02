/**
 * @author @liosyk
 * Project name: DataBase5
 * Package name: kyiv.harvard.lois.database5.dto
 * Class: UserDto
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
@Relation(itemRelation = "user", collectionRelation = "users")
public class UserDto extends RepresentationModel<UserDto> {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String platform;
}

