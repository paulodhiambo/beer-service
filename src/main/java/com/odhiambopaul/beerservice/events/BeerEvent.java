package com.odhiambopaul.beerservice.events;

import com.odhiambopaul.beerservice.web.model.BeerDTO;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@Builder
public class BeerEvent implements Serializable {
    static final long serialVersionUID = -2409411698277138046L;
    private final BeerDTO beerDTO;
}
