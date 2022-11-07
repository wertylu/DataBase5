
package kyiv.harvard.lois.database5.service.impl;


import kyiv.harvard.lois.database5.domain.Game;
import kyiv.harvard.lois.database5.domain.Steam;
import kyiv.harvard.lois.database5.exception.SteamNotFoundException;
import kyiv.harvard.lois.database5.repository.PlatformRepository;
import kyiv.harvard.lois.database5.repository.SteamRepository;
import kyiv.harvard.lois.database5.repository.UserRepository;
import kyiv.harvard.lois.database5.service.SteamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SteamServiceImpl implements SteamService {

    @Autowired
    SteamRepository steamRepository;

    @Autowired
    UserRepository userRepository;



    @Override
    public List<Game> findGamesBySteamId(Integer steamId) {
        Steam steam = steamRepository.findById(steamId)
                .orElseThrow(() -> new SteamNotFoundException(steamId));
        return steam.getGames().stream().toList();
    }

    @Override
    public void addSteamHasGameRelationship(Integer moneyOnSteam, String gameGemre) {
        steamRepository.addSteamHasGameRelationship(moneyOnSteam, gameGemre);
    }

    @Override
    public List<Steam> findAll() {
        return steamRepository.findAll();
    }

    @Override
    public Steam findById(Integer id) {
        return steamRepository.findById(id)
                .orElseThrow(() -> new SteamNotFoundException(id));
    }

    @Override
    public Steam create(Steam steam) {
        steamRepository.save(steam);
        return steam;
    }

    @Override
    public void update(Integer id, Steam uSteam) {
        Steam steam = steamRepository.findById(id)
                .orElseThrow(() -> new SteamNotFoundException(id));
        steam.setMoneyOnSteam(uSteam.getMoneyOnSteam());
        steam.setNumberOfFriends(uSteam.getNumberOfFriends());

        steamRepository.save(steam);
    }

    @Override
    public void delete(Integer id) {
        Steam steam = steamRepository.findById(id)
                .orElseThrow(() -> new SteamNotFoundException(id));
        steamRepository.delete(steam);
    }
}
