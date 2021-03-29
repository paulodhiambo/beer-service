package com.odhiambopaul.beerservice.web.mappers;

import com.odhiambopaul.beerservice.domain.BeerOrderLine;
import com.odhiambopaul.beerservice.services.BeerService;
import com.odhiambopaul.beerservice.web.model.BeerDTO;
import com.odhiambopaul.beerservice.web.model.BeerOrderLineDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Optional;

public abstract class BeerOrderLineMapperDecorator implements BeerOrderLineMapper {

    private BeerService beerService;
    private BeerOrderLineMapper beerOrderLineMapper;

    @Autowired
    public void setBeerService(BeerService beerService) {
        this.beerService = beerService;
    }

    @Autowired
    @Qualifier("delegate")
    public void setBeerOrderLineMapper(BeerOrderLineMapper beerOrderLineMapper) {
        this.beerOrderLineMapper = beerOrderLineMapper;
    }

    @Override
    public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line) {
        BeerOrderLineDto orderLineDto = beerOrderLineMapper.beerOrderLineToDto(line);
        Optional<BeerDTO> beerDtoOptional = Optional.ofNullable(beerService.getBeerByUpc(line.getUpc()));

        beerDtoOptional.ifPresent(beerDto -> {
            orderLineDto.setBeerName(beerDto.getBeerName());
            orderLineDto.setBeerStyle(String.valueOf(beerDto.getBeerStyle()));
            orderLineDto.setPrice(beerDto.getPrice());
            orderLineDto.setBeerId(beerDto.getId());
        });

        return orderLineDto;
    }
}
