

package kyiv.harvard.lois.database5.controller;


import kyiv.harvard.lois.database5.domain.Platform;
import kyiv.harvard.lois.database5.dto.PlatformDto;
import kyiv.harvard.lois.database5.dto.assembler.PlatformDtoAssembler;
import kyiv.harvard.lois.database5.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/platforms")
public class PlatformController {
    @Autowired
    private PlatformService platformService;
    @Autowired
    private PlatformDtoAssembler platformDtoAssembler;


    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<PlatformDto>> getAllPlatforms() {
        List<Platform> platforms = platformService.findAll();
        CollectionModel<PlatformDto> platformDtos = platformDtoAssembler.toCollectionModel(platforms);
        return new ResponseEntity<>(platformDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{platformId}")
    public ResponseEntity<PlatformDto> getPlatform(@PathVariable Integer platformId) {
        Platform platform = platformService.findById(platformId);
        PlatformDto platformDto = platformDtoAssembler.toModel(platform);
        return new ResponseEntity<>(platformDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<PlatformDto> addPlatform(@RequestBody Platform platform) {
        Platform newPlatform = platformService.create(platform);
        PlatformDto platformDto = platformDtoAssembler.toModel(newPlatform);
        return new ResponseEntity<>(platformDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{platformId}")
    public ResponseEntity<?> updatePlatform(@RequestBody Platform uPlatform, @PathVariable Integer platformId) {
        platformService.update(platformId, uPlatform);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{platformId}")
    public ResponseEntity<?> deletePlatform(@PathVariable Integer platformId) {
        platformService.delete(platformId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
