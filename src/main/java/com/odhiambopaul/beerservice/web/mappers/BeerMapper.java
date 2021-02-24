package com.odhiambopaul.beerservice.web.mappers;

import com.odhiambopaul.beerservice.domain.Beer;
import com.odhiambopaul.beerservice.web.model.BeerDTO;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {

    BeerDTO beerToBeerDto(Beer beer);

    BeerDTO beerToBeerDtoWithInventory(Beer beer);

    Beer beerDtoToBeer(BeerDTO dto);
}
