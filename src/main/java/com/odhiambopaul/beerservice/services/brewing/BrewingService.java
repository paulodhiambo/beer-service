package com.odhiambopaul.beerservice.services.brewing;

import com.odhiambopaul.beerservice.config.JmsConfig;
import com.odhiambopaul.beerservice.domain.Beer;
import com.odhiambopaul.beerservice.events.BeerEvent;
import com.odhiambopaul.beerservice.repositories.BeerRepository;
import com.odhiambopaul.beerservice.services.inventory.BeerInventoryService;
import com.odhiambopaul.beerservice.web.mappers.BeerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {
    private final BeerRepository repository;
    private final BeerInventoryService inventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;

    @Scheduled(fixedRate = 5000) //Every 5 seconds
    public void checkForLowInventory() {
        List<Beer> beers = repository.findAll();
        beers.forEach(beer -> {
            Integer inventoryQOH = inventoryService.getOnhandInventory(beer.getId());
            log.debug("Min onHand " + beer.getMinOrder());
            log.debug("Inventory is: " + inventoryQOH);

            if (beer.getMinOrder() >= inventoryQOH) {
                jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE, new BeerEvent(beerMapper.beerToBeerDto(beer)));

            }
        });
    }
}
