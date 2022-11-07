/**
 * @author @liosyk
 * Project name: DataBase5
 * Package name: kyiv.harvard.lois.database5.service.impl
 * Class: CreditScoreServiceImpl
 **/

package kyiv.harvard.lois.database5.service.impl;


import kyiv.harvard.lois.database5.domain.CreditScore;
import kyiv.harvard.lois.database5.exception.CreditScoreNotFoundException;
import kyiv.harvard.lois.database5.repository.CreditScoreRepository;
import kyiv.harvard.lois.database5.service.CreditScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditScoreServiceImpl implements CreditScoreService {
    @Autowired
    private CreditScoreRepository creditScoreRepository;

    @Override
    public List<CreditScore> findAll() {
        return creditScoreRepository.findAll();
    }

    @Override
    public CreditScore findById(Integer id) {
        return creditScoreRepository.findById(id)
                .orElseThrow(() -> new CreditScoreNotFoundException(id));
    }

    @Override
    public CreditScore create(CreditScore entity) {
        return creditScoreRepository.save(entity);
    }

    @Override
    public void update(Integer id, CreditScore newCreditScore) {
        CreditScore creditScore = creditScoreRepository.findById(id)
                .orElseThrow(() -> new CreditScoreNotFoundException(id));
        creditScore.setName(newCreditScore.getName());
        creditScoreRepository.save(creditScore);
    }

    @Override
    public void delete(Integer id) {
        CreditScore creditScore = creditScoreRepository.findById(id)
                .orElseThrow(() -> new CreditScoreNotFoundException(id));
        creditScoreRepository.delete(creditScore);
    }
}
