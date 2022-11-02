/**
 * @author RoSteik (Telegram: @RoSteik)
 * Project: rostyk
 * Package: iot.lviv.ua.rostyk.service.impl
 * Class: UserServiceImpl
 */

package kyiv.harvard.lois.database5.service.impl;


import kyiv.harvard.lois.database5.domain.Platform;
import kyiv.harvard.lois.database5.domain.User;
import kyiv.harvard.lois.database5.exception.PlatformNotFoundException;
import kyiv.harvard.lois.database5.exception.UserNotFoundException;
import kyiv.harvard.lois.database5.repository.PlatformRepository;
import kyiv.harvard.lois.database5.repository.UserRepository;
import kyiv.harvard.lois.database5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PlatformRepository platformRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Transactional
    public User create(User user) {
        userRepository.save(user);
        return user;
    }

    @Transactional
    public void update(Integer id, User uUser) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        //update
        user.setName(uUser.getName());
        user.setSurname(uUser.getSurname());
        user.setAge(uUser.getAge());
        userRepository.save(user);
    }

    @Transactional
    public void delete(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userRepository.delete(user);
    }

    @Override
    public List<User> findUsersByPlatformId(Integer platformId) {
        Platform platform = platformRepository.findById(platformId)
                .orElseThrow(() -> new PlatformNotFoundException(platformId));
        return platform.getUsers();
    }
}
