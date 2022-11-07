/**
 * @author @liosyk
 * Project name: DataBase5
 * Package name: kyiv.harvard.lois.database5.controller
 * Class: CreditScoreController
 **/

package kyiv.harvard.lois.database5.controller;

import kyiv.harvard.lois.database5.domain.CreditScore;
import kyiv.harvard.lois.database5.dto.CreditScoreDto;
import kyiv.harvard.lois.database5.dto.assembler.CreditScoreDtoAssembler;
import kyiv.harvard.lois.database5.service.CreditScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/creditScores")
public class CreditScoreController {

    @Autowired
    private CreditScoreService creditScoreService;
    @Autowired
    private CreditScoreDtoAssembler creditScoreDtoAssembler;

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<CreditScoreDto>> getAllCreditScores() {
        List<CreditScore> creditScores = creditScoreService.findAll();
        CollectionModel<CreditScoreDto> creditScoreDtos = creditScoreDtoAssembler.toCollectionModel(creditScores);
        return new ResponseEntity<>(creditScoreDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CreditScoreDto> getCreditScore(@PathVariable Integer id) {
        CreditScore creditScore = creditScoreService.findById(id);
        CreditScoreDto creditScoreDto = creditScoreDtoAssembler.toModel(creditScore);
        return new ResponseEntity<>(creditScoreDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<CreditScoreDto> addCreditScore(@RequestBody CreditScore creditScore) {
        CreditScore newCreditScore = creditScoreService.create(creditScore);
        CreditScoreDto creditScoreDto = creditScoreDtoAssembler.toModel(newCreditScore);
        return new ResponseEntity<>(creditScoreDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateCreditScore(@RequestBody CreditScore uCreditScore, @PathVariable Integer id) {
        creditScoreService.update(id, uCreditScore);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCreditScore(@PathVariable Integer id) {
        creditScoreService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
