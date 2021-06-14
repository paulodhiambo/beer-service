package com.odhiambopaul.beerservice.events;

import com.odhiambopaul.beerservice.web.model.BeerDTO;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BeerEvent implements Serializable {
    static final long serialVersionUID = -2409411698277138046L;
    private BeerDTO beerDTO;
}
