package com.odhiambopaul.beerservice.web.controllers;

import com.odhiambopaul.beerservice.web.model.BeerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
  @GetMapping("/{beerId}")
  public ResponseEntity<BeerDTO> getBeerById(@PathVariable("beerId") UUID beerId) {
    return new ResponseEntity<>(BeerDTO.builder().build(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<BeerDTO> saveNewBeer(@Validated @RequestBody BeerDTO beerDTO) {
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping("/{beerId}")
  public ResponseEntity<BeerDTO> updateBeer(
      @PathVariable("beerId") UUID beerId, @Validated @RequestBody BeerDTO beerDTO) {
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{beerId}")
  public ResponseEntity<BeerDTO> deleteBeerById(@PathVariable("beerId") UUID beerId) {
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
