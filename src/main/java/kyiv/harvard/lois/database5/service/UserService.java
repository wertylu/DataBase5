/**
 * Created by RoSteik (Telegram: @RoSteik)
 * Project name: rostyk
 * Package name: iot.lviv.ua.rostyk.service
 * Interface: UserService
 */

package kyiv.harvard.lois.database5.service;

import kyiv.harvard.lois.database5.domain.User;

import java.util.List;

public interface UserService extends GeneralService<User, Integer> {
    List<User> findUsersByPlatformId(Integer platformId);
    User addUserWithProcedure(String name, Integer age);
    Integer getAverageAge();
}
