package com.odhiambopaul.beerservice.events;

import com.odhiambopaul.beerservice.web.model.BeerDTO;

public class NewInventoryEvent extends BeerEvent {
    public NewInventoryEvent(BeerDTO beerDTO) {
        super(beerDTO);
    }
}
