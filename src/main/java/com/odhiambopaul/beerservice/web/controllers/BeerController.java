package com.odhiambopaul.beerservice.web.controllers;

import com.odhiambopaul.beerservice.services.BeerService;
import com.odhiambopaul.beerservice.web.model.BeerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDTO> saveNewBeer(@Validated @RequestBody BeerDTO beerDTO) {
        return new ResponseEntity<>(beerService.saveNewBeer(beerDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDTO> updateBeer(
            @PathVariable("beerId") UUID beerId, @Validated @RequestBody BeerDTO beerDTO) {
        return new ResponseEntity<>(beerService.updateBeer(beerId, beerDTO), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity<BeerDTO> deleteBeerById(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.deleteBeerById(beerId), HttpStatus.NO_CONTENT);
    }
}
