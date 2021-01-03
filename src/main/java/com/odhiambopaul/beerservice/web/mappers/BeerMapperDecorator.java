package com.odhiambopaul.beerservice.web.mappers;

import com.odhiambopaul.beerservice.domain.Beer;
import com.odhiambopaul.beerservice.services.inventory.BeerInventoryService;
import com.odhiambopaul.beerservice.web.model.BeerDTO;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BeerMapperDecorator implements BeerMapper {
    private BeerInventoryService beerInventoryService;
    private BeerMapper mapper;

    @Autowired
    public void setBeerInventoryService(BeerInventoryService beerInventoryService) {
        this.beerInventoryService = beerInventoryService;
    }

    @Autowired
    public void setMapper(BeerMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public BeerDTO beerToBeerDto(Beer beer) {
        BeerDTO dto = mapper.beerToBeerDto(beer);
        dto.setQuantityOrdered(beerInventoryService.getOnhandInventory(beer.getId()));
        return dto;
    }

    @Override
    public Beer beerDtoToBeer(BeerDTO beerDto) {
        return mapper.beerDtoToBeer(beerDto);
    }
}
