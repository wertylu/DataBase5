/**
 * @author @liosyk
 * Project name: DataBase5
 * Package name: kyiv.harvard.lois.database5.dto.assembler
 * Class: CreditScoreDtoAssembler
 **/

package kyiv.harvard.lois.database5.dto.assembler;

import kyiv.harvard.lois.database5.controller.CreditScoreController;
import kyiv.harvard.lois.database5.domain.CreditScore;
import kyiv.harvard.lois.database5.dto.CreditScoreDto;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class CreditScoreDtoAssembler implements RepresentationModelAssembler<CreditScore, CreditScoreDto> {
    @Override
    public CreditScoreDto toModel(CreditScore entity) {
        CreditScoreDto creditScoreDto = CreditScoreDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
        Link selfLink = linkTo(methodOn(CreditScoreController.class).getCreditScore(creditScoreDto.getId())).withSelfRel();
        creditScoreDto.add(selfLink);
        return creditScoreDto;
    }

    @Override
    public CollectionModel<CreditScoreDto> toCollectionModel(Iterable<? extends CreditScore> entities) {
        CollectionModel<CreditScoreDto> creditScoreDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(CreditScoreController.class).getAllCreditScores()).withSelfRel();
        creditScoreDtos.add(selfLink);
        return creditScoreDtos;
    }
}
