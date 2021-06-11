package com.odhiambopaul.beerservice.events;

import com.odhiambopaul.beerservice.web.model.BeerDTO;

public class BrewBeerEvent extends BeerEvent {
    public BrewBeerEvent(BeerDTO beerDTO) {
        super(beerDTO);
    }
}
