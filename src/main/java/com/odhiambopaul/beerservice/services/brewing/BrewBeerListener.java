package com.odhiambopaul.beerservice.services.brewing;

import com.odhiambopaul.beerservice.config.JmsConfig;
import com.odhiambopaul.beerservice.domain.Beer;
import com.odhiambopaul.beerservice.events.BeerEvent;
import com.odhiambopaul.beerservice.events.NewInventoryEvent;
import com.odhiambopaul.beerservice.repositories.BeerRepository;
import com.odhiambopaul.beerservice.web.model.BeerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrewBeerListener {
    private final BeerRepository repository;
    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    public void listen(BeerEvent event) {
        BeerDTO dto = event.getBeerDTO();
        Beer beer = repository.getOne(dto.getId());
        dto.setQuantityOrdered(beer.getQuantityToBrew());
        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(dto);
        log.debug("Beer name " + beer.getBeerName() + " QOH " + dto.getQuantityOrdered());
        jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_EVENT, newInventoryEvent);
    }
}
