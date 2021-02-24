package com.odhiambopaul.beerservice.services;

import com.odhiambopaul.beerservice.web.model.BeerDTO;

import java.util.UUID;

import com.odhiambopaul.beerservice.web.model.BeerPageList;
import com.odhiambopaul.beerservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

public interface BeerService {
    BeerPageList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);
    BeerDTO getBeerById(UUID beerId);

    BeerDTO saveNewBeer(BeerDTO beerDTO);

    BeerDTO updateBeer(UUID beerId, BeerDTO beerDTO);

    BeerDTO deleteBeerById(UUID beerId);

}
