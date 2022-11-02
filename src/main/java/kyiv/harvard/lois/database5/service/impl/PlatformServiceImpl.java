

package kyiv.harvard.lois.database5.service.impl;


import kyiv.harvard.lois.database5.domain.Platform;
import kyiv.harvard.lois.database5.exception.PlatformNotFoundException;
import kyiv.harvard.lois.database5.repository.PlatformRepository;
import kyiv.harvard.lois.database5.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformServiceImpl implements PlatformService {

    @Autowired
    PlatformRepository platformRepository;


    @Override
    public List<Platform> findAll() {
        return platformRepository.findAll();
    }

    @Override
    public Platform findById(Integer id) {
        return platformRepository.findById(id)
                .orElseThrow(() -> new PlatformNotFoundException(id));
    }

    @Override
    public Platform create(Platform platform) {
        platformRepository.save(platform);
        return platform;
    }

    @Override
    public void update(Integer id, Platform uPlatform) {
        Platform platform = platformRepository.findById(id)
                .orElseThrow(() -> new PlatformNotFoundException(id));
        //update
        platform.setPlatformName(uPlatform.getPlatformName());


        platformRepository.save(platform);
    }

    @Override
    public void delete(Integer id) {
        Platform platform = platformRepository.findById(id)
                .orElseThrow(() -> new PlatformNotFoundException(id));
        platformRepository.delete(platform);
    }


}
