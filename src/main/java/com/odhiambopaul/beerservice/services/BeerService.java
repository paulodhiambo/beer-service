package com.odhiambopaul.beerservice.services;

import com.odhiambopaul.beerservice.web.model.BeerDTO;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID beerId);

    BeerDTO saveNewBeer(BeerDTO beerDTO);

    BeerDTO updateBeer(UUID beerId, BeerDTO beerDTO);

    BeerDTO deleteBeerById(UUID beerId);

}
